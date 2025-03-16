# API do Campeonato Brasileiro Série A

Esta API fornece informações sobre times e jogadores do Campeonato Brasileiro Série A. Ela permite consultar times, jogadores por time, jogadores por posição e muito mais.

## 📌 Endpoints da API

### 🔹 Home

🟢 **Requisição**

**Método:** GET  
**URL:** `https://api-brasileirao-a.onrender.com`

📤 **Resposta**

Retorna uma página HTML com uma mensagem de carregamento e redireciona para a documentação após 3 segundos.

---

### 🔹 Times

🟢 **Requisição**

**Método:** GET  
**URL:** `/api/times`

📤 **Resposta**

Retorna uma lista de todos os times.

---

🟢 **Requisição**

**Método:** GET  
**URL:** `/api/times/{nomeTime}`

📤 **Resposta**

Retorna os detalhes de um time específico pelo nome.

---

🟢 **Requisição**

**Método:** GET  
**URL:** `/api/times/{nomeTime}/jogadores`

📤 **Resposta**

Retorna uma lista de jogadores de um time específico.

---

🟢 **Requisição**

**Método:** GET  
**URL:** `/api/times/{nomeTime}/jogadores/{posicao}`

📤 **Resposta**

Retorna uma lista de jogadores de um time específico filtrados por posição.

---

### 🔹 Jogadores

🟢 **Requisição**

**Método:** GET  
**URL:** `/api/jogadores/time/{timeId}`

📥 **Parâmetro opcional:**
- `fields` - Define campos específicos a serem retornados, separados por vírgula.

📤 **Resposta**

Retorna uma lista de jogadores de um time específico pelo ID do time.

---

🟢 **Requisição**

**Método:** GET  
**URL:** `/api/jogadores/posicao/{posicao}`

📥 **Parâmetro opcional:**
- `fields` - Define campos específicos a serem retornados, separados por vírgula.

📤 **Resposta**

Retorna uma lista de jogadores por posição.



---

## 📌 Informações importantes

> **Nota:** Alguns times podem não conter jogadores cadastrados ou informações completas sobre seus elencos.
<br>
> **Alguns times podem não retornar dados.**
<br>
> **NENHUMA FOTO AINDA ESTÁ DISPONÍVEL**
<br>
>**Requisições inválidas ou erros de servidor podem não ser tratados adequadamente.**
<br>

- **Ceará:** Buscar os números das camisas dos jogadores.
- **Corinthians:** Buscar o número das camisas e a data de nascimento (dia e mês) dos jogadores.
- **Cruzeiro:** Procurar informações sobre os laterais.
- **Fortaleza:** Buscar os números das camisas dos jogadores.
- **Grêmio:** Buscar os números das camisas dos jogadores.
- **Internacional:** Buscar mais informações sobre o goleiro Kauan e o atacante Ricardo Mathias.
- **Juventude:**
    - Buscar o local de nascimento de Wilker Ángel, Clébio (zagueiro), Daniel (camisa 8) e Emersom Batalla.
    - Buscar o número da camisa de Maurício Garcez.
