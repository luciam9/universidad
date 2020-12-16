class Bolsa {
	
	public static void main(String args[]) {
		SubArrayMaximo sam = new SubArrayMaximoN();		
		int[] problema = {8, 2, 45, 74, 53, 25, 77, 95, 56, 14};
		SolucionSubArrayMaximo solucion = sam.resolver(problema);
		SubArrayMaximo.salidaProblema(System.out, problema, solucion);
	}
	
}