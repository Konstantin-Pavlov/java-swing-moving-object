import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Загрузка изображения
        ImageIcon imageIcon = new ImageIcon("madCat.jpg");

        // Создание окна
        JFrame frame = new JFrame("mad cat");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label = new JLabel(imageIcon); // Создание компонента для отображения изображения
        label.setBounds(0, 0, 100, 100); // Установка координат и размеров метки
        frame.add(label); // Добавление компонента на окно

        frame.setSize(800, 600); // Установка размеров окна

        frame.setVisible(true); // Отображение окна
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
