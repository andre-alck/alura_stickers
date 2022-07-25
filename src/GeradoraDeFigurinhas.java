import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        graphics.setColor(Color.YELLOW);
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);
        String textoDaFigurinha = "andre-alck";
        int centroHorizontal = (largura / 2) - (graphics.getFontMetrics().stringWidth(textoDaFigurinha) / 2);
        graphics.drawString(textoDaFigurinha, centroHorizontal, novaAltura - 100);

        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        var textLayout = new TextLayout(textoDaFigurinha, fonte, fontRenderContext);

        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(centroHorizontal, novaAltura - 100);
        graphics.setTransform(transform);

        var outlineStroke = new BasicStroke(largura * 0.007f);
        graphics.setStroke(outlineStroke);

        graphics.setColor(Color.BLACK);
        graphics.draw(outline);
        graphics.setClip(outline);

        new File("saida/").mkdir();
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }
}