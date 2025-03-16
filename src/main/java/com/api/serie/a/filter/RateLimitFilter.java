package com.api.serie.a.filter;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.ConsumptionProbe;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimitFilter extends OncePerRequestFilter {

    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String clientIp = request.getRemoteAddr();

        Bucket bucket = buckets.computeIfAbsent(clientIp, k -> createNewBucket());

        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);

        if (probe.isConsumed()) {

            response.addHeader("X-Rate-Limit-Remaining", String.valueOf(probe.getRemainingTokens()));

            filterChain.doFilter(request, response);
        } else {

            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());

            response.getWriter().write("Você excedeu o limite de 10 requisições por dia. Tente novamente amanhã.");
        }
    }

    private Bucket createNewBucket() {
        Bandwidth limit = Bandwidth.simple(10, Duration.ofDays(1));
        return Bucket4j.builder().addLimit(limit).build();
    }
}