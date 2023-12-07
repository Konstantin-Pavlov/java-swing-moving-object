import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private int x = 0; // начальные координаты изображения
    private int y = 0;
    JPanel panel;

    public Main() {
        setTitle("Перемещение изображения");
        setSize(800, 600); // Установка размеров окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon image = new ImageIcon("madCat.jpg"); // путь к изображению
                image.paintIcon(this, g, x, y);
            }
        };

        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int shft = 10;
                if (keyCode == KeyEvent.VK_LEFT) {
                    x -= shft; // смещение изображения влево
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    x += shft; // смещение изображения вправо
                } else if (keyCode == KeyEvent.VK_UP) {
                    y -= shft; // смещение изображения вверх
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    y += shft; // смещение изображения вниз
                }

                // проверка чтобы изображение не выходило за пределы экрана
                // если вышло, оно появляется на противополжной стороне
                x = x < 0 ? 690 : x;
                x = x > 690 ? 0 : x;
                y = y < 0 ? 470 : y;
                y = y > 470 ? 0 : y;
                // System.out.println(x + " " + y);
                panel.repaint(); // перерисовка панели
            }
        });

        add(panel);

    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater(Main::new); // one way to run this

        Main main = new Main(); // another way to run this
        main.setVisible(true);
        centerFrameOnScreen(main);

        Dimension panelSize = main.panel.getSize();

        int panelWidth = panelSize.width;
        int panelHeight = panelSize.height;

        System.out.println("Panel size: " + panelWidth + " x " + panelHeight);

    }

    private static void centerFrameOnScreen(JFrame frame) {
        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate the position to center the frame
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        // Set the frame's location
        frame.setLocation(x, y);
    }
}
