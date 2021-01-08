public class TextoColoreado extends TextoDecorador{
    public TextoColoreado(ITexto textoADecorar) {
        super(textoADecorar);
    }

    @Override
    public void dibujar(){
        super.dibujar();
        dibujarColoreado();
    }

    public void dibujarColoreado(){

    }
}
