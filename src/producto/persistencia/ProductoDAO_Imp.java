package producto.persistencia;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import producto.dominio.Producto;

public class ProductoDAO_Imp implements ProductoDAO {

    @Override
    public List<Producto> leerproducto() {
        List<Producto> productos = new ArrayList<>();
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;
        try {
            conexion = ConexionBD.conectar();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM producto");

            while (resultado.next()) {
                int codigo = resultado.getInt("p_codigo");
                String nombre = resultado.getString("p_nombre");
                String descripcion = resultado.getString("p_descripsion");
                double precio = resultado.getDouble("p_precio");

                productos.add(new Producto(codigo, nombre, descripcion, precio));
            }

            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al leer los productos...." + this.getClass().getName());
            System.out.println(e.getMessage());
        }
        return productos;

    }

    @Override
    public boolean actualizarProducto(int codigo , String nombre) {
        String query = "UPDATE  productos SET p_nombre = " + nombre + " WHERE  p_codigo= " + codigo;
        try ( Connection conexion = ConexionBD.conectar();  Statement sentencia = conexion.createStatement()) {
            return sentencia.executeUpdate(query) == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean actualizarPrecio(int codigo, double precio) {
        String query = "UPDATE  productos SET p_precio = " + precio + " WHERE  p_codigo= " + codigo;
        try ( Connection conexion = ConexionBD.conectar();  Statement sentencia = conexion.createStatement()) {
            return sentencia.executeUpdate(query) == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean actualizarCodigo(int codigo, int nuevoCodigo) {
        String query = "UPDATE  productos SET p_codigo = " + nuevoCodigo + " WHERE  p_codigo= " + codigo;
        try ( Connection conexion = ConexionBD.conectar();  Statement sentencia = conexion.createStatement()) {
            return sentencia.executeUpdate(query) == 1;
        } catch (SQLException e) {
            return false;
        }
    }

}
