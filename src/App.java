import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        var parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("🎬\t\u001b[1mFilme:\t\u001b[m" + filme.get("title"));
            System.out.println("🎭\t\u001b[1mImagem:\t\u001b[m" + filme.get("image"));
            
            System.out.print("🌟\t\u001b[1mAvaliação:\t\u001b[m");
            double quantidadeDeEstrelas = Math.floor(Double.parseDouble(filme.get("imDbRating")) / 2);
            for (int i = 0; i < quantidadeDeEstrelas; i++) {
                System.out.print("⭐");
            }

            System.out.println("");
            System.out.println("");
        }
    }
}
