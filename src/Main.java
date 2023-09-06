import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();

        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Juan", 3000.0);
        empleados.add(empleadoAsalariado);

        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Maria", 15.0, 40.0);
        empleados.add(empleadoPorHoras);

        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
    }
}