/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class SubArrayMaximoN2 extends SubArrayMaximo {

	public SolucionSubArrayMaximo resolver(int[] array) {
		
		int primerdia = 0;
		int ultimodia = 0;
		int ganancias;
		int maximo = 0;
		
		for(int i=0; i<array.length; i++)
		{
			for(int j = i+1; j<array.length; j++) {
				
				ganancias = array[j] - array[i];
				
				if(ganancias > maximo) {
					
					maximo = ganancias;
					primerdia = i;
					ultimodia = j;
				}
			}
		}
		
		SolucionSubArrayMaximo ssam = new SolucionSubArrayMaximo(maximo, primerdia, ultimodia);
		return ssam;
	}
	
}
