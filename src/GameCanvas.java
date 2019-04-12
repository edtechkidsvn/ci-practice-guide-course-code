import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage background;
    BufferedImage player;
    int playerX = 176;
    int playerY = 500;

    Enemy e;

    boolean leftPressed;
    boolean rightPressed;
    boolean upPressed;
    boolean downPressed;

    public GameCanvas() {
        e = new Enemy();
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
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
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed = true;
                } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downPressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = false;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed = false;
                } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
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
        g.drawImage(player, playerX, playerY, null);
        e.paint(g);
    }

    void updateEnemyPosition() {
        e.updatePosition();
    }

    void updatePlayerPosition() {
        if(leftPressed) {
            playerX -= 5;
        }
        if(rightPressed) {
            playerX += 5;
        }
        if(upPressed) {
            playerY -= 5;
        }
        if(downPressed) {
            playerY += 5;
        }
    }

    public void gameLoop() {
        while(true) {
            updatePlayerPosition();
            updateEnemyPosition();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
