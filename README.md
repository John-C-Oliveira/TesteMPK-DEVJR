# TesteMPK-DEVJR


Aplicação simples de um Crud de cliente, utilizando o Springboot,JPA,H2 e JAVA11

## Steps to Setup

**1. Clonar a aplicação**

```bash
git clone https://github.com/John-C-Oliveira/TesteMPK.git
```


**2. Rodar a aplicação utilizando o Maven(Necessário Instalação)**

```bash
mvn spring-boot:run
```
a aplicação será iniciada na porta <http://localhost:8080>

## Chamadas Rest APIs

A aplicação possui as seguintes API no CRUD

### Posts

| Method | Url |        Decription       | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| POST   | http://localhost:8080/cliente | Criar novo cliente | [JSON] |
| GET   | http://localhost:8080/cliente | Consultar todos os clientes | [JSON] |
| GET   | http://localhost:8080/cliente/{id} | Consultar cliente por id| [JSON] |
| PUT   | http://localhost:8080/cliente/{id} | atualizar cliente | [JSON] |
| DELETE   | http://localhost:8080/cliente/{id} | Deletar cliente | [JSON] |



Teste utilizando o Postman ou qualquer outra plataforma de API

## sistema simples da validação do JSON Request Bodys


##### <a id="usercreate">Criar Usuario-> /cliente</a>
```json
{
    "nome":"John",
    "cnpj":"1245678910123",
    "idade":"29",
    "dataNascimento":"16/05/1992"

}
```

##### <a id="userupdate">Atualizar Cliente -> /cliente/{id}</a>
```json
{
    "nome":"",
    "cnpj":"12456",
    "idade":"18",
    "dataNascimento":"16/05/1992"
}
```

