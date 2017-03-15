import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by maiki on 15/03/2017.
 */
public class Exercicio04 {

    static int calculaLerp(int px1, int px2, float percent)
    {
        float dst = px1*(1.0f - percent) + px2 * percent;

        return (int) dst;
    }
    static BufferedImage lerp(BufferedImage img1, BufferedImage img2, float percent)
    {
        BufferedImage out = new BufferedImage(img1.getWidth(),img1.getHeight(), img1.TYPE_INT_RGB);
        for (int y = 0; y < img1.getHeight(); y++) {
            for (int x = 0; x < img1.getWidth(); x++) {
                Color cor1 = new Color(img1.getRGB(x,y));
                Color cor2 = new Color(img2.getRGB(x,y));

                int r = calculaLerp(cor1.getRed(),cor2.getRed(),percent);
                int g = calculaLerp(cor1.getGreen(), cor2.getGreen(), percent);
                int b = calculaLerp(cor1.getBlue(), cor2.getBlue(),percent);

                Color outColor = new Color(r, g, b);
                out.setRGB(x,y,outColor.getRGB());
            }
        }
        return out;
    }

    public  static void run() throws IOException {
        String PATH = "C:\\Users\\maiki\\Pictures\\img\\pb";
        BufferedImage img1 = ImageIO.read(new File(PATH, "errosB1.png"));
        BufferedImage img2 = ImageIO.read(new File(PATH, "errosB2.png"));

        BufferedImage lerpImg = lerp(img1,img2,0.25f);
        ImageIO.write(lerpImg,"png",new File("lerpErros.png"));

        System.out.println("OK");

    }

    public  static  void main(String[] args) throws IOException {
        new Exercicio04().run();
    }
}
