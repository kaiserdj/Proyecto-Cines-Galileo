import java.util.GregorianCalendar;

public class Butaca {
    //Atributos
    private boolean estado;
    private int tipo;
    private int numVenta;
    private GregorianCalendar FechaVenta;

    //contructor
    public Butaca(int tipo){
        this.estado=false;
        this.tipo=tipo;
        this.numVenta=0;
        this.FechaVenta=null;
    }

    //metodos
    public boolean getEstado() {
        return estado;
    }

    public void setComprado() {
        GregorianCalendar ahora = new GregorianCalendar();
        estado = true;
        Main.ventas++;
        numVenta = Main.ventas;
        FechaVenta=ahora;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public int getTipo() {
        return tipo;
    }

    public GregorianCalendar getFechaVenta(){
        return FechaVenta;
    }
}
