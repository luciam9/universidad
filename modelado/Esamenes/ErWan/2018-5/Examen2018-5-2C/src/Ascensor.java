public class Ascensor {
    private int piso;
    private boolean puertasAbiertas;
    private boolean parado;
    private Motor motor;
    protected EstadoAscensor estado;

    public Ascensor(){
        piso = 0;
        puertasAbiertas = true;
        parado = true;
        motor = new Motor(this);
        estado = new PuertasAbiertas();
    }

    public void cero(){
        estado.cero(this);
    }

    public void uno(){
        estado.uno(this);
    }

    public void dos(){
        estado.dos(this);
    }

    public void parar(){
        estado.parar(this);
    }

    public void cerrarPuertas(){
        estado.cerrarPuertas(this);
    }

    public void abrirPuertas(){
        estado.abrirPuertas(this);
    }

    public void finMovimiento(){
        estado.finMovimiento(this);
    }

    public int getPiso() {
        return piso;
    }

    protected void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isPuertasAbiertas() {
        return puertasAbiertas;
    }

    protected void setPuertasAbiertas(boolean puertasAbiertas) {
        this.puertasAbiertas = puertasAbiertas;
    }

    public boolean isParado() {
        return parado;
    }

    protected void setParado(boolean parado) {
        this.parado = parado;
    }

    public Motor getMotor() {
        return motor;
    }
}
