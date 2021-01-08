public abstract class TextoDecorador implements ITexto{
    protected ITexto textoADecorar;

    public TextoDecorador(ITexto textoADecorar){
        this.textoADecorar = textoADecorar;
    }

    @Override
    public void dibujar() {
        textoADecorar.dibujar();
    }
}
