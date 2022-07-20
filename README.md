# Desafio 2

Usar sua criatividade para deixar a saída dos dados mais bonitinha: usar emojis com código UTF-8, mostrar a nota do filme como estrelinhas, decorar o terminal com cores, negrito e itálico usando códigos ANSI, e mais!

## Notas

https://www.alura.com.br/artigos/decorando-terminal-cores-emojis

```java
// código exemplo
System.out.println("🎬\t\u001b[1mFilme:\t\u001b[m" + filme.get("title"));
```

System.out.println(" = Java.

🎬 = emoji, possui suporte em terminais modernos.

\t = tabulação.

\u001b[1m = negrito.

Filme: = string.

\u001b[m = redefinir estilo.

" + filme.get("title")); = Java.