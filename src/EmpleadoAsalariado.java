class EmpleadoAsalariado extends Empleado {
    public EmpleadoAsalariado(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Tipo: Asalariado | Salario: " + calcularSalario();
    }
}