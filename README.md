# Person Api
<h4 align="center"> 🚧 PersonApi 🚀 Em construção... 🚧 </h4>

## Pré Requisitos
São necessários os seguintes pré-requisitos para a execução do sistema:
- Java >= 11
- Maven >= 3.8.4
- IDE de sua preferência. Para o desenvolvimento deste projeto foi utilizado o IntelliJ IDEA Community

## Resumo
Consiste em um sistema simples de gerenciamento de pessoas em API Rest com Spring Boot.

## Principais funcionalidades
- [X] CRUD de pessoas

## O que foi utilizado ate o momento?
1. Spring Boot 2.6.4
2. Spring Boot DevTools
3. Spring Boot Validations
4. Spring Boot Data
5. Lombok
6. MapStruct
7. PostgreSQL Driver

## Execução do Projeto
Altere as configurações de acesso a banco de dados em `src/main/resources/application.yml` (neste projeto foi utilizado o Postgres, mas pode-se escolher a base de dados de sua preferência):
```
spring:
  jpa:
    hibernate:
      ddl-auto: update
    database-platform: org.hibernate.dialect.PostgreSQLDialect

  datasource:
    driver-class-name: org.postgresql.Driver
    url: <DATABASE_URL>
    username: <DATABASE_USER>
    password: <DATABASE_PASSWORD>
```
Para executar o projeto no terminal execute o seguinte comando:
```
mvn spring-boot:run
```
Após executar o comando acesse:
```
http://localhost:8080/api/v1/person
```

### Referências
- [https://www.baeldung.com/intro-to-project-lombok](https://www.baeldung.com/intro-to-project-lombok)
- [https://mapstruct.org/](https://mapstruct.org/)
- [https://springframework.guru/using-mapstruct-with-project-lombok/](https://springframework.guru/using-mapstruct-with-project-lombok/)
