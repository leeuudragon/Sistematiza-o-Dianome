# API para gerenciamento de pacotes da empresa Dianome

## Instruções

### Requisitos
- Java 17
- Database: postgres
- Username: postgres
- Password: 12345

### Instalação
- Clone projeto
- Importe para a IDE (Eclipse, Intellij)
- Atualize as bibliotecas
- Inicie

### Acesso
- Por um gerenciador de APIs (Postman, Insomnia)

### Utilização

Inclusão de pacotes:
- URI: http://localhost:8080/api/dianome/pacote/incluir
- Método: POST
- Fomulário JSON: id, codRastreamento, nomDestinatario, email, endereco, dtRecebimento, status, entregador, dtEntrega.

Listar todos os pacotes:
- URI: http://localhost:8080/api/dianome/pacote/listar-todos
- Método: GET

Exibir apenas um pacote especifico:
- URI: http://localhost:8080/api/dianome/pacote/{id}
- Método: GET

Excluir um pacote:
- URI: http://localhost:8080/api/dianome/pacote/{id}
- Método: DELETE

Para alterar um pacote:
- URI: http://localhost:8080/api/dianome/pacote/alterar
- Método: POST
- Fomulário JSON: id, codRastreamento, nomDestinatario, email, endereco, dtRecebimento, status, entregador, dtEntrega.