// drawSquare.java
// An application that will create square-shaped spiral.

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawSquare extends JPanel {

    final String ORDER[] = { "Down", "Left", "Up", "Right" };

    // constructor
    public DrawSquare()
    {
        setBackground( Color.WHITE ); // set the background to white
    } // end DrawSquare constructor

    // draws a square-shaped spiral using drawLine
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        int length = 0;
        int currentX = getWidth() / 2;
        int currentY = getHeight() / 2;

        for ( int counter = 1; counter <= 3; counter++ ) 
            for( String direction : ORDER )
            {
                g.setColor( Color.RED );

                if ( direction.equals( "Up" ) || direction.equals( "Down" ) ) {
                    length += 60;
                } 

                if ( direction.equals( "Left" ) ) {
                    g.drawLine( currentX, currentY, currentX - length, currentY);

                    currentX -= length;
                } else if ( direction.equals( "Up" ) ) {
                    g.drawLine( currentX, currentY, currentX, currentY - length );

                    currentY -= length;
                } else if ( direction.equals( "Right" ) ) {
                    g.drawLine( currentX, currentY, currentX + length, currentY );

                    currentX += length;
                } else if ( direction.equals( "Down" ) ) {
                    g.drawLine( currentX, currentY, currentX, currentY + length );

                    currentY += length;
                }

            } // end for 

        // The last line
        g.setColor( Color.RED );
        length += 60;
        g.drawLine( currentX, currentY, currentX, currentY + length );

    } // end method paintComponent
} // end class DrawSquare