# prime
Projeto para o laboratório de lab prog 3, cujo objetivo é dado um numero encontrar dois numeros primos que multiplicado resultem nesse valor

# Instruções de funcionamento
Nesse código seis códigos principais

* App.js: É o código principal do front, é nele que será renderizada a tela que irá pedir para o usuário um valor n, e irá retornar os dois primos que multiplicados equivalem a ele. Nesse código será necessário substituir na string http://yourip:8080/api/data/${number} 'yourip' pelo ip de onde o servidor estará rodando.
* Tuple.java é a classe que representa uma tupla de três numeros, que são o numero n fornecido, e os dois primos, p1 e p2, que multiplicados equivalem ao n.
*  Prime.java é a classe que determina todos os numeros primos até um determinado threshold, além de calcular todas as tuplas para esse limite.
*  App.java é a classe que o desenvolvedor deve rodar para preencher o banco de dados.
*  Database.java é a classe responsavel pelo contato com o banco de dados. Para ela funcionar é preciso alterar as variáveis jdbcURL, username e password para que ele possa acessar o banco de dados do servidor. 
*  Server.java é a classe que deverá ser rodada para iniciar o servidor


Observação: Ao utilizar o servidor pela primeira vez, terá que ser rodado primeiro o App.java para ele preencher o banco de dados, após essa etapa é só rodar o server.java para o back e App.js para o front.
