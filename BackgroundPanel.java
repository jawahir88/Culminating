import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

    private Image backgroundImage;// Variable to store the background image
// Constructor that receives the image file path
    public BackgroundPanel(String imagePath) {
       // Load the image from the given path
        backgroundImage = new ImageIcon(imagePath).getImage();
    }
// This method draws the panel and its contents
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image to fill the panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
