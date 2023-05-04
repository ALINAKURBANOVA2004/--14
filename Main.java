import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Main
{
    public static void main(String[] args)
    {
        JFrame w = new JFrame("ПО кругу");
        w.setSize(1500,1500);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setLayout(new BorderLayout(1,1));
        Canvas canvas = new Canvas();
        w.add(canvas);
        w.setVisible(true);
    }
}

class Canvas extends JComponent implements ActionListener
{
    public Canvas()
    {
        super();
        Timer timer=new Timer(20,this);
        timer.start();
    }
    int x;int y;int x0=150;int y0=150;double angle=0;
    @Override
    public void actionPerformed(ActionEvent e){
        x=(int)(x0+100*Math.cos(angle));
        y=(int)(y0+100*Math.sin(angle));
        angle+=0.25;
        repaint();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Color c1 = new Color(255,255,0);
        g2d.setStroke(new BasicStroke(2));
        g2d.fillOval(x,y,100,100);

        super.repaint();
    }
}