import java.util.Scanner;

public class Main {
    public static int pSalas=0;
    public static int ventas=0;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int SelSala=0;
        Sala sala1 = new Sala(1, "Fast and Furius", 10, 10, 5);
        Sala sala2 = new Sala(2, "Star Wars", 5, 5, 3);
        Sala sala3 = new Sala(3, "Los Increibles", 7, 5, 3);

        String text = "--------------------------------------------------------------" +
                    "\n|                         Bienvenido                          |" +
                    "\n|                             al                              |" +
                    "\n|                  tpv de Ocine rio Shoping                   |" +
                    "\n---------------------------------------------------------------";
        for(int i=0;i<text.length();i++){
            System.out.print(text.charAt(i));
            pausa(20);
        }
        limpiar();

        for(;pSalas<1;) {
            limpiar();
            System.out.println("Lista de salas disponibles");
            System.out.println("    1 --> Sala 1: " + sala1.getPelicula());
            System.out.println("    2 --> Sala 2: " + sala2.getPelicula());
            System.out.println("    3 --> Sala 3: " + sala3.getPelicula());
            do {
                System.out.print("¿Que sala desea ver (1-3)(0 para salir?: ");
                SelSala = teclado.nextInt();
                if (SelSala < 0 || SelSala > 3) {
                    System.out.println("Porfavor introducta un numero entre 1 y 3");
                }
            } while (SelSala < 0 || SelSala > 3);
            limpiar();
            switch (SelSala) {
                case  0:
                    pSalas=2;
                    break;
                case 1:
                    sala1.SelSala();
                    break;
                case 2:
                    sala2.SelSala();
                    break;
                case 3:
                    sala3.SelSala();
                    break;
            }
        }
    }

    public static String encriptar(String text){
        char[] cod = new char[text.length()];
        for(int i=0;i<text.length();i++){
            cod[i]=text.charAt(i);
        }

        for(int i=0;i<cod.length;i++){
            int a = cod[i];
            a=a+5;
            cod[i]=(char) a;
        }
        String encipt ="";
        for(int i=0;i<cod.length;i++){
            encipt=encipt+cod[i];
        }
        return encipt;
    }

    public static String desencriptar(String text){
        char[] cod = new char[text.length()];
        for(int i=0;i<text.length();i++){
            cod[i]=text.charAt(i);
        }

        for(int i=0;i<cod.length;i++){
            int a = cod[i];
            a=a-5;
            cod[i]=(char) a;
        }
        String encipt ="";
        for(int i=0;i<cod.length;i++){
            encipt=encipt+cod[i];
        }
        return encipt;
    }

    public static void pausa(int mill){
        try {
            Thread.sleep(mill);
        } catch(InterruptedException ex){

            System.exit(0);
        }
    }

    public static void limpiar(){
        for(int a=0;a<50;a++){
            System.out.println();
        }
    }
}
