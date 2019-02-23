import java.util.GregorianCalendar;
import java.util.Scanner;

public class Sala {
    //atributos
    private int sala;
    private String pelicula;
    private Butaca[][] butacas;

    //constructor
    public Sala(int sala,String pelicula, int filas, int butacas, int filaVip){
        this.sala=sala;
        this.pelicula = pelicula;
        this.butacas = new Butaca[filas][butacas];
        for(int i=0;i<this.butacas.length;i++){
            for(int x=0;x<this.butacas[i].length;x++){
                if(i==filaVip) {
                    this.butacas[i][x] = new Butaca(1);
                }else if(i==0&&(x==0||x==1)){
                    this.butacas[i][x] = new Butaca(2);
                }else{
                    this.butacas[i][x] = new Butaca(0);
                }
            }
        }
    }

    //metodos
    public void SelSala(){
        Scanner teclado = new Scanner(System.in);
        int opcion=0;
        int[][] BUTACAS=null;

        imprimirSala();
        System.out.println("\nOpciones:");
        System.out.println("    1 --> Ver otra sala");
        System.out.println("    2 --> Selecionar butacas");
        do {
            System.out.print("¿Que desea hacer (1-2)?: ");
            opcion = teclado.nextInt();
            if (opcion < 1 || opcion > 2) {
                System.out.println("Porfavor introducta un numero entre 1 y 2");
            }
        } while (opcion < 1 || opcion > 2);
        System.out.println();
        switch (opcion) {
            case 1:

                break;
            case 2:
                System.out.println("Opciones:");
                System.out.println("    1 --> Aleatorias");
                System.out.println("    2 --> Selecionar solo fila");
                System.out.println("    3 --> Selecionar butacas 1 a 1");
                do {
                    System.out.print("¿Que desea hacer (1-3)?: ");
                    opcion = teclado.nextInt();
                    if (opcion < 1 || opcion > 3) {
                        System.out.println("Porfavor introducta un numero entre 1 y 3");
                    }
                } while (opcion < 1 || opcion > 3);
                System.out.println();
                switch (opcion) {
                    case 1:

                        do {
                            System.out.print("Cuantas butacas desea: ");
                            opcion = teclado.nextInt();
                            if (opcion>getNumButacasLibre()) {
                                System.out.println("Error: No quedan tantas butacas libres, solo quedan(0 si no quiere ninguna): " + getNumButacasLibre());
                            }
                        } while (opcion>getNumButacasLibre());
                        limpiar();
                        BUTACAS = setButacasAleatorios(opcion);
                        for(int i=0;i<BUTACAS.length;i++){
                            ticket(sala,BUTACAS[i][0]+1,BUTACAS[i][1]+1,getPelicula(),"22:00", "09/03/2019", getTipoButaca(BUTACAS[i][0],BUTACAS[i][1]),getNumVentaButaca(BUTACAS[i][0],BUTACAS[i][1]),getFechaVenta(BUTACAS[i][0],BUTACAS[i][1]));
                            System.out.println();
                        }
                        System.out.println("Pulse cualquier telca para continuar");
                        teclado.nextLine();
                        teclado.nextLine();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }
                break;
        }
    }
    
    public void imprimirSala(){
        System.out.println("\nLa sala " + sala + " con la pelicula: " + pelicula);
        System.out.print("    ");
        for(int i=0;i<butacas[1].length;i++){
            System.out.print((i+1) + "  ");
        }
        System.out.println();
        for(int i=0;i<butacas.length;i++){
            if(i<=8){
                System.out.print("f0"+(i+1));
            }else{
                System.out.print("f"+(i+1));
            }
            System.out.print(" ");
            for(int x=0;x<butacas[i].length;x++){
                if(butacas[i][x].getEstado()==false){
                        if(butacas[i][x].getTipo()==0) {
                            System.out.print("0  ");
                        }else if(butacas[i][x].getTipo()==1) {
                            System.out.print("V  ");
                        }else{
                            System.out.print("M  ");
                        }
                    }else{
                    System.out.print("1  ");
                }
                if(x>8){
                    System.out.print(" ");
                }
            }
            if(i<=8){
                System.out.print("f0"+(i+1));
            }else{
                System.out.print("f"+(i+1));
            }
            System.out.println();
        }
        System.out.println("\n 0=Butaca normal   1=Butaca comprada   V=Butaca VIP   M=Butaca para minusvadilos");
    }

    public String getPelicula() {
        return pelicula;
    }

    public String getTipoButaca(int fila, int butaca){
        if(butacas[fila][butaca].getTipo()==0){
            return "NORMAL";
        }else if(butacas[fila][butaca].getTipo()==1){
            return "VIP";
        }else{
            return "MINUSV";
        }
    }

    public int getNumVentaButaca(int fila, int butaca){
        return butacas[fila][butaca].getNumVenta();
    }

