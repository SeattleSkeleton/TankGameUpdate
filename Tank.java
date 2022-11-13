import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tank extends Rectangle {

    int id;
    int yVelocity;
    int xVelocity;
    int speed = 17;

    Tank(int x, int y, int TANK_WIDTH, int TANK_HEIGHT, int id) {
        super(x, y, TANK_WIDTH, TANK_HEIGHT);
        this.id = id;

    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                ;
                if (e.getKeyChar() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyChar() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
                if (e.getKeyChar() == KeyEvent.VK_A) {
                    setXDirection(-speed);
                    move();
                }
                if (e.getKeyChar() == KeyEvent.VK_D) {
                    setXDirection(speed);
                    move();
                }
                break;
            case 2:
                ;
                if (e.getKeyChar() == KeyEvent.VK_I) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyChar() == KeyEvent.VK_K) {
                    setYDirection(speed);
                    move();
                }

                if (e.getKeyChar() == KeyEvent.VK_J) {
                    setXDirection(-speed);
                    move();
                }

                if (e.getKeyChar() == KeyEvent.VK_L) {
                    setXDirection(speed);
                    move();
                }
                break;

        }
    }

    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                ;
                if (e.getKeyChar() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyChar() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }

                if (e.getKeyChar() == KeyEvent.VK_A) {
                    setXDirection(0);
                    move();
                }

                if (e.getKeyChar() == KeyEvent.VK_D) {
                    setXDirection(0);
                    move();
                }


                break;
            case 2:

                if (e.getKeyChar() == KeyEvent.VK_I) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyChar() == KeyEvent.VK_K) {
                    setYDirection(0);
                    move();
                }

                if (e.getKeyChar() == KeyEvent.VK_J) {
                    setXDirection(0);
                    move();
                }

                if (e.getKeyChar() == KeyEvent.VK_L) {
                    setXDirection(0);
                    move();
                }
                break;

        }

    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;

    }

    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public void move() {
        y += yVelocity;
        x += xVelocity;


    }

    public void draw(Graphics g) {
        if (id == 1)
            g.setColor(Color.BLUE);
        else
            g.setColor(Color.RED);
        g.fillRect(x, y, width, height);


    }
}


