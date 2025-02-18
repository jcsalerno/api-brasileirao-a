package com.api.serie.a.Service;
import com.api.serie.a.Model.Jogador;
import com.api.serie.a.Repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public List<Jogador> getJogadoresByTime(Long timeId) {
        return jogadorRepository.findByTimeId(timeId);
    }

    public List<Jogador>getJogadoresByNome(String nome) {
        return jogadorRepository.findByNome(nome);
    }

    public List<Jogador>getJogadoresByNacionalidade(String nacionalidade) {
        return jogadorRepository.findByNacionalidade(nacionalidade);
    }

    public Jogador createJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }
}
