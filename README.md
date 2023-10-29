# API GraphQL Task Manager

Este é um projeto desenvolvido para a disciplina de Apis e Web Services na PUC MG, utilizando Spring Boot 3, Java 17 e GraphQL. O projeto consiste em uma aplicação que gerencia usuários e tarefas em um banco de dados H2.

## Pré-requisitos

- Git.
- Uma IDE de desenvolvimento de sua preferência.

## Configuração

Para iniciar o projeto, siga estas etapas:

1. Clone este repositório em sua máquina local:

   ```shell
   git clone https://github.com/vini0012/tasks-manager.git

2. Abra o projeto na sua IDE e execute o projeto localmente. Classe main para execução -> TaskManagerApplication.java


Após executar o projeto será criado um ambiente de desenvolvimento com o banco de dados e a aplicação configurados e prontos para uso.

3. Acesse a interface do GraphQL em seu navegador:

   http://localhost:8080/graphiql?path=/graphql

4. Acesse o banco de dados H2 em seu navegador:

   http://localhost:8080/h2-console  

User Name: sa
Password: 1234

# Mapa das APIs Disponíveis

A aplicação oferece as seguintes operações GraphQL:

   ```
    mutation CreateUser {
      createUser(userDto: 
        {username: "userName", 
          fullName: "fullName", 
          email: "email"}) 
      {
        email
        fullName
        uuid
      }
    }
          
    mutation CreateTask {
      createTask(taskDto: 
        {description: "description", 
          status: CREATED, 
          userId: "userId"
        }) {
        description
        status
      }
    }
    
    mutation DeleteTask {
      deleteTask(uuid: "uuid")
    }
    
    mutation UpdateTask {
      updateTask(
        status: COMPLETED
        uuid: "uuid"
        description: "description"
      ) {
        description
        status
      }
    }
    
    mutation MarkAsCompleted {
      markAsCompleted(uuid: "uuid")
    }
    
    query FindTaskById {
      findTaskById(uuid: "uuid") {
        description
        status
      }
    }
    
    query FindAllTasks {
      findAllTasks {
        description
        status
      }
    }
    
    query FindTasksByStatus {
      findTaskByStatus(status: CANCELED) {
        description
        status
      }
    }
    
    query FindTasksByUserId {
      findTasksByUserId(userId: "userId") {
        description
        status
      }
    }
    
    query FindAllUsers {
      findAllUsers {
        email
        fullName
        uuid
      }
    }
    
    query FindUserById {
      findUserById(uuid: "uuid") {
        email
        fullName
        uuid
      }
    }
   ```

## Encerrando o Projeto
Para encerrar o projeto basta parar a execução da aplicação local diretamente pela sua IDE.

Observação: O banco de dados H2 está configurado para ser resetado sempre que a aplicação for reiniciada.