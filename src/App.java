import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
        URI endereco = URI.create(url);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        for (Map<String, String> filme : listaDeFilmes)
            filme.put("imDbRating", new Scanner(System.in).nextLine());

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println("");
        }
    }
}
