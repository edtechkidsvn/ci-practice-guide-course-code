import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy {
    int x;
    int y;
    BufferedImage image;

    Enemy(int xStart, int yStart) {
        x = xStart;
        y = yStart;
    }

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

    void updatePosition() {
        y += 1;
    }
}

