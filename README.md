<h1 align="center">Adota Pet GO (Clone)</h1>
<p align="center">Sistema backend para o aplicativo clone de Adota Pet GO</p>
<h4 align="center"> 
    :construction:  Projeto em construção  :construction:
</h4>
<h2 align="center">
    <img src="https://img.shields.io/static/v1?label=Heroku&message=Working&color=#430098&style=flat&logo=heroku"/>
    </h2>

Tabela de conteúdos
=================
<!--ts-->
   * [Sobre](#sobre)
   * [Como usar](#como-usar)
      * [Pré-Requisitos](#pre-requisitos)
      * [Endpoints](#endpoints)  
   * [Tecnologias](#tecnologias)
   * [Créditos](#creditos)
<!--te-->

<h1>Sobre</h1>
<p>O projeto é o backend de uma aplicação que eu estarei criando, um clone do aplicativo "Adota Pet GO" que pode ser encontrado nas lojas de aplicativos ou clicando <a href = "https://play.google.com/store/apps/details?id=com.labup.adotapetv2&hl=pt_BR&gl=US">aqui</a>.
   O repositório do aplicativo, que está sendo desenvolvido nativamente para Android pode ser encontrado aqui. Foi feito o depoly do projeto para a plataforma do <a href = "">Heroku</a>.</br>
<h1>Como usar</h1>
<h2>Pré-requisitos</h2>
<img src="https://user-images.githubusercontent.com/63808405/171037587-3c6b6b8f-e9c3-4b97-b4b0-a54d6c9fb8dc.png" width = "250px"></br>
<p>Antes de começar, você deve ter instalado em sua máquina o Insomnia. Podendo ser baixado através desse <a href = "https://insomnia.rest/download">link</a>.</br>
<h2>Endpoints</h2>
<p>Após ter feito a instalação, abra o programa e você poderá criar requisições web através de @Get, @Post, @Put, @Delete, @Patch, entre outras. E para começar a usar os endpoints dessa aplicação pode-se começar criando um usuário. Crie uma nova requisição @Post, ponha o "Body" como "Json" e coloque a seguinte url:</br>

```bash
https://adote-pet-221b.herokuapp.com/audote/usuarios/cadastro
``` 
O formato de json da criação de usuário deve seguir o seguinte padrão:

```bash
{"nome":"teste"
,"email":"teste@hotmail.com"
,"senha":"asdsdf"
,"img":"img"
,"contato":"contatoteste"
,"cep":"cep"
,"logradouro":"logradouro"
,"bairro":"bairro"
,"cidade":"cidade"
,"uf":"uf"}
``` 
Feito isso, você pode verificar se está tudo certo criando uma nova requisição @Get, ponha o "Body" como "Json" e coloque a seguinte url:</br>

```bash
https://adote-pet-221b.herokuapp.com/audote/usuarios
``` 

Em seguida, certifique-se de que a resposta foi correta. Se sim, podemos prosseguir para o passo de criar um animal dessa vez. Faça isso criando uma nova requisição @Post para a seguinte url:

```bash
https://adote-pet-221b.herokuapp.com/audote/data/animais
``` 

O formato de json da criação de usuário deve seguir o seguinte padrão:


```bash
{"dono":1
,"username":"teste"
,"date":"25/03/2022"
,"tipo":"cao"
,"porte":"grande"
,"sexo":"femea"
,"vacinado":"sim"
,"historico":"foi atropelado quando pequeno"
,"fotos":[
{"img":"img","img":"img"
]}
``` 

Feito isso, você pode verificar se está tudo certo criando uma nova requisição @Get, ponha o "Body" como "Json" e coloque a seguinte url:</br>

```bash
https://adote-pet-221b.herokuapp.com/audote/data/animais
``` 

Em seguida, certifique-se de que a resposta foi correta.</br>

<h3>Outros endpoints da aplicação</h3></br>
<h4>Usuarios</h4>

- Obter usuário por id

```bash
@Get
https://adote-pet-221b.herokuapp.com/audote/usuarios/{id}
``` 

- Logar usuáro
```bash
@Post
https://adote-pet-221b.herokuapp.com/audote/usuarios/login
``` 
Com formato json da seguinte maneira:
```bash
{"dono":1
,"username":"teste"
``` 

- Deletar usuario
```bash
@Delete
https://adote-pet-221b.herokuapp.com/audote/usuarios/{id}
``` 

<h4>Animais</h4>

- Atualizar animal

```bash
@Put
https://adote-pet-221b.herokuapp.com/audote/data/animais/{id}
```

- Deletar animal
```bash
@Delete
https://adote-pet-221b.herokuapp.com/audote/data/animais/{id}
```

<h1>Tecnologias</h1>
- Spring Boot</br>
- Arquitetura MVC</br>
- Heroku para deploy</br>
- Arquitetura com DTO</br>
- Buscando seguir os principios do solid</br>


<h1>Créditos</h1>

---

<a href="https://www.linkedin.com/in/valter-gabriel">
 <img style="border-radius: 50%;" src="https://user-images.githubusercontent.com/63808405/171045850-84caf881-ee10-4782-9016-ea1682c4731d.jpeg" width="100px;" alt=""/>
 <br />
 <sub><b>Valter Gabriel</b></sub></a> <a href="https://www.linkedin.com/in/valter-gabriel" title="Linkedin">🚀</a>
 
Feito por Valter Gabriel 👋🏽 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Gabriel-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/valter-gabriel/)](https://www.linkedin.com/in/valter-gabriel/) 
[![Gmail Badge](https://img.shields.io/badge/-vgabrielbri@hotmail.com-c14438?style=flat-square&logo=Hotmail&logoColor=white&link=mailto:vgabrielbri@hotmail.com)](vgabrielbri@hotmail.com)


