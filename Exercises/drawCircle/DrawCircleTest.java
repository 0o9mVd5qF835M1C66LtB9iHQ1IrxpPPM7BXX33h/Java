// DrawCircleTest.java
// Test application to display a Circular spiral.
import javax.swing.JFrame;

public class DrawCircleTest 
{
    public static void main( String args[] )
    {
        DrawCircle panel = new DrawCircle();
        JFrame application = new JFrame();

        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.add( panel );
        application.setSize( 472, 465 );
        application.setVisible( true );
    } // end main
} // end class DrawCircleTest