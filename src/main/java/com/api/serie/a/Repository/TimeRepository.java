package com.api.serie.a.Repository;
import com.api.serie.a.Model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

    Time findByNome(String nome);
}