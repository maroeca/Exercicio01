import sun.font.FontRunIterator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Created by maiki on 15/03/2017.
 */
public class Exercicio03 {

    static int saturate(int value)
    {
        if (value >= 255) {
            return 255;
        }
        if(value <= 0) {
            return 0;
        }
        return value;
    }

    static BufferedImage add(BufferedImage img1, BufferedImage img2)
    {
        BufferedImage out = new BufferedImage(img1.getWidth(),img1.getHeight(), img1.TYPE_INT_BGR);
        for (int y = 0; y < img1.getHeight(); y++) {
            for (int x = 0; x < img1.getWidth(); x++) {
                Color cor1 = new Color(img1.getRGB(x,y));
                Color cor2 = new Color(img2.getRGB(x,y));

                int r = saturate(cor1.getRed() + cor2.getRed());
                int g = saturate(cor1.getGreen() + cor2.getGreen());
                int b = saturate(cor1.getBlue() + cor2.getBlue());

                Color outColor = new Color(r, g, b);
                out.setRGB(x, y, outColor.getRGB());

            }
        }
        return out;
    }

    static BufferedImage subtract(BufferedImage img1, BufferedImage img2)
    {
        BufferedImage out = new BufferedImage(img1.getWidth(), img1.getHeight(), img1.TYPE_INT_RGB);
        for (int y = 0; y < img1.getHeight(); y++) {
            for (int x = 0; x < img1.getWidth(); x++) {
                Color cor1 = new Color(img1.getRGB(x,y));
                Color cor2 = new Color(img2.getRGB(x,y));

                int r = saturate(cor1.getRed() - cor2.getRed());
                int g = saturate(cor1.getGreen() - cor2.getGreen());
                int b = saturate(cor1.getBlue() - cor2.getBlue());

                Color outColor = new Color(r, g, b);
                out.setRGB(x, y, outColor.getRGB());

            }

        }
        return out;
    }

    public static void run() throws IOException {
        String PATH = "C:\\Users\\maiki\\Pictures\\img\\pb";
        BufferedImage img1 = ImageIO.read(new File(PATH, "errosB1.png"));
        BufferedImage img2 = ImageIO.read(new File(PATH, "errosB2.png"));
        BufferedImage subImg = subtract(img2,img1);
        BufferedImage addImg = add(img2,img1);

        ImageIO.write(addImg, "png", new File("addErros.png"));
        ImageIO.write(subImg, "png", new File("subErros.png"));
    }

    public static void main(String[] args) throws IOException {
        new Exercicio03().run();
    }
}
