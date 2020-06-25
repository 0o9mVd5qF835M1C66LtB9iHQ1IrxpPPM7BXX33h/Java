// DrawCircle.java
// An application that will create a Circular spiral.

package drawCircle;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawCircle extends JPanel 
{
    // constructor
    public DrawCircle()
    {
        setBackground( Color.WHITE ); // set the background to white
    } // end DrawCircle constructor

    // draws a circular spiral using concentric arcs
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        int arcAngle = 20;
        int currentX = getWidth() / 2;
        int currentY = getHeight() / 2;
        int width = 50;
        int height = 50;
        int startAngle = 0;

        for ( int counter = 1; counter <= 400; counter++ )
        {
            g.setColor( Color.BLUE );

            g.drawArc( currentX, currentY, width, height, startAngle, arcAngle );

            currentX--;
            currentY--;

            width += 2;
            height += 2;
            startAngle -= arcAngle;

        } // end for
    } // end merhod paintComponent
} // end class DrawCircle