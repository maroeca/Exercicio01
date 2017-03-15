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
               /*int r = cor.getRed();
               int g = cor.getGreen();
               int b = cor.getBlue();*/
               int r = (int) (cor.getRed() * 0.3);
               int g = (int) (cor.getGreen() * 0.59);
               int b = (int) (cor.getBlue() * 0.11);
               //int media = (r + g+ b)/3;
               int media = (r + g +b);
               Color outColor = new Color(media, media, media);
              // Color outColor = new Color(r, r, r);
               out.setRGB(x, y, outColor.getRGB());
           }
       }
       return out;
   }

   static BufferedImage threshold (BufferedImage img, int value)
   {

       BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), img.TYPE_INT_RGB);

       for (int y = 0; y < img.getHeight(); y++) {
           for (int x = 0; x < img.getWidth(); x++) {
               Color cor = new Color(img.getRGB(x, y));
               int r = cor.getRGB();
               int g = cor.getGreen();
               int b = cor.getBlue();

               if(r >= value || g >= value || b >= value)
               {
                   Color outColor = new Color(255,255,255);
                   out.setRGB(x,y,outColor.getRGB());
               }else
               {
                   Color outColor = new Color(0, 0, 0);
                   out.setRGB(x,y, outColor.getRGB());
               }

               /*if(cor.getRed() >= value)
               {
                  // r = 255;
                   out.setRGB(x,y,255);
                   //System.out.println(cor.getRed());
               }else
                   if(cor.getRed() < value){
                   // r = 0;
                    out.setRGB(x, y, 0);
                  // System.out.println(cor.getRGB());
               }
               if(cor.getGreen() >= value)
               {
                  // g = 255;
                    out.setRGB(x,y,255);
               }else
               if(cor.getGreen() < value){
                  // g = 0;
                    out.setRGB(x, y, 0);
               }
               if(cor.getBlue() >= value)
               {
                   //b = 255;
                    out.setRGB(x,y,255);
               }else
               if(cor.getBlue() < value){
                   //b = 0;
                    out.setRGB(x, y, 0);
               }*/
               /*Color outCor = new Color(r, g, b);
               out.setRGB(x, y, outCor.getRGB());*/
           }

       }
       return out;
   }

    public void run() throws IOException {
        File PATH = new File("C:\\Users\\maiki\\Pictures\\img\\cor");
        BufferedImage img = ImageIO.read(new File(PATH, "turtle.jpg"));
        BufferedImage thresholdImg = threshold(img, 127);
       // BufferedImage greyImg = greyScale((img));
        ImageIO.write(thresholdImg, "png", new File("turtleThreshold.jpg"));
    }

    public static void main(String[] args) throws IOException {
        new Exercicio02().run();
    }

}
