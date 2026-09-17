# enem-quiz

Aplicação simples em Spring Boot + Thymeleaf que consome a API pública do
ENEM (https://api.enem.dev) e deixa a pessoa responder as questões pelo
navegador.

## Como rodar

```
./mvnw spring-boot:run
```

Depois é só abrir http://localhost:8080

## Como funciona (visão geral)

- `model/` — classes que representam o JSON que a API devolve
  (`Questao`, `Alternativa`, `RespostaEnemApi`). Os nomes dos atributos são
  iguais aos nomes dos campos no JSON pra o Jackson (biblioteca que
  converte JSON <-> objeto Java) preencher tudo sozinho.
- `service/EnemApiService` — a única classe que fala com a API do ENEM.
  Usa o `RestClient` do Spring pra fazer o GET em
  `https://api.enem.dev/v1/exams/{ano}/questions` e já recebe o resultado
  como objeto Java.
- `controller/QuizController` — comanda o fluxo do quiz:
  1. `GET /` — tela pra escolher ano e quantidade de questões
  2. `POST /iniciar` — busca as questões na API e guarda tudo na sessão
     HTTP (lista de questões, questão atual, número de acertos)
  3. `GET /questao` — mostra a questão atual
  4. `POST /responder` — recebe a letra marcada, confere se é a
     `correctAlternative` da questão e avança pra próxima
  5. `GET /resultado` — mostra o placar final

Não usa banco de dados: tudo fica guardado na sessão (`HttpSession`)
enquanto a pessoa está jogando, então dá pra entender o fluxo sem se
preocupar com JPA/repository.
