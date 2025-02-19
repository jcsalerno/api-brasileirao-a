package com.api.serie.a.Controller;
import com.api.serie.a.Model.Jogador;
import com.api.serie.a.Model.Time;
import com.api.serie.a.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public List<Time> getAllTimes() {
        return timeService.getAllTimes();
    }

    @GetMapping("/{nome}/jogadores")
    public List<Jogador> getJogadoresByTimeNome(@PathVariable String nome) {
        return timeService.getJogadoresByTimeNome(nome);
    }

    @GetMapping("/{nomeTime}/jogadores/{posicao}")
    public List<Jogador> getJogadoresByTimeEPosicao(
            @PathVariable String nomeTime,
            @PathVariable String posicao
    ) {
        return timeService.getJogadoresByTimeEPosicao(nomeTime, posicao);
    }
}