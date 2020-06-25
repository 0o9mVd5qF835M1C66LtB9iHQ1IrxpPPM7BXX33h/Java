// DrawSquareTest.java
// Test application to display a Square-shaped spiral.

package drawSquare;

import javax.swing.JFrame;

public class DrawSquareTest 
{
    public static void main( String args[] )
    {
        DrawSquare panel = new DrawSquare();
        JFrame application = new JFrame();

        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.add( panel );
        application.setSize( 472, 465 );
        application.setVisible( true );
    } // end main
} // end class DrawSquareTest