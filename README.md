# API de Solicitações

Uma API robusta e escalável desenvolvida em Java com Spring Boot para gerenciar solicitações, utilizando múltiplas bancos de dados e mensageria assíncrona.

## 📋 Sobre o Projeto

A **API de Solicitações** é uma aplicação back-end moderna construída com as melhores práticas de desenvolvimento, integrando persistência de dados em PostgreSQL e MongoDB, processamento assíncrono com RabbitMQ, e documentação automática com Swagger/OpenAPI.

Este projeto segue padrões de arquitetura em camadas e implementa princípios SOLID para garantir manutenibilidade e escalabilidade.

## 🛠 Tecnologias

### Framework e Linguagem
- **Java 25** - Linguagem de programação principal
- **Spring Boot 4.1.0** - Framework Web e IoC Container
- **Spring Data JPA** - Abstração para acesso a dados relacionais
- **Spring Data MongoDB** - Abstração para acesso a dados NoSQL
- **Spring AMQP** - Integração com filas de mensagens

### Bancos de Dados
- **PostgreSQL 16** - Banco de dados relacional principal
- **MongoDB** - Banco de dados NoSQL para dados não estruturados
- **H2 Database** - Banco de dados em memória para testes

### Ferramentas e Utilitários
- **Lombok** - Redução de boilerplate de código Java
- **ModelMapper 3.2.6** - Mapeamento automático de DTOs e Entities
- **SpringDoc OpenAPI 3.0.3** - Documentação interativa de API (Swagger UI)
- **Spring Validation** - Validação de dados com anotações
- **RabbitMQ 3** - Message Broker para processamento assíncrono

### Build e Deploy
- **Maven** - Gerenciador de dependências e build
- **Docker Compose** - Orquestração de containers para desenvolvimento
- **Spring Boot DevTools** - Reload automático durante desenvolvimento

## 🏗 Arquitetura

### Estrutura de Camadas

```
src/
├── main/
│   └── java/br/com/cotiinformatica/
│       ├── controllers/      # Endpoints REST (Controllers)
│       ├── services/         # Lógica de negócio (Services)
│       ├── repositories/     # Acesso a dados (DAOs/Repositories)
│       ├── entities/         # Modelos de dados (Entities/Documents)
│       ├── dtos/             # Data Transfer Objects
│       ├── exceptions/       # Tratamento de exceções customizadas
│       ├── config/           # Configurações da aplicação
│       └── Application.java  # Classe principal
└── test/
    └── java/                 # Testes unitários e de integração
```

### Padrões de Design Utilizados

1. **MVC (Model-View-Controller)** - Separação de responsabilidades entre apresentação, lógica e dados
2. **Repository Pattern** - Abstração para acesso aos dados através do Spring Data
3. **Service Layer** - Encapsulamento da lógica de negócio
4. **DTO (Data Transfer Object)** - Transferência segura de dados entre camadas
5. **Dependency Injection** - Injeção de dependências através do Spring Container
6. **Async Processing** - Processamento assíncrono com RabbitMQ para operações pesadas

### Fluxo de Dados

```
Request HTTP
    ↓
Controller (REST Endpoint)
    ↓
Service (Lógica de Negócio)
    ↓
Repository (Acesso a Dados)
    ↓
Banco de Dados (PostgreSQL/MongoDB)
    ↓
Response HTTP (JSON)
```

## 📦 Configuração do Ambiente

### Pré-requisitos

- Java 25 ou superior
- Maven 3.6+
- Docker e Docker Compose
- Git

### Instalação

1. Clone o repositório:
```bash
git clone https://github.com/sergiocotiazure20265-ops/api-solicitacoes.git
cd api-solicitacoes
```

2. Inicie os serviços com Docker Compose:
```bash
docker-compose up -d
```

