
package Excepciones;


public enum CodigoError_Enum {
    ERROR_USUARIO_NO_ENCONTRADO(111),
    ERROR_PASSWORD_ERRADO(222);
    
     private int codigo;

    private CodigoError_Enum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoError() {
        return codigo;
    }
    
     
    
}
