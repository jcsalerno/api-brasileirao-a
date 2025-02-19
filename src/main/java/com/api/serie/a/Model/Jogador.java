package com.api.serie.a.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private int numero;
    private String posicao;

    @Column(name = "aniversario")
    private LocalDate aniversario;

    private String cidade;

    @Column(name = "foto_url")
    private String fotoUrl;

    private String nacionalidade;

    @ManyToOne
    @JoinColumn(name = "time_id")
    @JsonBackReference
    private Time time;
}