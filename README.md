# RSA Crypto
## João Pedro Lazarim e Julia Karolina Atanazio

## Instruções

1. Gere as chaves através do comando: `java RSAKeyGenerator`
    - Isso irá gerar as chaves públicas e privadas

2. Criptografe o arquivo através do comando `java Encrypt public_key.txt input.txt encrypted_value.txt`
    - Isso irá criptografar o texto de entrada definido no arquivo `input.txt`, utilizando a chave pública gerada no passo 1, e jogará o valor criptografado no arquivo `encrypted_value.txt`

3. Descriptografe o arquivo através do comando `java Decrypt private_key.txt encrypted_value.txt decrypted_value.txt`
    - Isso irá descriptografar o texto criptografado no passo 2, que está no arquivo `encrypted_value.txt`, utilizando a chave privada gerada no passo 1, e jogará o valor descriptografado no arquivo `decrypted_value.txt`

4. Ou apenas rode o arquivo `text_script.bat`

## Relatório
1. Planejamento: de início pensei em fazer um projeto maven, concentrado todas as classes em um só projeto, porém, decidi fazer cada método em uma classe diferente e compilar separadamente, pois assim fica mais fácil para o usuário final apenas rodar em seu CMD. Além disso, tomei liberdade para fazer um arquivo que gera as chaves RSA, tanto a pública quanto a privada, pois acredito que assim seja mais fácil para o usuário utilizar dos métodos.
Coloquei os nomes das classes/métodos/variáveis em inglês, pois acredito ser uma boa prática, porém, o feedback para o usuário é em português, para que fique mais fácil a sua interpretação.
Organizei cada código deixando a lógica na função principal (main), dentro de uma classe com o nome da aplicação, para compilar cada programa separadamente. Também comentei cada parte da lógica dentro dos códigos, para fins didáticos e para facilitar o entendimento do código para alguém que não conhece as funções/métodos/lógica utilizados para criar as aplicações.
Utilizei a linguagem Java, pois é a linguagem a qual eu trabalho há 2 anos, o que me dá uma base sólida para trabalhar com a mesma e gerar os algoritmos com mais facilidade.
As classes Encrypt e Decrypt possuem uma lógica parecida, porém reversa, mas o modo de escrever é bem parecido. Encontrei dois modos de escrever o código, e escrevi cada um deles de um modo diferente.
A parte que mais encontrei dificuldades foi onde eu fiz o algoritmo para gerar as chaves, que demandou um pouco mais de pesquisa para desenvolver.

2. Teste: fiz um arquivo .bat para testar as aplicações através do cmd, o que me poupou muito tempo o qual eu perderia escrevendo as linhas para executar cada passo. Primeiro gerei as chaves, depois criei um arquivo de input com o texto `hello world` e testei criptografar e descriptografar o mesmo, e deu certo.
Acabei me deparando com algumas Exceptions na hora de criptografar, pois no início eu estava gerando as chaves de forma errada, o que acabou consumindo boa parte do meu tempo até eu conseguir corrigir o arquivo de gerar as chaves.
Todos os códigos funcionam perfeitamente, não há nenhum problema o qual não consegui resolver.

3. Foi um projeto bem diferente e interessante, pude aprofundar mais os meus conhecimentos na área da segurança, a qual eu não sou muito familiarizado, além de trabalhar com arquivos externos e utilizar de novas bibliotecas e interfaces na aplicação. Valeu a pena pelo conhecimento adquirido.