
package empleado.persistencia;

import empleado.dominio.Empleado;
import java.util.List;

public interface EmpleadoDAO {
    
    List<Empleado> leerEmpleado();
    
    Empleado getEmpleadoporCodigo (int codigo);
    
    boolean actualizarEmpleado(List<Empleado> empleados);
}
