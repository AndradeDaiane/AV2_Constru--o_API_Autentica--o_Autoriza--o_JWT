# Construção da API de Autenticação e Autorização JWT (AV2) #

## Descrição: ##
Esta API foi desenvolvida como parte de um projeto acadêmico (AV2) com foco na construção de uma aplicação segura e moderna baseada em Spring Boot. O objetivo central é demonstrar, de forma prática, como implementar autenticação e autorização utilizando JWT (JSON Web Tokens), garantindo a proteção de recursos, controle de acesso e integridade das informações.

Além disso, o projeto inclui aspectos essenciais como:

- 🔐 **Segurança:** Implementação robusta de autenticação e autorização com tokens JWT.

- 🧪 **Testabilidade:** Cobertura de testes automatizados com JUnit e MockMvc.

- 📚 **Documentação:** Integração com Swagger/OpenAPI para navegação e teste de endpoints.

- 📈 **Monitoramento:** Coleta de métricas com Spring Boot Actuator e Prometheus.

- 🚀 **Deploy:** Utilização de Docker e plataformas como Render e Railway para hospedagem gratuita.

  

# 🛠️ Tecnologias e Dependências Utilizadas #

- **Spring Boot Starter Web:** Criação de APIs REST de forma rápida e simplificada.

- **Spring Boot Starter Security:** Autenticação e autorização com filtros de segurança integrados.

- **Spring Boot Starter OAuth2 Resource Server:** Validação de tokens JWT com suporte nativo ao padrão OAuth2.

- **Spring Boot Starter Data JPA:** Persistência de dados com JPA e banco relacional.

- **H2 Database:** Banco de dados em memória ideal para testes.

- **Lombok:** Redução de boilerplate (getters, setters, etc).

- **Springdoc OpenAPI:** Documentação Swagger atualizada automaticamente.

- **Spring Boot DevTools:** Hot reload para desenvolvimento.

- **JUnit 5 e Mockito:** Testes automatizados e simulação de dependências.

- **Auth0 Java JWT:** Geração e validação de JWT.

- **Spring Boot Actuator:** Fornece endpoints prontos para monitoramento, métricas, saúde e funcionamento interno da aplicação Spring Boot.

-  **Prometheus:** É uma ferramenta externa (servidor de monitoramento) que coleta e armazena métricas em tempo real.

# 🧹 Estrutura do Projeto #

**Model:**

- User – Entidade JPA que representa o usuário autenticado, contendo username, senha (criptografada) e role (papel de acesso).

**DTOs:**

- AuthenticationRequest – Representa os dados enviados para login (username e password).

- AuthenticationResponse – Representa a resposta de autenticação, contendo o token JWT.

- RegisterRequest – Representa os dados necessários para o cadastro de um novo usuário (ex: username, password, role).

**Repository:**

- UserRepository – Interface que estende JpaRepository, responsável por operações de persistência e busca de usuários, incluindo busca por username.

**Service:**

- JwtService – Responsável por gerar, validar e extrair informações do token JWT.

- AuthService – Contém a lógica principal de autenticação, cadastro de usuários e emissão de tokens JWT.

**Controller:**

- AuthController – Expõe os endpoints públicos de login (/auth/login) e registro (/auth/register).

- TestProtectedController – Contém endpoints protegidos por autenticação JWT, com controle de acesso baseado em roles (ex: ADMIN, USER).

**Config:**

- SecurityConfig – Define a configuração de segurança da aplicação, como filtros de autenticação, rotas públicas, roles necessárias para acesso e criação de usuários padrões na inicialização.

- SwaggerConfig - Configura e personaliza a documentação OpenAPI (Swagger), incluindo título, descrição, e agrupamento dos endpoints expostos.

# ⚙️ Configuração do Ambiente de Desenvolvimento #

Centralizado em application.yml, contendo:

- Porta do servidor

- Chave JWT secreta

- Tempo de expiração do token

- Configurações do banco de dados
  

 # Principais Funcionalidades da API #

**✅ Autenticação**

- POST /auth/login

- Entrada: username e password

- Retorno: token JWT assinado

**🔍 Validação de Token**

- POST /auth/validate

- Verifica validade e expiração do JWT

**🔐 Proteção de Endpoints**

- JWT em todas requisições

- Stateless

- Controle de acesso com @PreAuthorize


# 🌐 Swagger UI #

Acesse via: http://localhost:8080/swagger-ui/index.html#/

- Visualiza todos os endpoints

- Executa chamadas com JWT

- Interação fácil com a API via browser

  ![Swagger - OpenAPI](https://github.com/user-attachments/assets/9e0c86e0-d663-4dd1-a75a-3cfa1bfa3c7a)

  - https://av2-constru-o-api-autentica-o-autoriza-o.onrender.com/actuator/health


  # 🧑‍⚖️ Testes Automatizados #

Testes com JUnit e MockMvc:

- ✅ Login com credenciais válidas

- ❌ Login com credenciais inválidas

- 🔐 Acesso negado sem token

- 🔄 Acesso permitido com token válido

- ⛔ Bloqueio baseado em role (ADMIN, USER)


  # 📊 Testes de Carga com JMeter # 

Simulação de login e registro com 200 usuários simultâneos:

- Endpoints testados: /auth/login e /auth/register

- Ramp-up: 20 segundos

- Loop: cada usuário executa 10 requisições

- Métricas analisadas:

- Tempo médio de resposta (Average)

- Vazão (Throughput)

- Porcentagem de erros (Error %)

Esses testes ajudam a verificar a performance da API sob estresse e a robustez da autenticação com JWT.

![Summary Report](https://github.com/user-attachments/assets/a951812f-7a7b-46e3-8024-75d40f7ebf5a)

![View Results Tree](https://github.com/user-attachments/assets/e0c17a43-e8c3-4b8e-9dbc-d3207d740677)


# 🔧 Como Executar o Projeto #

git clone https://github.com/seu-usuario/sua-api-jwt.git
cd sua-api-jwt

Defina JWT_SECRET no terminal (ou no application.yml em dev)
export JWT_SECRET=suachavesecreta  # Linux/macOS
set JWT_SECRET=suachavesecreta     # Windows

 Execute
./mvnw spring-boot:run

Ou execute pela sua IDE favorita.



# Usuários Criados #

- admin / senha: 123456 (role ADMIN)

- user / senha: password (role USER)


# 🔗 Links de Acesso # 

- API: http://localhost:8080

- H2 Console: http://localhost:8080/h2-console

- Swagger UI: http://localhost:8080/swagger-ui/index.html#/

# 📅 Conclusão #

Este projeto demonstra a construção de uma API RESTful segura e moderna com Spring Boot 3.x usando autenticação baseada em JWT. A aplicação é segura, escalável, documentada e monitorada, com testes robustos que garantem estabilidade.

Pode ser facilmente adaptada para sistemas empresariais, microsserviços e integrações corporativas.


# Autor

Daiane Dos Santos Andrade.

https://www.linkedin.com/in/daiane-dos-santos-17732183/

# Licença

Este projeto está licenciado sob a licença Apache 2.0 - veja o arquivo LICENSE para detalhes.






