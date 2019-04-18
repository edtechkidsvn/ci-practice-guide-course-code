import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameObject {
    int x;
    int y;
    BufferedImage image;

    void paint(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
