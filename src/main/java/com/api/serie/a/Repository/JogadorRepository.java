package com.api.serie.a.Repository;
import com.api.serie.a.Model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    List<Jogador> findByTimeId(Long timeId);
    List<Jogador> findByNome(String nome);
    List<Jogador> findByNacionalidade(String nacionalidade);

}
