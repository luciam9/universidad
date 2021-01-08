public class PuertasAbiertas implements EstadoAscensor{
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

    }

    @Override
    public void cerrarPuertas(Ascensor ascensor) {
        ascensor.estado = new PuertasCerradas();
        ascensor.setPuertasAbiertas(false);
    }

    @Override
    public void abrirPuertas(Ascensor ascensor) {

    }

    @Override
    public void finMovimiento(Ascensor ascensor) {

    }
}
