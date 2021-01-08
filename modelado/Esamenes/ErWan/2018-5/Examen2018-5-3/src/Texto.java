public class Texto implements ITexto{
    public String texto;

    public Texto(String texto){
        this.texto = texto;
    }

    @Override
    public void dibujar() {
        System.out.println(texto);
    }
}
