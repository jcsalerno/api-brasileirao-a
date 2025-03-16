package com.api.serie.a.Controller;
import com.api.serie.a.Model.Jogador;
import com.api.serie.a.Model.Time;
import com.api.serie.a.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/times")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public List<Time> getAllTimes() {
        return timeService.getAllTimes();
    }

    @GetMapping("/{nomeTime}")
    public Time getTimeByNome(@PathVariable String nomeTime) {
        return timeService.getTimeByNome(nomeTime);
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