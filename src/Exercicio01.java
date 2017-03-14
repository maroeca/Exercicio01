import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by maycow.carmo on 06/03/2017.
 */
public class Exercicio01 {

    public static int saturate(int value){
        if (value > 255) {
            return 255;
        }
        if(value < 0){
            return 0;
        }
        return value;
    }

    public static BufferedImage bright(BufferedImage img, float intensity){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x< img.getWidth(); x++){
                Color cor = new Color(img.getRGB(x, y));
                int r = saturate((int)(cor.getRed() * intensity));
                int g = saturate((int)(cor.getGreen() * intensity));
                int b = saturate((int)(cor.getBlue() * intensity));
                Color outColor = new Color(r, g, b);
                out.setRGB(x, y, outColor.getRGB());
            }
        }
        return out;
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\maycow.carmo\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));
        BufferedImage darkImg = bright(img, 0.5f);
        BufferedImage brightImg = bright(img, 02.0f);

        ImageIO.write(darkImg, "png", new File("darkPuppy.png"));
        ImageIO.write(brightImg, "png", new File("brightPuppy.png"));
    }

    public static void main(String[] args) throws IOException {
        new Exercicio01().run();
    }
}
