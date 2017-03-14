import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by maycow.carmo on 13/03/2017.
 */
public class Exercicio02 {

   public static BufferedImage greyScale(BufferedImage img)
   {
       BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), img.TYPE_INT_RGB);
       for (int y = 0; y < img.getHeight() ; y++) {
           for (int x = 0; x < img.getWidth() ; x++) {
               Color cor = new Color(img.getRGB(x, y));
               int r = cor.getRed();
               Color outColor = new Color(r, r, r);
               out.setRGB(x, y, outColor.getRGB());
           }
       }
       return out;
   }

    public void run() throws IOException {
        File PATH = new File("C:\\Users\\maycow.carmo\\img\\cor");
        BufferedImage img = ImageIO.read(new File(PATH, "turtle.jpg"));
        BufferedImage greyImg = greyScale((img));
        ImageIO.write(greyImg, "png", new File("turtleGrey.jpg"));
    }

    public static void main(String[] args) throws IOException {
        new Exercicio02().run();
    }

}
