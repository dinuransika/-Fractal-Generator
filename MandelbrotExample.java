
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;

public class MandelbrotExample {
  public static void main(String[] args) {
  JFrame frame= new DrawMandelbrot();
  frame.show();
  }
}
class DrawMandelbrot extends JFrame {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public DrawMandelbrot() {
  setTitle("Mandelbrot Example");
  setSize(800, 800);
  Container contentPane = getContentPane();
  contentPane.add(new MandelbrotPanel(), "Center");
  }
}
class MandelbrotPanel extends JPanel {
  public void paintComponent(Graphics g) {
  super.paintComponent(g);
  BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(),
  BufferedImage.TYPE_INT_ARGB);
  generate(bufferedImage);
  g.drawImage(bufferedImage, 0, 0, null);
  }
public void generate(BufferedImage bufferedImage) {
  int w = bufferedImage.getWidth();
  int h = bufferedImage.getHeight();
  WritableRaster writableRaster = bufferedImage.getRaster();
  ColorModel colorModel = bufferedImage.getColorModel();
  Color color = Color.cyan;
  int c = color.getRGB();
  Object object = colorModel.getDataElements(c, null);

  for (int j = 0; j < w; j++)
  for (int k = 0; k < h; k++) {
  double p = Pmin + j * (Pmax - Pmin) / w;
  double q = Qmin + k * (Qmax - Qmin) / h;
  if (!escapes(p, q))
  writableRaster.setDataElements(j, k, object);
  }
  }
  private boolean escapes(double p, double q) {
  double x = 0.4;
  double y = 0.4;
  int count = 0;
  do {
  double X = x * x - y * y + p;
  double Y = 2 * x * y + q;
  x = X;
  y = Y;
  count++;
  if (count == MAX_COUNTS)
  return false;
  } while (x <= 2 && y <= 2);
  return true;
  }
  double Pmin = -2;
  double Pmax = 2;
  double Qmin = -2;
  double Qmax = 2;
  int MAX_COUNTS = 1000;
}