public class PuertasCerradas implements EstadoAscensor{
    @Override
    public void cero(Ascensor ascensor) {
        if(ascensor.getPiso() != 0){
            Motor m = ascensor.getMotor();
            m.moverseA(0);
            ascensor.estado = new Movimiento(0);
            ascensor.setParado(false);
        }else{
            ascensor.estado = new PuertasAbiertas();
            ascensor.setPuertasAbiertas(true);
        }
    }

    @Override
    public void uno(Ascensor ascensor) {
        if(ascensor.getPiso() != 1){
            Motor m = ascensor.getMotor();
            m.moverseA(1);
            ascensor.estado = new Movimiento(1);
            ascensor.setParado(false);
        }else{
            ascensor.estado = new PuertasAbiertas();
            ascensor.setPuertasAbiertas(true);
        }
    }

    @Override
    public void dos(Ascensor ascensor) {
        if(ascensor.getPiso() != 2){
            Motor m = ascensor.getMotor();
            m.moverseA(2);
            ascensor.estado = new Movimiento(2);
            ascensor.setParado(false);
        }else{
            ascensor.estado = new PuertasAbiertas();
            ascensor.setPuertasAbiertas(true);
        }
    }

    @Override
    public void parar(Ascensor ascensor) {

    }

    @Override
    public void cerrarPuertas(Ascensor ascensor) {

    }

    @Override
    public void abrirPuertas(Ascensor ascensor) {
        ascensor.estado = new PuertasAbiertas();
        ascensor.setPuertasAbiertas(true);
    }

    @Override
    public void finMovimiento(Ascensor ascensor) {

    }
}
