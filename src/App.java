import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> urls = new ArrayList<>();

        urls.add("https://api.mocki.io/v2/549a5d8b/MostPopularMovies");
        urls.add("https://api.mocki.io/v2/549a5d8b/Top250TVs");
        urls.add("https://api.mocki.io/v2/549a5d8b/MostPopularTVs");

        var client = HttpClient.newHttpClient();
        var parser = new JsonParser();

        for (String url : urls) {
            URI endereco = URI.create(url);

            var request = HttpRequest.newBuilder(endereco).build();
            var response = client.send(request, BodyHandlers.ofString());

            String body = response.body();
            List<Map<String, String>> lista = parser.parse(body);

            System.out.println("API SELECIONADA:\t" + url);
            for (Map<String, String> item : lista) {
                System.out.println(item.get("title"));
                System.out.println(item.get("image"));
                System.out.println(item.get("imDbRatingCount"));
                System.out.println();
            }

        }

    }

}