package empleado.persistencia;

import empleado.dominio.Empleado;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EmpleadoDAOImp implements EmpleadoDAO {

   
    public EmpleadoDAOImp() {
        
    }

    @Override
    public List<Empleado> leerEmpleado() {
        List<Empleado> empleados = new ArrayList<>();
        NumberFormat formatoNumero = NumberFormat.getInstance(Locale.FRENCH);
        Number numero;
        String LineaConDatos;
        String archivosProductos = "empleados.txt";
        System.out.println();
        try ( BufferedReader archivo = Files.newBufferedReader(Paths.get(archivosProductos))) {
            while (archivo.readLine() != null) {
                //codigo
                archivo.readLine();
                LineaConDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(LineaConDatos);
                int codigo = numero.intValue();
                //nombre
                archivo.readLine();
                LineaConDatos = archivo.readLine().trim();
                String nombre = LineaConDatos;
                //descrip
                archivo.readLine();
                LineaConDatos = archivo.readLine().trim();
                String apellido = LineaConDatos;
                //precio
                archivo.readLine();
                LineaConDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(LineaConDatos);
                String passwd = LineaConDatos;

                empleados.add(new Empleado(codigo, nombre, apellido, passwd));

            }
        } catch (ParseException e) {
            System.out.println("Error de formato de numero");

        } catch (IOException e) {
            System.out.println("Error de formato de Archivo");
        }

        return empleados;
    }

    @Override
    public Empleado getEmpleadoporCodigo(int codigo) {
       List<Empleado> empleado = leerEmpleado();
        for (Empleado empleado1 : empleado) {
            if (codigo==empleado1.getCodigo()) {
                return empleado1;
            }
        }
        return null;
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarEmpleado(List<Empleado> empleados) {
        boolean empleadoOk;
        String nombreFile = "empleados.txt";
        try ( var fw = Files.newBufferedWriter(Paths.get(nombreFile))) {
            for (Empleado empleado2 : empleados) {
                var codigo1 = empleado2.getCodigo();
                var nombre = empleado2.getNombre();
                var apellido = empleado2.getApellido();
                var passwod = empleado2.getPassword();
                fw.write("[empleado] ");
                fw.newLine();
                fw.write("   [codigo]");
                fw.newLine();
                fw.write("   " + codigo1);
                fw.newLine();
                fw.write("   [nombre]");
                fw.newLine();
                fw.write("   " + nombre);
                fw.newLine();
                fw.write("   [apellidos]");
                fw.newLine();
                fw.write("   " + apellido);
                fw.newLine();
                fw.write("   [contraseña]");
                fw.newLine();
                fw.write("   " + passwod);
                fw.newLine();
            }
            empleadoOk = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            empleadoOk = false;
        }
        return empleadoOk;
    }

    public void cambiarPasswordEmpleado(List<Empleado> empleados) {
        System.out.println(empleados);
        Scanner sc = new Scanner(System.in);
        int codigo, indice = 0;
        String nombreFile = "empleados.txt";
        boolean cambioPasswdOK;
        System.out.println(" ingrese el usuario a modificar su contraseña ");
        codigo = sc.nextInt();

        if (codigo > 0) {
            for (Empleado empleado1 : empleados) {
                if (codigo == empleado1.getCodigo()) {
                    System.out.println("Introdusca la nueva contraseña....");
                    String passwd = sc.next();
                    if (!passwd.equalsIgnoreCase(empleado1.getPassword())) {
                        empleado1.setPassword(passwd);
                        System.out.println(empleados);
                        cambioPasswdOK = actualizarEmpleado(empleados);
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
