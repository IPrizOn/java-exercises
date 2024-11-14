import java.awt.*;
import javax.swing.*;

public class Butterfly extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Голова
        g2d.setColor(Color.BLACK);
        g2d.fillOval(128, 75, 20, 25);
        g2d.setColor(Color.WHITE);

        // Усики
        g2d.drawLine(137, 76, 160, 50);
        g2d.drawLine(137, 76, 120, 50);
        g2d.fillOval(155, 45, 10, 10);
        g2d.fillOval(115, 45, 10, 10);
        g2d.setColor(Color.BLACK);

        // Крылья
        int x = 108;
        int y = 110;
        int width = 35;
        int high = 75;

        // Левое верхнее крыло
        g2d.rotate(Math.toRadians(45), x + width / 2, y + high / 2);
        g2d.fillRect(x, y + 30, width, high);
        g2d.rotate(Math.toRadians(-45), x + width / 2, y + high / 2);

        // Правое верхнее крыло
        g2d.rotate(Math.toRadians(45), x + width / 2 + 100, y + high / 2);
        g2d.fillRect(x + 50, y + 25, width, high);
        g2d.rotate(Math.toRadians(-45), x + width / 2 + 100, y + high / 2);

        // Левое нижнее крыло
        g2d.rotate(Math.toRadians(-45), x + width / 2, y + high / 2);
        g2d.fillRect(x, y - 25, width, high);
        g2d.rotate(Math.toRadians(45), x + width / 2, y + high / 2);

        // Правое нижнее крыло
        g2d.rotate(Math.toRadians(-45), x + width / 2 + 100, y + high / 2);
        g2d.fillRect(x + 50, y - 20, width, high);
        g2d.rotate(Math.toRadians(45), x + width / 2 + 100, y + high / 2);

        // Тело
        g2d.setColor(Color.WHITE);
        g2d.fillOval(125, 100, 25, 100);

        // Пятна на крыльях
        g2d.fillOval(90, 110, 15, 20);
        g2d.fillOval(170, 110, 15, 20);
        g2d.fillOval(100, 155, 20, 10);
        g2d.fillOval(85, 170, 15, 20);
        g2d.fillOval(155, 150, 20, 10);
        g2d.fillOval(180, 170, 15, 20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Бабочка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(new Butterfly());
        frame.setVisible(true);
    }
}