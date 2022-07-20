# Desafio 5

Desafio supremo: criar alguma maneira para você dar uma avaliação ao filme, puxando de algum arquivo de configuração OU pedindo a avaliação para o usuário digitar no terminal.

## Notas

https://www.w3schools.com/java/showjava.asp?filename=demo_api_scanner

https://stackoverflow.com/questions/4157972/how-to-update-a-value-given-a-key-in-a-hashmap

```java
for (Map<String, String> filme : listaDeFilmes)
    filme.put("imDbRating", new Scanner(System.in).nextLine());
```
