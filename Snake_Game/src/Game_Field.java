import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.event.ActionListener;

public class Game_Field extends JPanel implements ActionListener {
    private final int SIZE = 640;
    private final int SIZE_CELL = 16;
    private final int ALL_CELLS = 1600;
    private Image dot;
    private Image apple;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_CELLS];
    private int[] y = new int[ALL_CELLS];
    private Timer timer;
    private int snake_length;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean play = true;
    public Game_Field() {
        setBackground(Color.pink);
        image_upload();
        start_game();
        addKeyListener( new FieldKey());
        setFocusable(true);
    }

    public void start_game() {
        snake_length = 3;
        for (int i = 0; i < snake_length; i++) {
            x[i] = 48 - i*SIZE_CELL;
            y[i] = 48;
        }
        timer = new Timer(250, this);
        timer.start();
        create_apple();
    }

    public void create_apple() {
    appleX = new Random().nextInt(40)*SIZE_CELL;
    appleY = new Random().nextInt(40)*SIZE_CELL;
    }

    public void image_upload() {
    ImageIcon iap = new ImageIcon("яблочко.png");
    apple = iap.getImage();
    ImageIcon isn = new ImageIcon("змейка.png");
    dot = isn.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (play) {
                g.drawImage(apple, appleX, appleY, this);
                for (int i = 0; i < snake_length; i++) {
                    g.drawImage(dot, x[i], y[i], this);
                }
            } else {
                String name = "Game over(((";
                Font f = new Font("TimesRoman", Font.BOLD, 60);
                g.setColor(Color.RED);
                g.setFont(f);
                g.drawString(name, 120, SIZE / 2);
            }
    }

    public void move() {
        for (int i = snake_length; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if(left) { x[0] -= SIZE_CELL; }
        if(right) { x[0] += SIZE_CELL; }
        if(up) { y[0] -= SIZE_CELL; }
        if(down) { y[0] += SIZE_CELL; }
    }

    public void checkApple() {
        if(x[0] == appleX && y[0] == appleY) {
            snake_length++;
            create_apple();
        }
    }

    public void checkSide() {
        for (int i = snake_length; i > 0 ; i--) {
            if(i >=4 && x[0] == x[i] && y[0] == y[i]) { play = false;}
        }
        if( x[0] > SIZE) play = false;
        if( x[0] < 0) play = false;
        if( y[0] > SIZE) play = false;
        if( y[0] < 0) play = false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(play) {
            checkApple();
            checkSide();
            move();
        }
        repaint();
    }

    class FieldKey extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && !right) {
                left = true;
                down = false;
                up = false;
            }
            if(key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                down = false;
                up = false;
            }
            if(key == KeyEvent.VK_UP && !down) {
                left = false;
                right = false;
                up = true;
            }
            if(key == KeyEvent.VK_DOWN && !up) {
                left = false;
                right = false;
                down = true;
            }
        }
    }
}
