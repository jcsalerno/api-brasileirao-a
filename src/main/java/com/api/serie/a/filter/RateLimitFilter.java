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

public class RateLimitFilter extends OncePerRequestFilter { // Remova @Component

    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Obtém o IP do cliente
        String clientIp = request.getRemoteAddr();

        // 2. Obtém ou cria um "balde" (Bucket) para o IP do cliente
        Bucket bucket = buckets.computeIfAbsent(clientIp, k -> createNewBucket());

        // 3. Tenta consumir um token do balde
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);

        // 4. Verifica se o token foi consumido com sucesso
        if (probe.isConsumed()) {
            // Se ainda há tokens disponíveis:
            // Adiciona o número de tokens restantes no cabeçalho da resposta
            response.addHeader("X-Rate-Limit-Remaining", String.valueOf(probe.getRemainingTokens()));

            // Permite que a requisição continue para o próximo filtro ou controlador
            filterChain.doFilter(request, response);
        } else {
            // Se não há tokens disponíveis:
            // Retorna um erro HTTP 429 (Too Many Requests)
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());

            // Adiciona uma mensagem de erro no corpo da resposta
            response.getWriter().write("Você excedeu o limite de 10 requisições por dia. Tente novamente amanhã.");
        }
    }

    // Método para criar um novo balde com limite de 10 requisições por dia
    private Bucket createNewBucket() {
        Bandwidth limit = Bandwidth.simple(10, Duration.ofDays(1));
        return Bucket4j.builder().addLimit(limit).build();
    }
}