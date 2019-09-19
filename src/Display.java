import java.awt.*;
import java.awt.geom.AffineTransform;

public class Display extends Canvas {
    private final double TIC_DIST = 15;

    private final int DIAMETER = 7;
    private final int OFFSET = (int)(DIAMETER/2);

    void drawAxes(Graphics graphics, int x1, int y1, int x2, int y2){
        Graphics2D g = (Graphics2D)graphics.create();
        double dx = x2-x1, dy = y2-y1;
        double length = Math.sqrt(dx*dx + dy*dy);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(Math.atan2(dy, dx)));
        g.transform(at);

        g.setColor(Color.LIGHT_GRAY);
        for(int i = 0; i < length/2; i += TIC_DIST){
            g.drawLine(i,Integer.MIN_VALUE,i,Integer.MAX_VALUE);
        }
        for(int i = (int)((length/2)+TIC_DIST); i < length; i += TIC_DIST){
            g.drawLine(i,Integer.MIN_VALUE,i,Integer.MAX_VALUE);
        }
        g.setColor(Color.BLACK);
        g.drawLine(0,0, (int)length, 0);
        g.drawLine(0,(int)length, 0, 0);
    }
    public void paint(Graphics g){
        //Origin = 350, 300

        drawAxes(g,0,300,600,300);
        drawAxes(g,300,0,300,600);

        // Origin at 300, 300

        // point's x and y coord. is # - OFFSET
        // each line = TIC_DIST apart

        g.fillOval(315-OFFSET,315-OFFSET,DIAMETER,DIAMETER);
    }
}
