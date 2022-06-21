import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 640);
        setLocation(300, 30);
        add(new Game_Field());
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow wind = new MainWindow();
    }
}
