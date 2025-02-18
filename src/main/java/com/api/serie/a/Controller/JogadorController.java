package com.api.serie.a.Controller;
import com.api.serie.a.Model.Jogador;
import com.api.serie.a.Service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping("time/{timeId}")
    public List<Jogador> getJogadoresByTime(@PathVariable Long timeId) {
        return jogadorService.getJogadoresByTime(timeId);
    }
}
