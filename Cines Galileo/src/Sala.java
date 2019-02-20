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

    public int[] setAsientos(int fila, int num){
        int cont=0;
        int butacas[] = new int[num];
        for(int i=0;i<asientos[fila].length;i++){
            if(cont<num) {
                if (asientos[fila][i].getComprado() == false) {
                    asientos[fila][i].setComprado(true);
                    butacas[cont] = i;
                    cont++;
                    total--;
                }
            }
        }
        return butacas;
    }

    public int getAsientosLibresFila(int fila){
        int cont=0;
        for(int i=0;i<asientos[fila].length;i++){
            if(asientos[fila][i].getComprado()==false){cont++;}
        }
        return cont;
    }

    public int[] getFilasAsientetosLibres(int Asientos){
        int a[] = new int[12];
        int cont = 0;
        for(int i=0;i<asientos.length;i++){
            if(getAsientosLibresFila(i)>=Asientos){
                a[cont]=i;
                cont++;
            }
        }
        int filas[] = new int[cont];
        for(int i=0;i<cont;i++){
            filas[i]=a[i];
        }
        return filas;
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
