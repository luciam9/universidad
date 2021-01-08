public class TextoEnmarcado extends TextoDecorador{
    public TextoEnmarcado(ITexto textoADecorar) {
        super(textoADecorar);
    }

    @Override
    public void dibujar(){
        super.dibujar();
        dibujarEnmarcado();
    }

    public void dibujarEnmarcado(){

    }
}
