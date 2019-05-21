package empleado.dominio;

public class Empleado {

    private int codigo;
    private String nombre;
    private String Apellido;
    private String password;

    public Empleado(int codigo, String nombre, String Apellido, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.password = password;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s", getCodigo(), getNombre(), getApellido(), getPassword());
    }

}
