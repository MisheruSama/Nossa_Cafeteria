# ☕ Sistema de Cardápio usando Java Spring Boot, MySQL 

![Plataforma](https://img.shields.io/badge/Plataforma-VsCode-blue)
![Backend](https://img.shields.io/badge/Backend-Java%20%2F%20SpringBoot-green)
![Banco de Dados](https://img.shields.io/badge/Database-MySQL-blueviolet)
![Status](https://img.shields.io/badge/Status-Finalizado-darkgreen)

> Projeto acadêmico de sistema de Cardápio com foco em controle dos itens do cardápio.

---

## 📷 Visão Geral

Este projeto tem como objetivo desenvolver um sistema de Cardápio para prática do que foi aprendido na matéria acadêmica de Programação Orientada a Objetos em Java.

**Funcionalidades:**
- Pagina exemplo de login para futuro controle de segurança
- APIs criadas para comunicação do Backend e Frontend
- Cadastro de alimentos com Nome, Preço e Descrição
- Edição de Informações conforme haja necessidade
- Exclusão conforme necessidade



---

## 📂 Estrutura do Projeto

```
NossaCafeteria/
│
├── .vscode/                     # Configurações do VS Code
├── .mvn/wrapper/                # Scripts para execução com Maven Wrapper
├── mvnw                        # Script Unix do Maven Wrapper
├── mvnw.cmd                    # Script Windows do Maven Wrapper
├── pom.xml                     # Arquivo de configuração do Maven
│
├── src/
│   ├── main/
│   │   ├── java/com/NossaCafeteria/Cardapio/
│   │   │   ├── Controllers/     # Controllers da aplicação (rotas e lógica web)
│   │   │   ├── Model/           # Entidades e modelos de dados
│   │   │   ├── Repository/      # Interfaces de acesso ao banco de dados
│   │   │   └── CardapioApplication.java  # Classe principal do Spring Boot
│   │   └── resources/           # Arquivos de configuração e templates
│   │
│   └── test/
│       └── java/com/NossaCafeteria/Cardapio/
│           └── CardapioApplicationTests.java  # Testes automatizados da aplicação
│
├── .gitignore                  # Arquivos e pastas ignorados pelo Git
└── .gitattributes              # Configurações de atributos Git

```

---

🚀 Como Executar o Projeto Localmente
Pré-requisitos:

Java JDK 17 ou superior instalado

Maven instalado (ou usar o Maven Wrapper incluído no projeto)

IDE como IntelliJ IDEA, Eclipse ou VS Code (opcional)

1. Clone o repositório
bash
Copiar
Editar
git clone https://github.com/MisheruSama/Nossa_Cafeteria.git
cd Nossa_Cafeteria
2. Navegue até o diretório do projeto
bash
Copiar
Editar
cd NossaCafeteria/Cardapio
3. Compile e execute o projeto com Maven Wrapper (recomendado)
No Linux/macOS:

bash
Copiar
Editar
./mvnw spring-boot:run
No Windows:

cmd
Copiar
Editar
mvnw.cmd spring-boot:run
4. Acesse no navegador
Após a aplicação iniciar com sucesso, acesse:

arduino
Copiar
Editar
http://localhost:8080/


