import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    BufferedImage background;
    Player p;
    Enemy e;
    PlayerSpell ps;

    boolean leftPressed;
    boolean rightPressed;
    boolean upPressed;
    boolean downPressed;

    public GameCanvas() {
        e = new Enemy();
        p = new Player();
        ps = new PlayerSpell();
        ps.x = 170;
        ps.y = 450;
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            ps.loadImage();
            p.loadImage();
            e.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downPressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downPressed = false;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, 384, 600);
        g.drawImage(background, 0, 0, null);
        p.paint(g);
        e.paint(g);
        ps.paint(g);
    }

    void updateEnemyPosition() {
        e.updatePosition();
    }

    void updatePlayerPosition() {
        p.move(leftPressed, rightPressed, upPressed, downPressed);
    }

    void updatePlayerSpellPosition() {
        ps.move();
    }

    public void gameLoop() {
        while (true) {
            updatePlayerPosition();
            updateEnemyPosition();
            updatePlayerSpellPosition();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
