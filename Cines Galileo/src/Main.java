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
                    if(sala.getTotal()>tickets) {
                        do {
                            System.out.print("\n¿Fila (1-12)?: ");
                            fila = teclado.nextInt();
                            if (fila < 1 || fila > 12) {
                                System.out.println("Porfavor introducta un numero entre 1 y 12");
                            }
                        } while (fila < 1 || fila > 12);
                        fila--;
                        if (sala.getAsientosLibresFila(fila) > tickets) {
                            int Tickets[] = sala.setAsientos(fila, tickets);
                            System.out.println("Sus entradas son:");
                            for (int i = 0; i < Tickets.length; i++) {
                                System.out.println("Fila: " + (fila + 1) + " Asiento: " + (Tickets[i] + 1));
                            }
                            System.out.println("Importe de la entradas = ");
                            System.out.println();
                        } else {
                            int filas[] = sala.getFilasAsientetosLibres(tickets);
                            if (filas.length != 0) {
                                System.out.println("No hay " + tickets + " asientos contiguos libres en la fila " + fila);
                                System.out.println("Filas donde hay " + tickets + " asientos contiguos libres:");
                                for (int i = 0; i < filas.length; i++) {
                                    System.out.print("  " + filas[i]);
                                }
                                System.out.println();
                            } else {
                                System.out.println("No hay ninguna fila con " + tickets + " entradas contiguas libres");
                            }
                        }
                    }else{
                        System.out.println("Solo quedan " + sala.getTotal() + " entradas para esta sesión");
                        System.out.println();
                    }
                }
            }else {
                System.out.println("ENTRADAS AGOTADAS \n\n");
                tickets=0;
            }
        }while(tickets!=0);
        System.out.println("Recaudación = " + sala.getTotal() + "entradas vendidas x 5 Euros = 570 Euros");
    }
}
