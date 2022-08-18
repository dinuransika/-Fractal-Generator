import java.awt.Color;
import java.awt.image.BufferedImage;


public class Julia {
    public static BufferedImage Juli(double z_re, double z_im, int iter){
        int width = 800, height = 800, max = iter;
        double minRe = -1, maxRe = 1, minIm = -1, maxIm = 1;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int black = 0;
        int[] colors = new int[max];
        for (int i = 0; i<max; i++) {
            colors[i] = Color.HSBtoRGB(i/256f, 1, i/(i+8f));
        }


        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                double c_re = minRe + (col)*(maxRe-minRe)/width; //Calculating the real part and imaginary part of the complex number.
                double c_im = minIm + (row)*(maxIm-minIm)/height;
                double x = c_re, y = c_im;
                int iteration = 0;
                while (x*x+y*y < 4 && iteration < max) { //Checking whether the number is in the set.
                    double x_new = x*x-y*y+z_re;
                    y = 2*x*y+z_im;
                    x = x_new;
                    iteration++;
                } 
                
                if (iteration < max) image.setRGB(col, row, colors[iteration]);
                else image.setRGB(col, row, black);
            }
        }
        return image;
    }



    public static void show(double z_re, double z_im, int iter) { //Show the julia set.
        BufferedImage img  = Julia.Juli(z_re, z_im, iter);
        Panel.display(img, "Julia Set");
    }
}