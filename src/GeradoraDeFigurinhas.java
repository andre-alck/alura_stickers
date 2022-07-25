import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo, Double classificacao) throws Exception {
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 128));

        String textoDaFigurinha = "";

        if (classificacao >= 0 && classificacao <= 3) {
            textoDaFigurinha = "💀 PÉSSIMO! 💀";
        } else if (classificacao >= 4 && classificacao <= 5) {
            textoDaFigurinha = "RUIM! 🍅";
        } else if (classificacao >= 6 && classificacao <= 7) {
            textoDaFigurinha = "MEDIANO 😶";
        } else if (classificacao >= 8 && classificacao < 9) {
            textoDaFigurinha = "BOM! 😁";
        } else if (classificacao >= 9 && classificacao < 10) {
            textoDaFigurinha = "ÓTIMO! 😱";
        } else if (classificacao == 10) {
            textoDaFigurinha = "🌟 BEST SELLER! 🌟";
        } else {
            textoDaFigurinha = "Classificação inválida.";
        }

        int centroHorizontal = (largura / 2) - (graphics.getFontMetrics().stringWidth(textoDaFigurinha) / 2);
        graphics.drawString(textoDaFigurinha, centroHorizontal, novaAltura - 100);

        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }
}