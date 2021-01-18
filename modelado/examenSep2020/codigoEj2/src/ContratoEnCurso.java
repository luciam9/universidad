public class ContratoEnCurso {

    Integer salario;
    Integer comienzo;
    Boolean aTiempoCompleto;
    Empleado empleado;
    Empresa empresa;

    public ContratoEnCurso(Integer salario, Integer comienzo,
                           Boolean aTiempoCompleto, Empleado empleado,
                           Empresa empresa) {
        this.salario = salario;
        this.comienzo = comienzo;
        this.aTiempoCompleto = aTiempoCompleto;
        this.empleado = empleado;
        this.empresa = empresa;
    }


}
