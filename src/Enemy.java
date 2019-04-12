import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy extends GameObject {
    void loadImage() {
        try {
            image = ImageIO.read(new File("assets/images/enemies/level0/blue/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updatePosition() {
        y += 1;
    }
}

