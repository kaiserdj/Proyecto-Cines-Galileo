import java.util.GregorianCalendar;
import java.util.Scanner;

public class Sala {
    //atributos
    private int sala;
    private String pelicula;
    private Butaca[][][][] butacas;

    //constructor
    public Sala(int sala,String pelicula, int filas, int butacas, int filaVip){
        this.sala=sala;
        this.pelicula = pelicula;
        this.butacas = new Butaca[5][5][filas][butacas];
        for(int z=0;z<this.butacas.length;z++){
            for(int y=0;y<this.butacas[z].length;y++) {
                for (int i = 0; i < this.butacas[z][y].length; i++) {
                    for (int x = 0; x < this.butacas[z][y][i].length; x++) {
                        if (i == filaVip) {
                            this.butacas[z][y][i][x] = new Butaca(1);
                        } else if (i == 0 && (x == 0 || x == 1)) {
                            this.butacas[z][y][i][x] = new Butaca(2);
                        } else {
                            this.butacas[z][y][i][x] = new Butaca(0);
                        }
                    }
                }
            }
        }
    }

    //metodos
    public void empleado(){
        Scanner teclado = new Scanner(System.in);
        int dia=0, sesion=0, fila=0, butaca=0, opcion=0;
        int[][] BUTACAS=null;
        int[] BUTACA=null;
        GregorianCalendar hoy = new GregorianCalendar();

        System.out.println("\nDias disponibles:");
        System.out.println("    1 --> "+ (hoy.get(hoy.DAY_OF_MONTH)+1)+"/"+(hoy.get(hoy.MONTH)+1)+"/"+hoy.get(hoy.YEAR));
        System.out.println("    2 --> "+ (hoy.get(hoy.DAY_OF_MONTH)+2)+"/"+(hoy.get(hoy.MONTH)+1)+"/"+hoy.get(hoy.YEAR));
        System.out.println("    3 --> "+ (hoy.get(hoy.DAY_OF_MONTH)+3)+"/"+(hoy.get(hoy.MONTH)+1)+"/"+hoy.get(hoy.YEAR));
        System.out.println("    4 --> "+ (hoy.get(hoy.DAY_OF_MONTH)+4)+"/"+(hoy.get(hoy.MONTH)+1)+"/"+hoy.get(hoy.YEAR));
        System.out.println("    5 --> "+ (hoy.get(hoy.DAY_OF_MONTH)+5)+"/"+(hoy.get(hoy.MONTH)+1)+"/"+hoy.get(hoy.YEAR));
        do {
            System.out.print("¿Que dia desea (1-5)?: ");
            dia = teclado.nextInt();
            if (dia < 1 || dia > 5) {
                System.out.println("Porfavor introducta un numero entre 1 y 5");
            }
        } while (dia < 1 || dia > 5);
        dia=dia-1;

        System.out.println("\nSesiones disponibles:");
        System.out.println("    1 --> 12:00");
        System.out.println("    2 --> 14:00");
        System.out.println("    3 --> 16:00");
        System.out.println("    4 --> 18:00");
        System.out.println("    5 --> 20:00");
        do {
            System.out.print("¿Que sesion desea (1-5)?: ");
            sesion = teclado.nextInt();
            if (sesion < 1 || sesion > 5) {
                System.out.println("Porfavor introducta un numero entre 1 y 5");
            }
        } while (sesion < 1 || sesion > 5);
        sesion=sesion-1;

        imprimirSala(dia,sesion);
        System.out.println("\nOpciones:");
        System.out.println("    1 --> Selecionar butacas");
        System.out.println("    2 --> Ver otra sala");
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
                            if (opcion>getNumButacasLibre(dia,sesion)) {
                                System.out.println("Error: No quedan tantas butacas libres, solo quedan(0 si no quiere ninguna): " + getNumButacasLibre(dia,sesion));
                            }
                        } while (opcion>getNumButacasLibre(dia,sesion));
                        limpiar();
                        BUTACAS = setButacasAleatorios(dia,sesion,opcion);
                        for(int i=0;i<BUTACAS.length;i++){
                            ticket(sala,BUTACAS[i][0]+1,BUTACAS[i][1]+1,getPelicula(),"22:00", "09/03/2019", getTipoButaca(dia,sesion,BUTACAS[i][0],BUTACAS[i][1]),getNumVentaButaca(dia,sesion,BUTACAS[i][0],BUTACAS[i][1]),getFechaVenta(dia,sesion,BUTACAS[i][0],BUTACAS[i][1]));
                            System.out.println();
                        }
                        System.out.println("Puse enter para continuar");
                        teclado.nextLine();
                        teclado.nextLine();
                        break;
                    case 2:
                        do {
                            do {
                                System.out.print("Que fila desea(1-"+butacas[dia][sesion].length+"): ");
                                fila = teclado.nextInt();
                                if (fila<1||fila>butacas.length) {
                                    System.out.println("Error: esa fila no existe, porfavor introducta un numero entre 1 y "+butacas[dia][sesion].length);
                                }
                            } while (fila<1||fila>butacas[dia][sesion].length);
                            System.out.println("La fila " + fila + ", dispone de " + getNumButacasLibresFila(dia,sesion,fila));
                            System.out.print("¿Cuntas entradas desea(0 para cambiar de fila)?: ");
                            butaca = teclado.nextInt();
                            if (butaca<0||butaca>getNumButacasLibresFila(dia,sesion,fila)) {
                                System.out.println("Error: porfavor introduzca un numero entre 0 y " + getNumButacasLibresFila(dia,sesion,fila));
                            }
                            if(butaca==0){
                                fila=0;
                            }
                        }while (butaca<1||butaca>getNumButacasLibresFila(dia,sesion,fila));
                        limpiar();
                        BUTACA = setButacasFila(dia,sesion,fila,butaca);
                        for(int i=0;i<BUTACA.length;i++){
                            ticket(sala,fila,BUTACA[i]+1,getPelicula(),"22:00", "09/03/2019", getTipoButaca(dia,sesion,fila,BUTACA[i]),getNumVentaButaca(dia,sesion,fila,BUTACA[i]),getFechaVenta(dia,sesion,fila,BUTACA[i]));
                            System.out.println();
                        }
                        System.out.println("Puse enter para continuar");
                        teclado.nextLine();
                        teclado.nextLine();
                        break;
                    case 3:

