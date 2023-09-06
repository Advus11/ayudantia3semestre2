class EmpleadoPorHoras extends Empleado {
    private double salarioPorHora;
    private double horasTrabajadas;

    public EmpleadoPorHoras(String nombre, double salarioPorHora, double horasTrabajadas) {
        super(nombre, 0); // El salario base para empleados por horas se inicializa en 0
        this.salarioPorHora = salarioPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return salarioPorHora * horasTrabajadas;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Tipo: Por Horas | Salario: " + calcularSalario();
    }
}
