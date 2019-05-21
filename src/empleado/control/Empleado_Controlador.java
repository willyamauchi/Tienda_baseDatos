package empleado.control;

import empleado.dominio.Empleado;
import empleado.persistencia.EmpleadoDAOImp;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Empleado_Controlador {

    private Empleado empleado;
    private EmpleadoDAOImp empleadoDaoImp;

    public Empleado_Controlador() {

        this.empleadoDaoImp = new EmpleadoDAOImp();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void login() {
        Scanner sc = new Scanner(System.in);

        while (this.empleado == null) {
            try {
                System.out.println("Ingrese su codigo:");
                int codigo = sc.nextInt();

                Empleado empleado = empleadoDaoImp.getEmpleadoporCodigo(codigo);
                if (empleado != null) {
                    System.out.println("Ingrese su Contraseña:");
                    String pass = sc.next();
                    if (empleado.getPassword().equals(pass)) {
                        System.out.println("");
                        System.out.println("\t---- Bienvenido " + empleado.getNombre() + " ----");
                        this.empleado = empleado;
                    } else {
                        System.out.println("Contraseña incorrecto");
                    }
                } else {
                    System.out.println("Codigo incorrecto");
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo se adminten numeros");
                sc.next();
            }

        }
    }

    public void cambiarPasswordEmpleado() {
        Scanner sc = new Scanner(System.in);
        int codigo, indice = 0;
        String nombreFile = "empleados.txt";
        boolean cambioPasswdOK;
        List<Empleado> empleado = new EmpleadoDAOImp().leerEmpleado();

        System.out.println(" ingrese el usuario a modificar su contraseña ");
        codigo = sc.nextInt();

        if (codigo > 0) {
            for (Empleado empleado1 : empleado) {
                if (codigo == empleado1.getCodigo()) {
                    System.out.println("Introdusca la nueva contraseña....");
                    String passwd = sc.next();
                    if (!passwd.equalsIgnoreCase(empleado1.getPassword())) {
                        empleado.get(indice).setPassword(passwd);
                        cambioPasswdOK = new EmpleadoDAOImp().actualizarEmpleado(empleado);
                        if (cambioPasswdOK) {
                            System.out.println("Se cambio la contraseña satisfactoriamente");

                        } else {
                            System.out.println("No se ha podiso actualizar el archivo" + nombreFile);
                        }

                    } else {
                        System.out.println("Contraseña igual que la anterior");
                    }
                }
                indice++;
            }
        }

    }

}
