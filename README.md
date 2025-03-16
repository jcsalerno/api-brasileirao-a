# API do Campeonato Brasileiro Série A

Esta API fornece informações sobre times e jogadores do Campeonato Brasileiro Série A. Ela permite consultar times, jogadores por time, jogadores por posição e muito mais.

## Endpoints da API

### 1. Home

#### `GET  https://api-brasileirao-a.onrender.com`
Retorna uma página HTML simples com uma mensagem de carregamento e redireciona para a documentação e mais, após 3 segundos.

### 2. Times

#### `GET /api/times`
Retorna uma lista de todos os times.

#### `GET /api/times/{nomeTime}`
Retorna os detalhes de um time específico pelo nome.

#### `GET /api/times/{nomeTime}/jogadores`
Retorna uma lista de jogadores de um time específico.

#### `GET /api/times/{nomeTime}/jogadores/{posicao}`
Retorna uma lista de jogadores de um time específico filtrados por posição.

### 3. Jogadores

#### `GET /api/jogadores/time/{timeId}`
Retorna uma lista de jogadores de um time específico pelo ID do time.

**Parâmetro opcional:**
- `fields` - Define campos específicos a serem retornados, separados por vírgula.

#### `GET /api/jogadores/posicao/{posicao}`
Retorna uma lista de jogadores por posição.

**Parâmetro opcional:**
- `fields` - Define campos específicos a serem retornados, separados por vírgula.

> **Nota:** Alguns times podem não conter jogadores cadastrados ou informações completas sobre seus elencos.
> **Alguns times podem não retornar dados.**
> **NENHUMA FOTO AINDA ESTÁ DISPONÍVEL**
>**Requisições inválidas ou erros de servidor podem não ser tratados adequadamente.**

- **Ceará:** Buscar os números das camisas dos jogadores.
- **Corinthians:** Buscar o número das camisas e a data de nascimento (dia e mês) dos jogadores.
- **Cruzeiro:** Procurar informações sobre os laterais.
- **Fortaleza:** Buscar os números das camisas dos jogadores.
- **Grêmio:** Buscar os números das camisas dos jogadores.
- **Internacional:** Buscar mais informações sobre o goleiro Kauan e o atacante Ricardo Mathias.
- **Juventude:**
    - Buscar o local de nascimento de Wilker Ángel, Clébio (zagueiro), Daniel (camisa 8) e Emersom Batalla.
    - Buscar o número da camisa de Maurício Garcez.
