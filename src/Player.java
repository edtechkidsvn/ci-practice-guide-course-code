import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    int x = 170;
    int y = 500;
    BufferedImage image;

    void loadImage() {
        try {
            image = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void paint(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    void move(boolean leftPressed, boolean rightPressed, boolean upPressed, boolean downPressed) {
        if (leftPressed) {
            x -= 5;
        }
        if (rightPressed) {
            x += 5;
        }
        if (upPressed) {
            y -= 5;
        }
        if (downPressed) {
            y += 5;
        }
    }
}
