import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Sala sala = new Sala();
        int tickets=99, fila=0;

        do {
            if(sala.getTotal()!=0) {
                System.out.println("Vista de ocupación de la sala");
                sala.imprimirSala();
                System.out.print("\n¿Cuantas entradas desea? (teclear 0 para volver al menú): ");
                tickets = teclado.nextInt();
                if (tickets != 0) {
                    do {
                        System.out.print("\n¿Fila (1-12)?: ");
                        fila = teclado.nextInt();
                        if (fila < 1 || fila > 12) {
                            System.out.println("Porfavor introducta un numero entre 1 y 12");
                        }
                    } while (fila < 1 || fila > 12);

                }
            }else {
                System.out.println("ESNTRADAS AGOTADAS");
                System.exit(0);
            }
        }while(tickets!=0);
    }
}
