/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class SubArrayMaximoN extends SubArrayMaximo {

	public SolucionSubArrayMaximo resolver(int[] array) {
		
		int[] dif = vectorDiferencias(array);
		
		int suma = 0;
		int min = 0;
		int max =0;
		int maxdef = 0;
		int mindef = 0;
		int sumamax = 0;
		
		for(int i = 0; i<dif.length; i++) {
			
			max = i;
			
			if(suma <= 0) {
				
				min = max;
				suma = dif[i];
				
			}else {
				
				suma = suma + dif[i];
			}
			
			if(suma > sumamax) {
				
				sumamax = suma;
				maxdef = max;
				mindef = min;
			}
		}
			
		SolucionSubArrayMaximo ssam = new SolucionSubArrayMaximo(sumamax, mindef, maxdef + 1);
			
		return ssam;
	}
	
	
}
