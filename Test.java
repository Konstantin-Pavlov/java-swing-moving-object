import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


// вариант реализации
//баг -  картинка не появляется в окне
public class Test extends JFrame {

    public static void main(String[] args) throws IOException {

        new MyFrame();
    }

}

// ДАЛЕЕ СОЗДАЁМ КЛАСС В НОВОМ ОКНЕ
class MyFrame extends JFrame implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

        switch (e.getKeyChar()) {
            case 'a' -> label.setLocation(label.getX() - 20, label.getY());
            case 'w' -> label.setLocation(label.getX(), label.getY() - 20);
            case 'd' -> label.setLocation(label.getX() + 20, label.getY());
            case 's' -> label.setLocation(label.getX(), label.getY() + 20);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Released: " + e.getKeyChar());
        System.out.println("Code: " + e.getKeyCode());
    }

    JLabel label = new JLabel();
    static int width = 800, height = 600;// размеры окна

    MyFrame() throws IOException {

        this.setVisible(true); // окошко
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // для его закрытия
        this.setTitle("Пикассо");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height + 30);
        this.addKeyListener(this);

        // скачиваем картинку
        BufferedImage im = ImageIO.read(new URL("https://tgram.ru/wiki/stickers/img/rmrick/png/6.png"));

        // создаем панель, чтобы ей отлавливать события клавиатуры, ставим ее слева
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // делаем у панели возможность принимать фокус, иначе она не сможет отловить
        // события клавиатуры
        panel.setFocusable(true);

        // создаем объект слева
        label = new JLabel(new ImageIcon("madCat.jpg"), JLabel.RIGHT);

        // добавляем на панель
        panel.add(label, BorderLayout.NORTH);

        // добавляем панель на форму
        this.add(panel);
    }
}