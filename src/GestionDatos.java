import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionDatos {
    private static final String NOMBRE_ARCHIVO = "empleados.txt";
    private static List<Empleado> empleados = new ArrayList<>();

    public static void escribirEmpleados() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            for (Empleado empleado : empleados) {
                if (empleado instanceof EmpleadoAsalariado) {
                    writer.println(empleado.getNombre() + ",Asalariado," + empleado.calcularSalario());
                } else if (empleado instanceof EmpleadoPorHoras) {
                    writer.println(empleado.getNombre() + ",Por Horas," + empleado.calcularSalario());
                }
            }
            System.out.println("Datos de empleados escritos en el archivo " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerEmpleados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            System.out.println("Nombres, Tipo y Salarios de empleados almacenados en el archivo:");
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    String tipo = partes[1];
                    double salario = Double.parseDouble(partes[2]);
                    System.out.println("Nombre: " + nombre + " | Tipo: " + tipo + " | Salario: " + salario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Juan", 3000);
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Maria", 15, 40);

        // Agregar empleados a la lista
        empleados.add(empleadoAsalariado);
        empleados.add(empleadoPorHoras);

        // Agregar más empleados si es necesario
        EmpleadoAsalariado nuevoAsalariado = new EmpleadoAsalariado("Ana", 3500);
        empleados.add(nuevoAsalariado);

        EmpleadoAsalariado nuevoAsalariado2 = new EmpleadoAsalariado("Adonis", 4000);
        empleados.add(nuevoAsalariado2);

        EmpleadoPorHoras nuevoPorHoras = new EmpleadoPorHoras("Carlos", 12, 45);
        empleados.add(nuevoPorHoras);

        escribirEmpleados();
        leerEmpleados();
    }
}



