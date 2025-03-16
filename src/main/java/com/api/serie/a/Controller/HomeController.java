package com.api.serie.a.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Bem-vindo à API Brasileirão Série A 2025! Use os seguintes endpoints: " +
                "/api/times, /api/times/{nome}/jogadores, /api/jogadores/time/{timeId}, etc.\n\n" +
                "Para mais informações, acesse: https://front-end-brasileirao-serie-a.onrender.com/index.html";
    }
}