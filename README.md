# 🍔 Delivery Tracker API

API REST desenvolvida em **Java + Spring Boot** para gerenciamento de pedidos de um sistema de delivery.

O sistema permite autenticação de usuários utilizando JWT, cadastro de novos usuários, gerenciamento de pedidos e atualização do fluxo de entrega.

Este projeto foi desenvolvido como parte do **Tech Challenge**.

---

# 📚 Funcionalidades

## Autenticação

- Login utilizando JWT
- Cadastro de usuários
- Senhas criptografadas com BCrypt
- Apenas usuários autenticados podem acessar os recursos protegidos

---

## Pedidos

- Criar pedido
- Listar todos os pedidos
- Buscar pedido por ID
- Atualizar status
- Histórico de alterações de status

---

## Status do pedido

Os pedidos podem assumir os seguintes estados:

- RECEBIDO
- EM_PREPARO
- SAIU_PARA_ENTREGA
- ENTREGUE
- CANCELADO

Cada alteração fica registrada no histórico do pedido.

---

# 🚀 Tecnologias

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- SQLite
- JWT
- MapStruct
- Lombok
- Maven
- Jakarta Validation

---

# 🏛 Arquitetura

O projeto foi desenvolvido seguindo princípios de:

- Clean Code
- SOLID
- DDD (Domain Driven Design)

Organização em camadas:

```
Controller
↓

Service
↓

Repository
↓

Entity
```

Além disso são utilizados:

- DTO Request
- DTO Response
- Mapper
- Exception Handler
- Validators

---

# 📂 Estrutura do projeto

```
src
└── main
    ├── controller
    ├── domain
    │     ├── entity
    │     ├── dto
    │     │     ├── request
    │     │     └── response
    │     └── enums
    ├── repository
    ├── service
    ├── mapper
    ├── security
    ├── validation
    ├── exception
    └── config
```

---

# 📋 Pré-requisitos

Antes de executar o projeto é necessário possuir instalado:

- Java 21
- Maven 3.9+
- Git

---

# ▶️ Como executar

Clone o projeto

```bash
git clone https://github.com/leticiafdepaula/Delivery_tracker.git
```

Entre na pasta

```bash
cd Delivery_tracker
```

Instale as dependências

```bash
mvn clean install
```

Execute a aplicação

```bash
mvn spring-boot:run
```

A API ficará disponível em

```
http://localhost:8080
```

---

# 🔐 Autenticação

Realize o cadastro:

```
POST /auth/cadastro
```

Depois faça login:

```
POST /auth/login
```

O login retorna um JWT.

Utilize o token em todas as requisições protegidas.

Exemplo:

```
Authorization: Bearer SEU_TOKEN
```

---

# 📌 Endpoints

## Autenticação

| Método | Endpoint |
|---------|----------|
| POST | /auth/login |
| POST | /auth/cadastro |

---

## Pedidos

| Método | Endpoint |
|---------|----------|
| POST | /pedidos |
| GET | /pedidos |
| GET | /pedidos/{id} |
| PATCH | /pedidos/{id}/status |

---

# 💾 Banco de dados

O projeto utiliza SQLite.

O banco é criado automaticamente na primeira execução.

Arquivo:

```
delivery.db
```

---

# 🛡 Segurança

A aplicação utiliza:

- Spring Security
- JWT Authentication
- BCrypt Password Encoder

As rotas protegidas exigem autenticação via Bearer Token.

---

# 📦 Validações

Foram implementadas validações para:

- Cadastro de usuários
- Login
- Criação de pedidos
- Atualização de status
- Fluxo válido de mudança de status

---

# 🧪 Testes

O projeto possui testes unitários e de integração para validar:

- Serviços
- Regras de negócio
- Autenticação
- Endpoints da API

---

# 👨‍💻 Desenvolvido por

**Leticia Ferreira**

Tech Challenge — Delivery Tracker
