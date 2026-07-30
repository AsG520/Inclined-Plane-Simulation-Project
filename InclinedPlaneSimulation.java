import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class InclinedPlaneSimulation extends JPanel {
    static Ball ball = new Ball();
    static JFrame frame;
    static Timer timer;

    public static void main(String[] args) {
        int fw = 710;
        int fh = 500;
        String ft = "Inclined Plane Simulation";
        int fb[] = { 0, 0, 0 };
        boolean fv = true;
        boolean fr = false;

        int td = 100;

        int fx = 448;
        int fy = 411;

        frame = new JFrame(ft);
        frame.setSize(fw, fh);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(fr);
        InclinedPlaneSimulation panel = new InclinedPlaneSimulation();
        panel.setBackground(new Color(fb[0], fb[1], fb[2]));
        frame.setVisible(fv);
        frame.add(panel);

        double g = 9.8;
        double theta = Math.atan2(470, 20);
        ball.r = 0.6;
        ball.m = 5.0;
        ball.dx = 70.0;
        ball.dy = 35.0;
        ball.w = 50.0;
        ball.h = 50.0;
        ball.fk = 15.0;
        ball.fn = ball.m * g;
        ball.uk = ball.fk / ball.fn;
        ball.ax = ball.m * g * Math.sin(theta) - ball.uk * ball.m * g * Math.cos(theta) / ball.m;
        ball.ay = ball.m * g - ball.m * g * Math.cos(theta) / ball.m;

        timer = new Timer(td, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Horizontal Position (px): " + (int) ball.dx);
                System.out.println("Vertical Position (px): " + (int) ball.dy + "\n");

                wallCollision();

                if (ball.dx >= fx) {
                    ball.dx = fx;
                    ball.dx += ball.vx;
                } else {
                    updateX();
                }

                if (ball.dy >= fy) {
                    ball.dy = fy;
                } else {
                    updateY();
                }

                panel.repaint();
            }
        });
        timer.start();
    }

    public static void updateX() {
        ball.vx += ball.ax;
        ball.dx += ball.vx;
    }

    public static void updateY() {
        ball.vy += ball.ay;
        ball.dy += ball.vy;
    }

    public static void wallCollision() {
        int wr = 643;

        if (ball.dx >= wr) {
            ball.dx = wr;

            ball.vx += -ball.ax;
            ball.dx += ball.vx;
        }
    }

    public static class Ball {
        double ax;
        double ay;
        double fn;
        double fk;
        double uk;
        double vx;
        double vy;
        double m;
        double dx;
        double dy;
        double w;
        double h;
        double r;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x1 = 0;
        int x2 = 0;
        int x3 = 490;

        int y1 = 0;
        int y2 = 470;
        int y3 = 490;

        int totalPoints = 3;

        int rc[] = { 0, 255, 255 };
        int bc[] = { 255, 0, 0 };

        int[] tx = { x1, x2, x3 };
        int[] ty = { y1, y2, y3 };

        g.setColor(new Color(rc[0], rc[1], rc[2]));
        g.drawPolygon(tx, ty, totalPoints);
        g.fillPolygon(tx, ty, totalPoints);

        g.setColor(new Color(bc[0], bc[1], bc[2]));
        g.drawOval((int) ball.dx, (int) ball.dy, (int) ball.w, (int) ball.h);
        g.fillOval((int) ball.dx, (int) ball.dy, (int) ball.w, (int) ball.h);
    }
}
