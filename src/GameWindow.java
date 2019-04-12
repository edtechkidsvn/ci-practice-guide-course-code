import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame {
    GameCanvas gc;
    public GameWindow() {
        setResizable(false);
        setSize(384, 600);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        gc = new GameCanvas();
        setContentPane(gc);
        setVisible(true);
        gc.gameLoop();
    }
}
