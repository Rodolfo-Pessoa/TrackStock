# 📦 TrackStock – Sistema de Gerenciamento de Estoque

## 📖 Sobre o Projeto
O **TrackStock** é um sistema de gerenciamento de estoque desenvolvido em **Java + Spring Boot**, com persistência em **MySQL**.  
O objetivo é controlar produtos, fornecedores, movimentações de entrada/saída, pedidos de reposição e relatórios de forma integrada.

---

## 🚀 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **MySQL**
- **Lombok**
- **Swagger/OpenAPI** (para documentação e testes dos endpoints)

---

## 🗂️ Estrutura do Projeto

- **Entities**
  - `Product` → representa os produtos
  - `Supplier` → fornecedores
  - `Stock` → controle de estoque
  - `Movement` → movimentações de entrada/saída
  - `ReplacementOrder` → pedidos de reposição
  - `Report` → relatórios gerados
  - `User` → usuários que geram relatórios

- **Repositories** → interfaces JPA para persistência  
- **Services** → regras de negócio (estoque, movimentações, relatórios, etc.)  
- **Controllers** → endpoints REST para interação com o sistema  

---

## 🔗 Relacionamentos Principais
- Um **Supplier** fornece vários **Products**  
- Um **Stock** contém vários **Products**  
- Um **Product** pode ter várias **Movements** (entradas/saídas)  
- Um **ReplacementOrder** vincula **Product** e **Supplier**  
- Um **Report** é gerado por um **User**  

---

## ⚙️ Como Rodar o Projeto

### 1. Clonar o repositório
    bash
    git clone https://github.com/seu-usuario/trackstock.git
    cd trackstock

### 2. Criar o banco de dados
    CREATE DATABASE trackstock;

### 3. Configurar o application.yml
    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/trackstock
        username: seu_usuario
        password: sua_senha
        driver-class-name: com.mysql.cj.jdbc.Driver
    
      jpa:
        hibernate:
          ddl-auto: update
        show-sql: true
        properties:
          hibernate:
            format_sql: true
    
    server:
      port: 8080
