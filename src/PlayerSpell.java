import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerSpell {
    int x;
    int y;
    BufferedImage image;

    PlayerSpell(int xStart, int yStart) {
        x = xStart;
        y = yStart;
    }

    void loadImage() {
        try {
            image = ImageIO.read(new File("assets/images/player-spells/a/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void paint(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    void move() {
        y -= 8;
    }
}
