package com.api.serie.a.Controller;
import com.api.serie.a.Model.Jogador;
import com.api.serie.a.Service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping("/time/{timeId}")
    public List<Map<String, Object>> getJogadoresByTime(
            @PathVariable Long timeId,
            @RequestParam(required = false) String fields) {
        List<Jogador> jogadores = jogadorService.getJogadoresByTime(timeId);
        return filtrarJogadores(jogadores, fields);
    }

    @GetMapping("/posicao/{posicao}")
    public List<Map<String, Object>> getJogadoresByPosicao(
            @PathVariable String posicao,
            @RequestParam(required = false) String fields) {
        List<Jogador> jogadores = jogadorService.getJogadoresByPosicao(posicao);
        return filtrarJogadores(jogadores, fields);
    }

    private List<Map<String, Object>> filtrarJogadores(List<Jogador> jogadores, String fields) {
        if (fields != null && !fields.isEmpty()) {
            List<String> camposSolicitados = Arrays.asList(fields.split(","));
            return jogadores.stream()
                    .map(jogador -> filtrarCampos(jogador, camposSolicitados))
                    .collect(Collectors.toList());
        }
        return jogadores.stream()
                .map(this::toMap)
                .collect(Collectors.toList());
    }

    private Map<String, Object> filtrarCampos(Jogador jogador, List<String> campos) {
        return campos.stream()
                .collect(Collectors.toMap(
                        campo -> campo,
                        campo -> {
                            switch (campo) {
                                case "nome":
                                    return jogador.getNome();
                                case "numero":
                                    return jogador.getNumero();
                                case "posicao":
                                    return jogador.getPosicao();
                                case "aniversario":
                                    return jogador.getAniversario();
                                case "cidade":
                                    return jogador.getCidade();
                                case "fotoUrl":
                                    return jogador.getFotoUrl();
                                case "nacionalidade":
                                    return jogador.getNacionalidade();
                                default:
                                    return null;
                            }
                        }
                ));
    }

    private Map<String, Object> toMap(Jogador jogador) {
        return Map.of(
                "nome", jogador.getNome(),
                "numero", jogador.getNumero(),
                "posicao", jogador.getPosicao(),
                "aniversario", jogador.getAniversario(),
                "cidade", jogador.getCidade(),
                "fotoUrl", jogador.getFotoUrl(),
                "nacionalidade", jogador.getNacionalidade()
        );
    }
}