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
public class TimeService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private TimeRepository timeRepository;

    public List<Jogador> getJogadoresByTimeNome(String nomeTime) {
        Time time = timeRepository.findByNome(nomeTime);
        if (time != null) {
            return jogadorRepository.findByTimeId(Long.valueOf(time.getId()));
        }
        return Collections.emptyList();
    }

    public List<Time> getAllTimes() {
        return timeRepository.findAll();
    }


    public List<Jogador> getJogadoresByTimeEPosicao(String nomeTime, String posicao) {
        Time time = timeRepository.findByNome(nomeTime);
        if (time == null) {
            return Collections.emptyList();
        }
        return jogadorRepository.findByTimeIdAndPosicao(time.getId(), posicao);
    }

    public Time getTimeByNome(String nomeTime) {
        return timeRepository.findByNome(nomeTime);

    }
}