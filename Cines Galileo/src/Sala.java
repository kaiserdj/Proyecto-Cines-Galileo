public class Sala {
    //Atributos
    private Asiento[][] asientos;
    private int total;

    public Sala() {
        asientos = new Asiento[12][10];
        for(int i=0;i<asientos.length;i++){
            for(int x=0;x<asientos[i].length;x++){
                asientos[i][x]=new Asiento();
            }
        }
        total = 120;
    }

    public Asiento getAsiento(int fila, int butaca){
        return asientos[fila][butaca];
    }

    public int getTotal(){return total;}

    public int getAsientosLibresFila(int fila){
        int cont=0;
        for(int i=0;i<asientos[fila].length;i++){
            if(asientos[fila][i].getComprado()==false){cont++;}
        }
        return cont;
    }

    public void imprimirSala(){
        System.out.println("    1  2  3  4  5  6  7  8  9  10");
        for(int i=0;i<12;i++){
            System.out.print("f");
            if(i>=0&&i<9){
                System.out.print("0" + (i+1));
            }else{
                System.out.print(i+1);
            }
            for(int x=0;x<10;x++){
                System.out.print("  ");
                if(getAsiento(i,x).getComprado()==false){
                    System.out.print(0);
                }else {
                    System.out.print(1);
                }
            }
            System.out.print("   f");
            if(i>=0&&i<9){
                System.out.print("0" + (i+1));
            }else{
                System.out.print(i+1);
            }
            System.out.println();
        }
    }
}
