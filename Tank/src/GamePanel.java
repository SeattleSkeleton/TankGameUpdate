import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BULLET_DIAMETER = 20;
    static final int TANK_WIDTH = 55;
    static final int TANK_HEIGHT = 55;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Tank tank1;
    Tank tank2;
    Bullet bullet;
    Score score;

    GamePanel() {
        newTanks();
        newBullet();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }

    public void newBullet() {
        //random = new Random();
        bullet = new Bullet((GAME_WIDTH/2)-(BULLET_DIAMETER/2),(GAME_HEIGHT/2)-(BULLET_DIAMETER/2),BULLET_DIAMETER,BULLET_DIAMETER);

    }
    public void newTanks() {
        tank1 = new Tank(66,(GAME_HEIGHT/2)-(TANK_HEIGHT/2),TANK_WIDTH,TANK_HEIGHT,1);
        tank2 = new Tank(910,(GAME_HEIGHT/2)-(TANK_HEIGHT/2),TANK_WIDTH,TANK_HEIGHT,2);

    }
    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
        Toolkit.getDefaultToolkit().sync();

    }
    public void draw(Graphics g) {
        tank1.draw(g);
        tank2.draw(g);



    }
    public void move() {
        tank1.move();
        tank2.move();

    }
    public void checkCollision() {




        //Give a player one point and creates new play
        if(bullet.x <=0) {
            score.player2++;
            newTanks();
            newBullet();
            System.out.println("Player 2" + score.player2);
        }
        if(bullet.x >= GAME_WIDTH-BULLET_DIAMETER) {
            score.player1++;
            newTanks();
            newBullet();
            System.out.println("Player 1" + score.player1);
        }


    }
    public void run() {
        //game loop
        //noinspection InfiniteLoopStatement
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) {
                move();
                checkCollision();
                repaint();
                delta--;


            }
        }

    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            tank1.keyPressed(e);
            tank2.keyPressed(e);

        }
        public void keyReleased(KeyEvent e) {
            tank1.keyReleased(e);
            tank2.keyReleased(e);


        }

    }

}