    public GregorianCalendar getFechaVenta(int fila, int butaca){
        return butacas[fila][butaca].getFechaVenta();
    }

    public int getNumButacasLibre(){
        int libres=0;
        for(int i=0;i<butacas.length;i++){
            for(int x=0;x<butacas[i].length;x++){
                if(butacas[i][x].getEstado()==false){
                    libres++;
                }
            }
        }
        return libres;
    }

    public int[][] setButacasAleatorios(int numButacas) {
        int BUTACAS[][] = new int[numButacas][2];
        int numAltFila =0, numAltButaca=0;

        for(int i=0;i<numButacas;i++){
            for(int a=0;a<1;){
                numAltFila = (int) (Math.random() * butacas.length);
                numAltButaca = (int) (Math.random() * butacas[numAltFila].length);
                if(butacas[numAltFila][numAltButaca].getEstado()==false){
                    a=2;
                }
            }
            butacas[numAltFila][numAltButaca].setComprado();
            BUTACAS[i][0] = numAltFila;
            BUTACAS[i][1] = numAltButaca;
        }

        return BUTACAS;
    }

    //Otros
    private static void ticket(int sala, int fila, int but, String name, String sesion, String fecha, String tipo, int no, GregorianCalendar venta){
        String Sala ="",Fila="",But="",Name="",Tipo="",Precio="",No="",Venta="";
        if(sala<10){
            Sala = "0"+sala;
        }else {
            Sala = ""+sala;
        }
        if(fila<10){
            Fila = "0"+fila;
        }else {
            Fila = ""+fila;
        }
        if(but<10){
            But = "0"+but;
        }else {
            But = ""+but;
        }
        if(name.length()>22){
            for(int i=0;i<19;i++){
                Name=Name+name.charAt(i);
            }
            Name=Name+"...";
        }else if(name.length()<22){
            int check = 22-name.length();
            Name=name;
            for(int i=0;i<check;i++){
                Name=Name+" ";
            }
        }else{
            Name=name;
        }
        if(tipo=="VIP"){
            Tipo="VIP   ";
        }else{
            Tipo=tipo;
        }
        float precio = 0;
        if(tipo=="NORMAL"){
            precio = 6.00f;
        }else if(tipo=="VIP"){
            precio = 7.50f;
        }else {
            precio = 6.25f;
        }
        Precio = String.format("%.2f", precio) + "€";
        No=Integer.toString(no);
        if(No.length()<6){
            int check = 6-No.length();
            No="";
            for(int i=0;i<check;i++){
                No=No+"0";
            }
            No=No+no;
        }
        int ventadia=venta.get(venta.DAY_OF_MONTH),ventaMes=venta.get(venta.MONTH),ventaAño=venta.get(venta.YEAR),ventaHora=venta.get(venta.HOUR_OF_DAY),ventaMin=venta.get(venta.MINUTE);
        String Ventadia="",VentaMes="",VentaAño="",VentaHora="",VentaMin="";
        if(ventadia<10){
            Ventadia="0"+ventadia;
        }else{
            Ventadia=""+ventadia;
        }
        if(ventaMes<10){
            VentaMes="0"+ventaMes;
        }else{
            VentaMes=""+ventaMes;
        }
        if(ventaAño<10){
            VentaAño="0"+ventaAño;
        }else{
            VentaAño=""+ventaAño;
        }
        if(ventaHora<10){
            VentaHora="0"+ventaHora;
        }else{
            VentaHora=""+ventaHora;
        }
        if(ventaMin<10){
            VentaMin="0"+ventaMin;
        }else{
            VentaMin=""+ventaMin;
        }

        Venta=""+Ventadia+"/"+VentaMes+"/"+VentaAño+" "+VentaHora+":"+VentaMin;

        System.out.println("--------------------------------------------------------"                        +"     --------------------------------------------------------");
        System.out.println("|                |    Pelicula: " + Name + " |"                                  +"     |      Ocine Río Shopping         CIF: B55118053       |");
        System.out.println("|                |                                     |"                        +"     |                                                      |");
        System.out.println("|      OCINE     |     Sala     Sesison     Fecha      |"                        +"     |      Rio Shopping, Calle Me Falta un Tornillo, 3     |");
        System.out.println("|       RIO      |      " + Sala + "       " + sesion + "    " + fecha + "   |"  +"     |       47195 Arroyo de la Encomienda, Valladolid      |");
        System.out.println("|    SHOPPING    |                                     |"                        +"     |                                                      |");
        System.out.println("|                |       Fila: " + Fila + "      Butaca: " + But + "      |"     +"     |    N/O: " + No + "        Hora venta: " + Venta + "   |");
        System.out.println("|                |    Tipo: " + Tipo + "    Precio: " + Precio + "    |"         +"     |                                                      |");
        System.out.println("--------------------------------------------------------"                        +"     --------------------------------------------------------");
    }

    public static void limpiar(){
        for(int a=0;a<50;a++){
            System.out.println();
        }
    }
}
