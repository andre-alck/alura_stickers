import java.io.InputStream;
import java.net.URL;

public class App {
    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();

        String enderecoImagem = "https://avatars.githubusercontent.com/u/60830711?v=4";
        String nomeDoArquivo = "perfil" + ".png";

        InputStream inputStream = new URL(enderecoImagem).openStream();

        geradora.cria(inputStream, nomeDoArquivo);
    }
}