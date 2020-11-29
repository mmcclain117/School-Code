package Mine;

import java.awt.*;
import java.util.Vector;

/**
 *
 * @author Master Ward
 */
class Graph extends Panel {

    public static Vector data = new Vector();

    static Point prev = new Point();
    static Point cur = new Point();

    static int xSpacing = 10;
    static int tempSize = 0;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        g.setColor(Color.blue);
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        tempSize = data.size();
        if (tempSize == 0) {
            return;
        }
        prev.x = 0;
        prev.y = getHeight() / 2;
        int nDraw = getWidth() / 2 / xSpacing;
        float fv = 0;
        for (int i = tempSize; i != 0; --i) {
            Float f = (Float) data.get(tempSize - i);
            fv = f * 2;
            if (fv > 160) {
                fv = 160.0f;
            } else if (fv < -160) {
                fv = -160.0f;
            }
            cur.x = getWidth() / 2 - (int) (xSpacing * i);
            cur.y = (int) (getHeight() / 2 + fv);
            if (f > 0) {
                g.setColor(Color.black);
            } else {
                g.setColor(Color.white);
            }
            g.drawLine(prev.x, prev.y, cur.x, cur.y);
            g.fillOval(cur.x - 2, cur.y - 2, 5, 5);
            prev.x = cur.x;
            prev.y = cur.y;
        }
    }
}
