import java.util.Scanner;

public class Main {
    public static int pSalas=0;
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int SelSala=0, opcion=0;
        int[][] BUTACAS=null;
        Sala sala1 = new Sala(1, "Fast and Furius", 10, 10);
        Sala sala2 = new Sala(2, "Star Wars", 5, 5);
        Sala sala3 = new Sala(3, "Los Increibles", 7, 5);
        

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

    public static void limpiar(){
        for(int a=0;a<50;a++){
            System.out.println();
        }
    }
}
