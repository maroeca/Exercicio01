import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by maiki on 24/03/2017.
 * HSV
 */
public class Exercicio07 {

    public static float saturate(float value)
    {
        if(value < 0)
            return 0;
        if(value > 1)
            return 1;

        return value;
    }

    public static BufferedImage brightHSV(BufferedImage img, float bright)
    {
        BufferedImage out = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                Color cor = new Color(img.getRGB(x,y));
                float hsb[] = new float[3];
                int r = cor.getRed();
                int g = cor.getGreen();
                int b = cor.getBlue();

                Color.RGBtoHSB(r, g, b, hsb);

                //hsb[0] = saturate(hsb[0] * bright);
                hsb[1] = saturate(hsb[1] * bright);
                //hsb[2] = saturate(hsb[2] * bright);

                out.setRGB(x, y, Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
            }
        }
        return out;
    }

    public static void run() throws IOException {
        String PATH = "C:\\Users\\maiki\\Pictures\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));
        BufferedImage darkImg = brightHSV(img, 0.5f);
        BufferedImage brightImg = brightHSV(img, 1.5f);

        ImageIO.write(darkImg, "png", new File("darkpuppyhsv.png"));
        ImageIO.write(brightImg, "png", new File("brightpuppyhsv.png"));
    }

    public static void main(String[] args) throws IOException {
        new Exercicio07().run();
        System.out.println("Pronto!");
       // run();
    }
}
