<h1 align="center"> Seu título aqui </h1>
<p align="center">Escrever uma breve descrição</p>
<h4 align="center"> 
    :construction:  Projeto em construção  :construction:
</h4>
<h2 align="center">
    <img src="https://img.shields.io/static/v1?label=Heroku&message=Working&color=#430098&style=flat&logo=heroku"/>
    </h2>

### Features

- [x] Cadastro de usuário
- [x] Cadastro de cliente
- [ ] Cadastro de produtos


Tabela de conteúdos
=================
<!--ts-->
   * [Sobre](#sobre)
   * [Como usar](#como-usar)
      * [Pre Requisitos](#pre-requisitos)
      * [Endpoints](#endpoints)  
   * [Tests](#testes)
   * [Tecnologias](#tecnologias)
<!--te-->

<h1>Sobre</h1>
<p>O projeto é o backend de uma aplicação que eu estarei criando, um clone do aplicativo "Adota Pet GO" que pode ser encontrado nas lojas de aplicativos ou clicando <a href = "https://play.google.com/store/apps/details?id=com.labup.adotapetv2&hl=pt_BR&gl=US">aqui</a>.
   O repositório do aplicativo, que está sendo desenvolvido nativamente para Android pode ser encontrado clicando <a href = "https://play.google.com/store/apps/details?id=com.labup.adotapetv2&hl=pt_BR&gl=US">aqui</a>. Foi feito o depoly do projeto para a plataforma do <a href = "https://play.google.com/store/apps/details?id=com.labup.adotapetv2&hl=pt_BR&gl=US">Heroku</a>.</br>

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
