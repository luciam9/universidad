/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class SubArrayMaximoNLOGN extends SubArrayMaximo {

	
	
	
	public SolucionSubArrayMaximo resolver(int[] array) {
		
		int[] dif = vectorDiferencias(array);
		
		
		vector max = divideVenceras(dif, 0, dif.length-1);
		
		
		SolucionSubArrayMaximo ssam = new SolucionSubArrayMaximo(max.getSuma(), max.getMin(), max.getMax()+1);
		
		return ssam;
	}
	
	
	
	
	public vector divideVenceras(int[] vec, int min, int max) {
		
		
		if(min > max) return new vector(min, max, 0);
		if(min == max) return new vector(min, min, vec[min]);
		
		int medio = (min + max)/2;
		
		vector n1 = divideVenceras(vec, min, medio);
		vector n2 = divideVenceras(vec, medio+1, max);
		
		int max1 = vec[medio];
		int s1 = vec[medio];
		int lim1 = medio;
		
		for(int i=medio-1; i>=min; i--) {
			
			s1 = s1 + vec[i];
			
			if(s1 > max1) {
				
				max1 = s1;
				lim1 = i;
			}
		}
		
		int max2 = vec[medio+1];
		int s2 = vec[medio+1];
		int lim2 = medio+1;
		
		for(int j=medio+2; j<=max; j++) {
			
			s2 = s2 + vec[j];
			
			if(s2 > max2) {
				
				max2 = s2;
				lim2 = j;
			}
		}
		
		int maximo = max1 + max2;
		
		if(n1.getSuma()>=n2.getSuma() && n1.getSuma()>= maximo) {
			
			return n1;
		}
		
		else if(n2.getSuma()>=n1.getSuma() && n2.getSuma()>= maximo) {
			
			return n2;
		}
		
		else return new vector(lim1, lim2, maximo);
		
		
	}
	
public static class vector{
		
		private final int min, max, suma;
		
		public vector(int min, int max, int suma) {
			
			this.min = min;
			this.max = max;
			this.suma = suma;
		}
		
		public int getMax(){
		
			return max;
		}
		
		public int getMin() {
			
			return min;
		}
		
		public int getSuma() {
			
			return suma;
		}
	
}}
