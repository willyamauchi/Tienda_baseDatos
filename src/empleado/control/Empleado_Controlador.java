package empleado.control;

import Excepciones.CodigoError_Enum;
import Excepciones.NombreArchivoIncorrectoExeption;
import empleado.dominio.Empleado;
import empleado.persistencia.EmpleadoDAOImp;
import java.util.InputMismatchException;
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

                    comprobarpassw(empleado, pass);

                } else {
                    System.out.println("Codigo incorrecto");
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo se adminten numeros");
                sc.next();
            } catch (NombreArchivoIncorrectoExeption e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void comprobarpassw(Empleado empleado, String pass) {
        if (empleado.getPassword().equals(pass)) {
            System.out.println("");
            System.out.println("\t---- Bienvenido " + empleado.getNombre() + " ----");
            this.empleado = empleado;
        } else {
            throw new NombreArchivoIncorrectoExeption(CodigoError_Enum.ERROR_PASSWORD_ERRADO);
        }
    }

    public void cambiarPasswordEmpleado() {
        
        Scanner sc = new Scanner(System.in);
        int codigo;
        String nuevoPasswd,passwd;
        boolean cambioPasswdOK;
        codigo=this.empleado.getCodigo();
        passwd=this.empleado.getPassword();                    
                    System.out.println("Introdusca la nueva contraseña....");
                    nuevoPasswd= sc.next();
                    if (!passwd.equalsIgnoreCase(nuevoPasswd)) {
                     
                        cambioPasswdOK = new EmpleadoDAOImp().actualizarEmpleado(codigo, nuevoPasswd);
                        if (cambioPasswdOK) {
                            System.out.println("Se cambio la contraseña satisfactoriamente");
                        } else {
                            System.out.println("No se ha podido actualizar el archivo" );
                        }
                    } else {
                        System.out.println("Contraseña igual que la anterior");
                    }
                        
                  }
        }


