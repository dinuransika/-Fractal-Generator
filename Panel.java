import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel{ //Extending JPanel
    private static final long serialVersionUID = 1L;

    private static JFrame frame;
    private static JLabel label;
    public static void display(BufferedImage image, String name) {
        frame = new JFrame();
        frame.setTitle(name);
        frame.setSize(800, 800);    //Set default width and height
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        label=new JLabel();
        label.setIcon(new ImageIcon(image));
        frame.getContentPane().add(label,BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }    
}
