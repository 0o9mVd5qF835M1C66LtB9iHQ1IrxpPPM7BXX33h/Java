// Fig. 3.6: Welcomeapplet.java
// Um primeiro applet em Java

package applets;

// Pacotes do núcleo de Java
import java.awt.Graphics; // importa a classe Graphics

// Pacotes de extensão de Java
import javax.swing.JApplet; // importa a classe JApplet

public class Applet1 extends JApplet {

    // desenha texto sobre o fundo do applet
    public void paint( Graphics g )
    {
        // chama texto sobre o fundo do applet
        super.paint( g );

        // desenha um String nas cordenadas x=25 e y=25
        g.drawString( "Welcome to Java Programming!", 25, 25 );
    } // Fim do metodo paint
} // Fim da classe Applet1