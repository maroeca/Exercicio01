import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by maycow.carmo on 13/03/2017.
 */
public class Exercicio06 {

    static float kernel = (1.0f / 9.0f);
    static float media[][] = {
            {kernel, kernel, kernel},
            {kernel, kernel, kernel},
            {kernel, kernel, kernel}};

    static Color applyKernel(Color[][] colors, float[][] kernel)
    {
        Color newColors[][] = new Color[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int r = (int) (colors[x][y].getRed() * kernel[x][y]);
                int g = (int) (colors[x][y].getGreen() * kernel[x][y]);
                int b = (int) (colors[x][y].getBlue() * kernel[x][y]);
                newColors[x][y] = new Color(r, g, b);
            }

        }
        int sr = 0;
        int sg = 0;
        int sb = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                sr +=  newColors[x][y].getRed();
                sg +=  newColors[x][y].getGreen();
                sb +=  newColors[x][y].getBlue();
            }
        }
        return new Color(sr, sg, sb);


    }

    static Color getColor (BufferedImage img, int x, int y)
    {
        if(x < 0 || x >= img.getWidth() || y < 0 || y >= img.getHeight())
            return new Color(0,0,0);

        return new Color (img.getRGB(x, y));

    }

    static Color[][] getPixelColor(BufferedImage img, int x, int y)
    {
      return new Color[][]{
                {getColor(img,x-1, y-1), getColor(img, x, y-1), getColor(img, x+1, y-1)},
                {getColor(img,x-1, y), getColor(img, x, y), getColor(img, x+1, y)},
                {getColor(img,x-1, y+1), getColor(img, x, y+1), getColor(img, x+1, y+1)}

        };

    }



    static BufferedImage convolve(BufferedImage img, float[][] kernel)
    {
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth() ; x++) {
               Color colors = new Color(applyKernel(getPixelColor(img, x, y), kernel).getRGB());

               out.setRGB(x, y, colors.getRGB());
            }

        }
        return out;
    }

    public static void run() throws IOException {
        String PATH = "C:\\Users\\maiki\\Pictures\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH,"puppy.png"));
        BufferedImage conv = convolve(img, media);

        ImageIO.write(conv, "png", new File("conv.png"));
    }

    public static void main(String[] args) throws IOException {
        new Exercicio06().run();
    }
}
