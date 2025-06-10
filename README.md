Consulta de CEP com API ViaCEP em Java

Exercicio que fiz para estudar consumo de API no java

Este projeto é uma aplicação simples em Java que consome a API pública [ViaCEP](https://viacep.com.br/) para buscar informações de endereço a partir do CEP informado pelo usuário. O resultado é exibido no console e também salvo em um arquivo json.

---

Funcionalidades

- Solicita um ou mais CEPs ao usuário.
- Consulta a API ViaCEP e retorna os dados do endereço.
- Exibe os dados formatados no console.
- Salva os endereços consultados em um arquivo `endereço.json`.
- Suporte a múltiplas consultas em uma única execução.

---

Tecnologias Utilizadas

- Java 21
- API HTTP (`java.net.http.HttpClient`)
- Biblioteca Gson para manipulação de JSON
- API pública ViaCEP

