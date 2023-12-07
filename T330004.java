import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

// todo отредактировать
//  другой вариант
public class T330004 {
    static JFrame frame = new JFrame();// создаем форму
    static JLabel l;// объект с картинкой
    static int width = 300, height = 300;// задаем размер окна
    static int change = 50;// на сколько точек двигаем объект
    private final static String url = "https://www.gravatar.com/avatar/1e34435a30921642e976c2a1001dcee0?s=50&d=mm&r=pg";

    static public void move(KeyEvent e) {// метод движения по клавиатуре
        switch (e.getKeyCode()) {// делаем проверку на границы формы
            case (KeyEvent.VK_LEFT):
                if (l.getX() - change >= 0)
                    l.setLocation(l.getX() - change, l.getY());
                break;
            case (KeyEvent.VK_RIGHT):
                if (l.getX() + change < width - l.getWidth())
                    l.setLocation(l.getX() + change, l.getY());
                break;
            case (KeyEvent.VK_UP):
                if (l.getY() - change >= 0)
                    l.setLocation(l.getX(), l.getY() - change);
                break;
            case (KeyEvent.VK_DOWN):
                if (l.getY() + change < height - l.getHeight())
                    l.setLocation(l.getX(), l.getY() + change);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// способ выхода из формы
        frame.setTitle("Простое перемещение клавиатурой");// заголовок формы
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();// определяем разрешение монитора
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);// выставляем размеры
                                                                                               // окна
        BufferedImage im = ImageIO.read(new URL(url)); // скачиваем картинку

        // создаем панель, чтобы ей отлавливать события клавиатуры, ставим ее слева
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // делаем у панели возможность принимать фокус, иначе она не сможет отловить
        // события клавиатуры
        panel.setFocusable(true);

        // создаем объект слева
        l = new JLabel(new ImageIcon(im), JLabel.RIGHT);

        // добавляем на панель
        panel.add(l, BorderLayout.NORTH);

        // добавляем панель на форму
        frame.add(panel);

        // добавляем слушателя на панель метод движения
        panel.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                move(e);
            }
        });

        frame.setVisible(true);// делаем форму видимой
    }
}