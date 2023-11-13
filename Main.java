import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private int x = 200; // начальные координаты изображения
    private int y = 200;

    public Main() {
        setTitle("Перемещение изображения");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
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
                if (keyCode == KeyEvent.VK_LEFT) {
                    x -= 50; // смещение изображения влево
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    x += 50; // смещение изображения вправо
                } else if (keyCode == KeyEvent.VK_UP) {
                    y -= 50; // смещение изображения вверх
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    y += 50; // смещение изображения вниз
                }
                panel.repaint(); // перерисовка панели
            }
        });

        add(panel);
        setVisible(true);

        setSize(800, 600); // Установка размеров окна

        setVisible(true); // Отображение окна
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());

    }

    // private static void centerFrameOnScreen(JFrame frame) {
    // // Get the size of the screen
    // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    // // Calculate the position to center the frame
    // int x = (screenSize.width - frame.getWidth()) / 2;
    // int y = (screenSize.height - frame.getHeight()) / 2;

    // // Set the frame's location
    // frame.setLocation(x, y);
    // }
}
