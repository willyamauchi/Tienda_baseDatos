

package Excepciones;

public class NombreArchivoIncorrectoExeption extends RuntimeException{
    
    private int codigoError;
    
    public NombreArchivoIncorrectoExeption(String msj) {
        super(msj);
    }

    public NombreArchivoIncorrectoExeption(String msj, Throwable causa) {
        super(msj, causa);
    }

    public NombreArchivoIncorrectoExeption( CodigoError_Enum codigoError) {
        super(String.valueOf( codigoError));
        this.codigoError = codigoError.getCodigoError();
    }

    public int getCodigoError() {
        return codigoError;
    }
    
   
   

}
