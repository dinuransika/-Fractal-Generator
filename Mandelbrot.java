import java.awt.Color;
import java.awt.image.BufferedImage;



public class Mandelbrot {
    public static BufferedImage Mandel(double minRe, double maxRe, double minIm, double maxIm, int iter){
        int width = 800, height = 800, max = iter;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int black = 0;
        Color [] colors ={new Color(66, 30, 15),
                          new Color(25, 7, 26),
                          new Color(9, 1, 47),
                          new Color(4, 4, 73),
                          new Color(0, 7, 100),
                          new Color(12, 44, 138),
                          new Color(24, 82, 177),
                          new Color(57, 125, 209),
                          new Color(134, 181, 229),
                          new Color(211, 236, 248),
                          new Color(241, 233, 191),
                          new Color(248, 201, 95),
                          new Color(255, 170, 0),
                          new Color(204, 128, 0),
                          new Color(153, 87, 0),
                          new Color(106, 52, 3)}; //Colour array for different iterations.

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                double c_re = minRe + (col)*(maxRe-minRe)/width; //Calculating the real part and imaginary part of the complex number.
                double c_im = minIm + (row)*(maxIm-minIm)/height;
                double x = 0, y = 0;
                int iteration = 0;
                while (x*x+y*y < 4 && iteration < max) { //Checking whether the number is in the set.
                    double x_new = x*x-y*y+c_re;
                    y = 2*x*y+c_im;
                    x = x_new;
                    iteration++;
                } 
                
                if (iteration < max) image.setRGB(col, row, colors[iteration%16].getRGB()); //Asigning colours according to the 
                else image.setRGB(col, row, black);
            }
        }
        return image;
    }



    public static void show(double minRe, double maxRe, double minIm, double maxIm, int iter) { //Show the mandelbrot set.
        BufferedImage img  = Mandelbrot.Mandel(minRe, maxRe, minIm, maxIm, iter);
        Panel.display(img, "Mandelbrolt Set");
    }
}