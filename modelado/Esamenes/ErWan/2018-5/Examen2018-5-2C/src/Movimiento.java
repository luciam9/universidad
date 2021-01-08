public class Movimiento implements EstadoAscensor{
    int piso = 0;

    public Movimiento(int piso){
        this.piso = piso;
    }

    @Override
    public void cero(Ascensor ascensor) {

    }

    @Override
    public void uno(Ascensor ascensor) {

    }

    @Override
    public void dos(Ascensor ascensor) {

    }

    @Override
    public void parar(Ascensor ascensor) {
        Motor m = new Motor(ascensor);
        int p = m.parar();
        ascensor.estado = new PuertasAbiertas();
        ascensor.setPiso(p);
        ascensor.setPuertasAbiertas(true);
        ascensor.setParado(true);
    }

    @Override
    public void cerrarPuertas(Ascensor ascensor) {

    }

    @Override
    public void abrirPuertas(Ascensor ascensor) {

    }

    @Override
    public void finMovimiento(Ascensor ascensor) {
        ascensor.estado = new PuertasAbiertas();
        ascensor.setPiso(piso);
        ascensor.setPuertasAbiertas(true);
        ascensor.setParado(true);
    }
}
