public class TextoScroll extends TextoDecorador{
    public TextoScroll(ITexto textoADecorar) {
        super(textoADecorar);
    }

    @Override
    public void dibujar(){
        super.dibujar();
        dibujarScroll();
    }

    public void dibujarScroll(){

    }
}
