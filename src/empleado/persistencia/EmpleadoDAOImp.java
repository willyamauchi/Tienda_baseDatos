package empleado.persistencia;

import conexion.ConexionBD;
import empleado.dominio.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpleadoDAOImp implements EmpleadoDAO {

   
    public EmpleadoDAOImp() {
        
    }

    @Override
    public List<Empleado> leerEmpleado() {
        List<Empleado> empleados = new ArrayList<>();
        
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;
        try {
            conexion = ConexionBD.conectar();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM empleado");

            while (resultado.next()) {
                int codigo = resultado.getInt("e_codigo");
                String nombre = resultado.getString("e_nombre");
                String apellido = resultado.getString("a_apellidos");
                String password = resultado.getString("e_password");

                empleados.add(new Empleado(codigo, nombre, apellido, password));
            }

            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al leer los productos...." + this.getClass().getName());
            System.out.println(e.getMessage());
        }
        return empleados;

    }

    @Override
    public Empleado getEmpleadoporCodigo(int codigo) {
       Empleado empleado= null;
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;
        try {
            conexion = ConexionBD.conectar();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM empleado WHERE e_codigo = "+codigo);

                resultado.next();
                int codig = resultado.getInt("e_codigo");
                String nombre = resultado.getString("e_nombre");
                String apellido = resultado.getString("a_apellidos");
                String password = resultado.getString("e_password");

               
               empleado = new Empleado(codigo,nombre,apellido,password);

            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al leer los productos....");
            System.out.println(e.getMessage());
        }
        return empleado;
//To change body of generated methods, choose Tools | Templates.
    }


    public boolean actualizarEmpleado(int codigo, String password) {
        String query = "UPDATE  empleados SET e_password = " + codigo + " WHERE  = " + password;
        try ( Connection conexion = ConexionBD.conectar();  Statement setencia = conexion.createStatement()) {
            return setencia.executeUpdate(query) == 1;
        } catch (SQLException e) {
            return false;
        }

    
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
                        cambioPasswdOK = actualizarEmpleado(codigo,passwd);
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
