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
                    fila--;
                    if(sala.getAsientosLibresFila(fila)>tickets){
                        int Tickets[] = sala.setAsientos(fila, tickets);
                        System.out.println("Sus entradas son:");
                        for(int i=0;i<Tickets.length;i++){
                            System.out.println("Fila: " + (fila+1) + " Asiento: " + (Tickets[i]+1));
                        }
                        System.out.println("Importe de la entradas = ");
                        System.out.println();
                    }else{

                    }
                }
            }else {
                System.out.println("ENTRADAS AGOTADAS");
                System.exit(0);
            }
        }while(tickets!=0);
        System.out.println();
    }
}
