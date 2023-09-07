import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionDatos {
    private static final String NOMBRE_ARCHIVO = "empleados.txt";
    private static List<Empleado> empleados = new ArrayList<>();

    public static void escribirEmpleados() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            for (Empleado empleado : empleados) {
                boolean empleadoExiste = false;
                try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        String[] partes = linea.split(",");
                        if (partes.length >= 1 && partes[0].equals(empleado.getNombre())) {
                            empleadoExiste = true;
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (!empleadoExiste) {
                    if (empleado instanceof EmpleadoAsalariado) {
                        writer.println(empleado.getNombre() + ",Asalariado," + empleado.calcularSalario() + ",Activo");
                    } else if (empleado instanceof EmpleadoPorHoras) {
                        writer.println(empleado.getNombre() + ",Por Horas," + empleado.calcularSalario() + ",Activo");
                    }
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
                if (partes.length >= 4 && partes[3].equals("Activo")) {
                    String nombre = partes[0];
                    String tipo = partes[1];
                    double salario = Double.parseDouble(partes[2]);
                    if (!empleadoYaRegistrado(nombre, salario)) {
                        if (tipo.equals("Asalariado")) {
                            empleados.add(new EmpleadoAsalariado(nombre, salario));
                        } else if (tipo.equals("Por Horas")) {
                            empleados.add(new EmpleadoPorHoras(nombre, salario, 0.0)); // Puedes establecer horas en 0, ya que no está en el archivo
                        }
                    }
                    System.out.println("Nombre: " + nombre + " | Tipo: " + tipo + " | Salario: " + salario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        leerEmpleados(); 
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Juana2run", 4000);
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Maria", 20, 45);

        agregarEmpleadoSiNoExiste(empleadoAsalariado);
        agregarEmpleadoSiNoExiste(empleadoPorHoras);

        escribirEmpleados();
    }

    private static void agregarEmpleadoSiNoExiste(Empleado empleado) {
        if (!empleados.contains(empleado)) {
            empleados.add(empleado);
        }
    }

    private static boolean empleadoYaRegistrado(String nombre, double salario) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre) && empleado.calcularSalario() == salario) {
                return true;
            }
        }
        return false;
    }
}





