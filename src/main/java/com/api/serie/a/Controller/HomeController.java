package com.api.serie.a.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"pt-BR\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Carregando API...</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f8f9fa;\n" +
                "            color: #333333;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "            height: 100vh;\n" +
                "            margin: 0;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            padding: 20px;\n" +
                "            background-color: #ffffff;\n" +
                "            border-radius: 8px;\n" +
                "            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "\n" +
                "        h1 {\n" +
                "            font-size: 2rem;\n" +
                "            margin-bottom: 20px;\n" +
                "            color: #0d6efd;\n" +
                "        }\n" +
                "\n" +
                "        .loading {\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "            align-items: center;\n" +
                "            gap: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .soccer-ball {\n" +
                "            width: 80px;\n" +
                "            height: 80px;\n" +
                "            background-image: url('https://cdn-icons-png.flaticon.com/512/53/53283.png'); /* Imagem de uma bola de futebol */\n" +
                "            background-size: cover;\n" +
                "            animation: spin 2s linear infinite; /* Animação de rotação */\n" +
                "        }\n" +
                "\n" +
                "        @keyframes spin {\n" +
                "            0% {\n" +
                "                transform: rotate(0deg);\n" +
                "            }\n" +
                "            100% {\n" +
                "                transform: rotate(360deg);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            font-size: 1.2rem;\n" +
                "            color: #666;\n" +
                "        }\n" +
                "\n" +
                "        a {\n" +
                "            color: #0d6efd;\n" +
                "            text-decoration: none;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "\n" +
                "        a:hover {\n" +
                "            text-decoration: underline;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <script>\n" +
                "        // Redirecionamento após 3 segundos (simulando o carregamento)\n" +
                "        setTimeout(() => {\n" +
                "            window.location.href = \"https://front-end-brasileirao-serie-a.onrender.com/\";\n" +
                "        }, 3000); // 3 segundos\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"loading\">\n" +
                "            <div class=\"soccer-ball\"></div>\n" +
                "            <h1>Carregando API...</h1>\n" +
                "            <p>\n" +
                "                Aguarde enquanto redirecionamos você para a página do front-end.\n" +
                "                <br>\n" +
                "                Se o redirecionamento não funcionar, <a href=\"https://front-end-brasileirao-serie-a.onrender.com/\">clique aqui</a>.\n" +
                "            </p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}