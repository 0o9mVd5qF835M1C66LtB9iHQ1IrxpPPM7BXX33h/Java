package test;

public record teste() {
    
    public static void main( String args[] )
    {
        int valor = (int) ( Math.random() * 1001 );
        while ( valor != 1000 ) {
            if ( valor == 1000 || valor == 0 ) {
                System.out.println( valor );
            }
        }
    }
}