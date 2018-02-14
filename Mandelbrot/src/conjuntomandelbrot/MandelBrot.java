/**
 * Se utiliza el estándar de Oracle
 * @author Jose Luis Quiroz Fabian
 *
 */


import java.awt.Color;

class MandelBrot{

    MandelBrot(){
        dibujar();
    }
    void dibujarFractalMaldebrot(){
		
        double epsilon = 0.01; 
        double x;
        double y;
        int maxIteraciones = 10;
        int iteraciones;
        Complejo Z=null;
        Complejo C=null;
        Complejo aux=null;
        /*Se cambia la escala, por default es 0-1*/      
        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1,1);
        StdDraw.text(0.0, 1.5, "Conjunto de Mandelbrot");
       
        for(x=-1; x<=1; x+= epsilon)
        {
            for(y=-1; y<=1; y+= epsilon)
            {
            	StdDraw.setPenColor(Color.RED);
                iteraciones = 0;
                C = new Complejo(x, y);
                Z = new Complejo(0,0);
                
                while(Complejo.abs(Z) < 2 && iteraciones < maxIteraciones)
                {
                    aux = Complejo.suma(Complejo.mult(Z, Z),C);
                    Z = aux;
                    iteraciones++;
                }
                if(iteraciones==maxIteraciones){        
                	StdDraw.point(x, y);
                }else{
                	StdDraw.setPenColor(Color.BLUE);
                	StdDraw.point(x, y);
                }	
            }
        }  
		
		
	}
	
	
   
     public void dibujar() {
        dibujarFractalMaldebrot();		
     }
	
     public static void main(String[] arg){
		
        new MandelBrot();
     }
}

