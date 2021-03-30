# language: pt

Funcionalidade: Gerenciamento de um usuario na PetStore

  Algum contexto de negócio
  História do usuário

  # NÃO FAZER ASSIM
  Cenario: Cria um usuário na loja
    Quando eu faço um POST para /v3/user com os seguintes valores:
      | id         | 1              |
      | username   | eu             |
      | firstName  | John           |
      | lastName   | James          |
      | email      | john@email.com |
      | password   | 12345          |
      | phone      | 12345          |
      | userStatus | 1              |
    Entao quando faço um GET para /v3/user/eu , o usuário criado é retornado

  Cenario: Cria um usuário na loja refletindo o negócio
    Quando crio um usuário
    Entao o usuário é salvo no sistema