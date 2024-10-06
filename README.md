# Spring Security Template

Este projeto tem como objetivo fornecer um modelo (template) reutilizável de uma aplicação Spring Security com diversas configurações pré-configuradas. Ele pode ser facilmente adaptado para qualquer aplicação onde seja necessária autenticação de usuários com base em **Roles** (perfis de usuário), **JWT**, **BCrypt**, e integração com um banco de dados MySQL em contêiner Docker. O projeto também inclui exemplos de endpoints para login, cadastro de novos usuários e um usuário administrador já cadastrado.

## Funcionalidades

- Autenticação de usuários usando **JWT (JSON Web Token)**.
- Criptografia de senhas com **BCrypt**.
- **Roles** configuráveis para controle de acesso (**ROLE_USER**, **ROLE_ADMIN**).
- Integração com **MySQL** em contêiner Docker.
- Endpoint para **login** de usuários.
- Endpoint para **cadastro de novos usuários**.
- **Usuário administrador** já cadastrado para facilitar a inicialização e testes.
  
## Tecnologias Utilizadas

- **Spring Boot** 3.x
- **Spring Security**
- **JWT** para autenticação e autorização
- **BCrypt** para criptografia de senha
- **MySQL** como banco de dados relacional
- **Docker** para gerenciamento de contêineres
- **Hibernate** para ORM (Mapeamento Objeto Relacional)

## Estrutura de Roles e Usuários

### Roles

Este projeto utiliza o conceito de **Roles** para definir permissões de acesso. As roles estão armazenadas no banco de dados e são associadas a cada usuário:

- `ROLE_USER`: Permissão para acesso básico.
- `ROLE_ADMIN`: Permissão para acesso administrativo.

### Usuário Administrador

Um usuário administrador já está cadastrado no banco de dados para facilitar o uso imediato do projeto. As credenciais do usuário são:

- **Email**: `usuario@email.com`
- **Password**: `senha`
- **Role**: `ROLE_ADMIN`

## Endpoints

### Login

Endpoint para autenticação de usuários. Retorna um token JWT caso as credenciais estejam corretas.

       
       
