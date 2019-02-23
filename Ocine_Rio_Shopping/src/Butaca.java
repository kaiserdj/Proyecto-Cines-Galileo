public class Butaca {
    //Atributos
    private boolean estado;
    private int numVenta;

    //contructor
    public Butaca(){
        this.estado=false;
        this.numVenta=0;
    }

    //metodos
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }
}