Isso iniciará:
- **PostgreSQL** (porta 5435)
- **pgAdmin** (porta 5052) - Interface gráfica para PostgreSQL
- **MongoDB** (porta 27018)
- **Mongo Express** (porta 5054) - Interface gráfica para MongoDB
- **RabbitMQ** (porta 5672 e 15672) - Message Broker

3. Compile e execute a aplicação:

**Com Maven:**
```bash
./mvnw spring-boot:run
```

**Com Java direto:**
```bash
./mvnw clean package
java -jar target/api-solicitacoes-0.0.1-SNAPSHOT.jar
```

### Variáveis de Ambiente

Configure no arquivo `application.properties` ou `application.yml`:

```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5435/bd-solicitacoes
spring.datasource.username=coti
spring.datasource.password=coti
spring.jpa.hibernate.ddl-auto=update

# MongoDB
spring.data.mongodb.uri=mongodb://coti:coti@localhost:27018/bd-solicitacoes?authSource=admin

# RabbitMQ
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=coti
spring.rabbitmq.password=coti
```

## 🚀 Uso da API

### Documentação Swagger

Após iniciar a aplicação, acesse a documentação interativa:

```
http://localhost:8080/swagger-ui.html
```

### Exemplos de Requisições

**GET - Listar Solicitações:**
```bash
curl -X GET http://localhost:8080/api/solicitacoes
```

**POST - Criar Solicitação:**
```bash
curl -X POST http://localhost:8080/api/solicitacoes \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Nova Solicitação",
    "descricao": "Descrição da solicitação"
  }'
```

## 📊 Banco de Dados

### PostgreSQL

Acesse o **pgAdmin** em: `http://localhost:5052`
- Email: `coti@email.com`
- Senha: `Coti@2026`

### MongoDB

Acesse o **Mongo Express** em: `http://localhost:5054`

### RabbitMQ

Acesse o **Management Console** em: `http://localhost:15672`
- Usuário: `coti`
- Senha: `coti`

## 🧪 Testes

Execute os testes unitários:

```bash
./mvnw test
```

Execute os testes de integração:

```bash
./mvnw verify
```

A suite de testes inclui:
- Testes de Controllers (WebMvcTest)
- Testes de Repositories (DataJpaTest)
- Testes de Services
- Testes de Integração com MongoDB
- Testes de Integração com RabbitMQ (usando testcontainers)

## 🔍 Dependências Principais

| Dependência | Versão | Propósito |
|---|---|---|
| spring-boot-starter-data-jpa | 4.1.0 | ORM e acesso a dados relacionais |
| spring-boot-starter-data-mongodb | 4.1.0 | Acesso a dados NoSQL |
| spring-boot-starter-webmvc | 4.1.0 | REST Controllers e MVC |
| spring-boot-starter-amqp | 4.1.0 | Message Broker (RabbitMQ) |
| springdoc-openapi-starter-webmvc-ui | 3.0.3 | Documentação Swagger |
| modelmapper-spring | 3.2.6 | DTO Mapping |
| lombok | Latest | Code Generation |
| postgresql | Latest | Driver JDBC PostgreSQL |

## 📝 Convenções de Código

- **Nomenclatura**: camelCase para variáveis e métodos, PascalCase para classes
- **Pacotes**: `br.com.cotiinformatica.*`
- **DTOs**: Sufixo `DTO` ou `Request`/`Response`
- **Entities**: Sufixo `Entity` ou sem sufixo específico
- **Repositories**: Sufixo `Repository`
- **Services**: Sufixo `Service`
- **Controllers**: Sufixo `Controller`

## 🤝 Contribuições

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 👨‍💻 Autor

**Sergio Coti** - [GitHub Profile](https://github.com/sergiocotiazure20265-ops)

## 📞 Suporte

Para problemas, dúvidas ou sugestões, abra uma [issue](https://github.com/sergiocotiazure20265-ops/api-solicitacoes/issues) no repositório.

---

**Desenvolvido com ❤️ usando Java e Spring Boot**
