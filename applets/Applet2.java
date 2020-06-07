// Fig. 3.8: WelcomeApplet2.java
// Exibindo múltiplos strings em um applet.

package applets;

// Pacotes do núcleo de Java
import java.awt.Graphics;   // importa a classe Graphics

// Pacotes de extensão de Java
import javax.swing.JApplet; // importa a classe JApplet

public class Applet2 extends JApplet {

    // desenha texto no fundo do applet
    public void paint( Graphics g )
    {
        // chama a versão do método paint herdada
        super.paint( g );

    // desenha dois Strings em posições diferentes
        g.drawString( "Welcome to", 25, 25 );
        g.drawString( "Java programming!", 25, 40 );

    }   // fim do método paint

} // fim da classe Applet2