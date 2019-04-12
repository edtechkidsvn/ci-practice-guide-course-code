import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameObject {
    int x;
    int y;
    BufferedImage image;

    void loadImage() {
        try {
            image = ImageIO.read(new File("assets/images/enemies/level0/blue/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void paint(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