                        do {
                            System.out.print("Cuantas butacas desea: ");
                            opcion = teclado.nextInt();
                            if (opcion>getNumButacasLibre(dia,sesion)) {
                                System.out.println("Error: No quedan tantas butacas libres, solo quedan(0 si no quiere ninguna): " + getNumButacasLibre(dia,sesion));
                            }
                        } while (opcion>getNumButacasLibre(dia,sesion));
                        BUTACAS = new int[opcion][2];
                        int conttick=0;
                        do {
                            do {
                                limpiar();
                                imprimirSala(dia,sesion);
                                System.out.print("Que fila desea(1-"+butacas[dia][sesion].length+"): ");
                                fila = teclado.nextInt();
                                if (fila<1||fila>butacas.length) {
                                    System.out.println("Error: esa fila no existe, porfavor introducta un numero entre 1 y "+butacas[dia][sesion].length);
                                }
                            } while (fila<1||fila>butacas[dia][sesion].length);
                            if(getNumButacasLibresFila(dia,sesion,fila)!=0) {
                                System.out.print("¿Que butaca desea (0 para cambiar de fila)?: ");
                                butaca = teclado.nextInt();
                                fila--;
                                butaca--;
                                if (butacas[dia][sesion][fila][butaca].getEstado()==false){
                                    butacas[dia][sesion][fila][butaca].setComprado();
                                    BUTACAS[conttick][0] = fila;
                                    BUTACAS[conttick][1] = butaca;
                                    conttick++;
                                }else{
                                    System.out.println("Esa butaca esta ocupada.");
                                    System.out.println("Puse enter para continuar");
                                    teclado.nextLine();
                                    teclado.nextLine();
                                }
                            }else{
                                System.out.println("La fila " + fila + ", no dispone de butacas");
                            }
                        }while (conttick<opcion);
                        for(int i=0;i<BUTACAS.length;i++){
                            ticket(sala,BUTACAS[i][0]+1,BUTACAS[i][1]+1,getPelicula(),"22:00", "09/03/2019", getTipoButaca(dia,sesion,BUTACAS[i][0],BUTACAS[i][1]),getNumVentaButaca(dia,sesion,BUTACAS[i][0],BUTACAS[i][1]),getFechaVenta(dia,sesion,BUTACAS[i][0],BUTACAS[i][1]));
                            System.out.println();
                        }
                        System.out.println("Puse enter para continuar");
                        teclado.nextLine();
                        teclado.nextLine();
                        break;
                }
                break;
            case 2:

                break;
        }
    }

    public void Admin(){
        Scanner teclado = new Scanner(System.in);
        int dia=0, sesion=0, fila=0, butaca=0, opcion=0;
        int[][] BUTACAS=null;
        int[] BUTACA=null;
        GregorianCalendar hoy = new GregorianCalendar();

        System.out.println("\nDias disponibles:");
        System.out.println("    1 --> "+ (hoy.get(hoy.DAY_OF_MONTH)+1)+"/"+(hoy.get(hoy.MONTH)+1)+"/"+hoy.get(hoy.YEAR));
        System.out.println("    2 --> "+ (hoy.get(hoy.DAY_OF_MONTH)+2)+"/"+(hoy.get(hoy.MONTH)+1)+"/"+hoy.get(hoy.YEAR));
        System.out.println("    3 --> "+ (hoy.get(hoy.DAY_OF_MONTH)+3)+"/"+(hoy.get(hoy.MONTH)+1)+"/"+hoy.get(hoy.YEAR));
        System.out.println("    4 --> "+ (hoy.get(hoy.DAY_OF_MONTH)+4)+"/"+(hoy.get(hoy.MONTH)+1)+"/"+hoy.get(hoy.YEAR));
        System.out.println("    5 --> "+ (hoy.get(hoy.DAY_OF_MONTH)+5)+"/"+(hoy.get(hoy.MONTH)+1)+"/"+hoy.get(hoy.YEAR));
        do {
            System.out.print("¿Que dia desea (1-5)?: ");
            dia = teclado.nextInt();
            if (dia < 1 || dia > 5) {
                System.out.println("Porfavor introducta un numero entre 1 y 5");
            }
        } while (dia < 1 || dia > 5);
        dia=dia-1;

        System.out.println("\nSesiones disponibles:");
        System.out.println("    1 --> 12:00");
        System.out.println("    2 --> 14:00");
        System.out.println("    3 --> 16:00");
        System.out.println("    4 --> 18:00");
        System.out.println("    5 --> 20:00");
        do {
            System.out.print("¿Que sesion desea (1-5)?: ");
            sesion = teclado.nextInt();
            if (sesion < 1 || sesion > 5) {
                System.out.println("Porfavor introducta un numero entre 1 y 5");
            }
        } while (sesion < 1 || sesion > 5);
        sesion=sesion-1;

        imprimirSala(dia,sesion);
        System.out.println("\nOpciones:");
        System.out.println("    1 --> Cancelar compra ticket");
        System.out.println("    2 --> Cancelar toda la sesion");
        System.out.println("    3 --> Salir");
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
                if(getNumButacasLibre(dia,sesion)!=(butacas[dia][sesion].length*butacas[dia][sesion][0].length)){
                    imprimirSala(dia, sesion);
                    System.out.println("Que butaca desea cancelar");
                    do {
                        System.out.print("Introduzca la fila: ");
                        fila = teclado.nextInt();
                        if (fila<1||fila>butacas[dia][sesion].length) {
                            System.out.println("Error: Esta fila no exite, porfavor introduzca un numero del 1 al " + butacas[dia][sesion].length);
                        }
                    } while (fila<1||fila>butacas[dia][sesion].length);
                    fila--;
                    do{
                        System.out.print("Introduzca la butaca: ");
                        butaca = teclado.nextInt();
                        if (butaca<1||butaca>butacas[dia][sesion][fila].length) {
                            System.out.println("Error: Esta butaca no exite, porfavor introduzca un numero del 1 al " + butacas[dia][sesion][fila].length);
                        }else if(butacas[dia][sesion][fila][(butaca-1)].getEstado()==false){
                            System.out.println("Esta butaca esta vacia");
                        }
                    } while ((butaca<1||butaca>butacas[dia][sesion][fila].length)||butacas[dia][sesion][fila][(butaca-1)].getEstado()==false);
                    butaca--;
                    butacas[dia][sesion][fila][butaca].setCancelarcompra();
                    System.out.println("La butaca " + (butaca+1) + ", de la fila " + (fila+1) + ", a sido cancelada.");
                    System.out.println("Puse enter para continuar");
                    teclado.nextLine();
                    teclado.nextLine();
                }else{
                    System.out.println("Esta sesión, esta vacia.");
                    System.out.println("Puse enter para continuar");
                    teclado.nextLine();
                    teclado.nextLine();
                }
                break;
            case 2:
                do {
                    System.out.print("¿Esta seguro de cancelar toda una sesion?(1-Si 2-No): ");
                    opcion = teclado.nextInt();
                    if (opcion < 1 || opcion > 2) {
                        System.out.println("Error: Introduzca 1 si es si o 2 si es no");
                    }
                } while (opcion < 1 || opcion > 2);
                switch (opcion){
                    case 1:
                        for (int i = 0; i < this.butacas[dia][sesion].length; i++) {
                            for (int x = 0; x < this.butacas[dia][sesion][i].length; x++) {
                                butacas[dia][sesion][i][x].setCancelarcompra();
                            }
                        }
                        System.out.println("Todas las butacas han sido canceladas.");
                        System.out.println("Puse enter para continuar");
                        teclado.nextLine();
                        teclado.nextLine();
                        break;
                    case 2:
                        System.out.println("Operación cancelada");
                        System.out.println("Puse enter para continuar");
                        teclado.nextLine();
                        teclado.nextLine();
                        break;
                }
                break;
            case 3:

                break;
        }
    }
    
    public void imprimirSala(int dia, int sesion){

        System.out.println("\nLa sala " + sala + " con la pelicula: " + pelicula);
        System.out.print("    ");
        for(int i=0;i<butacas[dia][sesion][1].length;i++){
            System.out.print((i+1) + "  ");
        }
        System.out.println();
        for(int i=0;i<butacas[dia][sesion].length;i++){
            if(i<=8){
                System.out.print("f0"+(i+1));
            }else{
                System.out.print("f"+(i+1));
            }
            System.out.print(" ");
            for(int x=0;x<butacas[dia][sesion][i].length;x++){
                if(butacas[dia][sesion][i][x].getEstado()==false){
                        if(butacas[dia][sesion][i][x].getTipo()==0) {
                            System.out.print("0  ");
                        }else if(butacas[dia][sesion][i][x].getTipo()==1) {
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

    public String getTipoButaca(int dia, int sesion, int fila, int butaca){
        if(butacas[dia][sesion][fila][butaca].getTipo()==0){
            return "NORMAL";
        }else if(butacas[dia][sesion][fila][butaca].getTipo()==1){
            return "VIP";
        }else{
            return "MINUSV";
        }
    }

    public int getNumVentaButaca(int dia, int sesion, int fila, int butaca){
        return butacas[dia][sesion][fila][butaca].getNumVenta();
    }

    public GregorianCalendar getFechaVenta(int dia, int sesion, int fila, int butaca){
        return butacas[dia][sesion][fila][butaca].getFechaVenta();
    }

    public int getNumButacasLibresFila(int dia, int sesion, int fila){
        int libres=0;
        for(int i=0;i<butacas[dia][sesion][fila].length;i++){
            if(butacas[dia][sesion][fila][i].getEstado()==false){
                libres++;
            }
        }
        return libres;
    }

    public int getNumButacasLibre(int dia, int sesion){
        int libres=0;
        for(int i=0;i<butacas[dia][sesion].length;i++){
            for(int x=0;x<butacas[dia][sesion][i].length;x++){
                if(butacas[dia][sesion][i][x].getEstado()==false){
                    libres++;
                }
            }
        }
        return libres;
    }

    public int[][] setButacasAleatorios(int dia, int sesion, int numButacas) {
        int BUTACAS[][] = new int[numButacas][2];
        int numAltFila =0, numAltButaca=0;

        for(int i=0;i<numButacas;i++){
            for(int a=0;a<1;){
                numAltFila = (int) (Math.random() * butacas[dia][sesion].length);
                numAltButaca = (int) (Math.random() * butacas[dia][sesion][numAltFila].length);
                if(butacas[dia][sesion][numAltFila][numAltButaca].getEstado()==false){
                    a=2;
                }
            }
            butacas[dia][sesion][numAltFila][numAltButaca].setComprado();
            BUTACAS[i][0] = numAltFila;
            BUTACAS[i][1] = numAltButaca;
        }

        return BUTACAS;
    }

    public int[] setButacasFila(int dia, int sesion, int fila, int numButacas){
        int BUTACAS[] = new int[numButacas];
        int butacasCom=0;

        for(int i=0;i<butacas[dia][sesion][fila].length;i++){
            if(butacasCom<numButacas) {
                if (butacas[dia][sesion][fila][i].getEstado() == false) {
                    butacas[dia][sesion][fila][i].setComprado();
                    BUTACAS[butacasCom] = i;
                    butacasCom++;
                }
            }else{
                return BUTACAS;
            }
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
