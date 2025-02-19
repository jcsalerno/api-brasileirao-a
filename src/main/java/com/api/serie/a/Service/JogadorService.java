package com.api.serie.a.Service;
import com.api.serie.a.Model.Jogador;
import com.api.serie.a.Model.Time;
import com.api.serie.a.Repository.JogadorRepository;
import com.api.serie.a.Repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public List<Jogador> getJogadoresByTime(Long timeId) {
        return jogadorRepository.findByTimeId(timeId);
    }

    public List<Jogador> getJogadoresByPosicao(String posicao) {
        return jogadorRepository.findByPosicao(posicao);
    }

    public List<Jogador> getJogadoresByTimeEPosicao(String nomeTime, String posicao) {
        TimeRepository timeRepository = null;
        Time time = timeRepository.findByNome(nomeTime);
        if (time == null) {
            return Collections.emptyList();
        }
        return jogadorRepository.findByTimeAndPosicao(time, posicao);
    }
}