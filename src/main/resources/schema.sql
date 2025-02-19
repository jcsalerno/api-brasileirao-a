CREATE TABLE teams (
    id INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cidade_sede VARCHAR(255) NOT NULL,
    estadio VARCHAR(255) NOT NULL,
    ano_fundacao INT NOT NULL
);

CREATE TABLE players (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    posicao VARCHAR(50) NOT NULL,
    aniversario DATE NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    foto_url VARCHAR(255),
    nacionalidade VARCHAR(100),
    time_id INT NOT NULL,
    FOREIGN KEY (time_id) REFERENCES teams(id) ON DELETE CASCADE
);
