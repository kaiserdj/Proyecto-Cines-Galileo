import java.util.Scanner;

public class Main {
    public static int pSalas=0;
    public static int ventas=0;

    public static void main(String[] args) {
        String empleado = "lfqnqjt"; //galileo
        String admin = "firnsnxywfitw"; //administrador
        String estadistica = "xyfyx"; //stats
        String usuario = "", contraseña = "#", contraseña2 = "##";
        Scanner teclado = new Scanner(System.in);
        int opcion=0, user=0, SelSala=0;
        Sala sala1 = new Sala(1, "Fast and Furius", 10, 10, 5);
        Sala sala2 = new Sala(2, "Star Wars", 5, 5, 3);
        Sala sala3 = new Sala(3, "Los Increibles", 7, 5, 3);

        String text = "---------------------------------------------------------------" +
                    "\n|                         Bienvenido                          |" +
                    "\n|                             al                              |" +
                    "\n|                  tpv de Ocine rio Shoping                   |" +
                    "\n---------------------------------------------------------------";
        for(int i=0;i<text.length();i++){
            System.out.print(text.charAt(i));
            pausa(20);
        }
        limpiar();

        for (int programa=0;programa<1;) {
            usuario = ""; contraseña = "#"; opcion=0; user=0; pSalas=0;
            for (int x=0;x<1;) {
                System.out.println("Opciones:");
                System.out.println("    1 --> Inicio de sesión");
                System.out.println("    2 --> Cambiar contraseña usuario");
                System.out.println("    3 --> Cerrar programa");
                do {
                    System.out.print("¿Que desea hacer (1-3)?: ");
                    opcion = teclado.nextInt();
                    if (opcion < 1 || opcion > 3) {
                        System.out.println("Porfavor introducta un numero entre 1 y 3");
                    }
                } while (opcion < 1 || opcion > 3);

                switch (opcion) {
                    case 1:
                        for (int i = 0; i < 1; ) {
                            do {
                                System.out.print("Usuario: ");
                                usuario = teclado.nextLine();
                                if (usuario.equals("empleado")) {
                                    user = 1;
                                } else if (usuario.equals("admin")) {
                                    user = 2;
                                } else if (usuario.equals("estadistica")) {
                                    user = 3;
                                } else {
                                    System.out.println("Este usuario no existe");
                                    limpiar();
                                }
                            } while (user == 0);
                            do {
                                System.out.print("Contraseña(0 para cambiar de usuario): ");
                                contraseña = teclado.nextLine();
                                switch (user) {
                                    case 0:
                                        break;
                                    case 1:
                                        if (encriptar(contraseña).equals(empleado)) {
                                            i = 2;
                                            x = 2;
                                        } else {
                                            contraseña = "#";
                                        }
                                        break;
                                    case 2:
                                        if (encriptar(contraseña).equals(admin)) {
                                            i = 2;
                                            x = 2;
                                        } else {
                                            contraseña = "#";
                                        }
                                        break;
                                    case 3:
                                        if (encriptar(contraseña).equals(estadistica)) {
                                            i = 2;
                                            x = 2;
                                        } else {
                                            contraseña = "#";
                                        }
                                        break;
                                }

                            } while (contraseña == "#");
                        }
                        break;
                    case 2:
                        for (int i = 0; i < 1; ) {
                            do {
                                System.out.print("Usuario: ");
                                usuario = teclado.nextLine();
                                if (usuario.equals("empleado")) {
                                    user = 1;
                                } else if (usuario.equals("admin")) {
                                    user = 2;
                                } else if (usuario.equals("estadistica")) {
                                    user = 3;
                                } else {
                                    System.out.println("Este usuario no existe");
                                    limpiar();
                                }
                            } while (user == 0);
                            do {
                                System.out.print("Contraseña(0 para cambiar de usuario): ");
                                contraseña = teclado.nextLine();
                                switch (user) {
                                    case 0:
                                        break;
                                    case 1:
                                        if (encriptar(contraseña).equals(empleado)) {
                                            i = 2;
                                            do {
                                                System.out.print("Escriba la nueva contraseña: ");
                                                contraseña = teclado.nextLine();
                                                System.out.print("Escriba de nuevo la nueva contraseña: ");
                                                contraseña2 = teclado.nextLine();
                                                if (!(contraseña.equals(contraseña2))) {
                                                    System.out.println("A introducido dos contraseñas distintas, porfavor vuelva a introducirlas.");
                                                }
                                            } while (!(contraseña.equals(contraseña2)));
                                            empleado = encriptar(contraseña);
                                            System.out.println("La nueva contraseña de empleado es: " + contraseña);
                                            System.out.println("Si desea que el cambio de contraseña sea permanente, cambie en el codigo la variable empleado y ponga como valor: " + encriptar(contraseña));
                                            System.out.println("Puse enter para continuar");
                                            teclado.nextLine();
                                            teclado.nextLine();
                                            limpiar();
                                        } else {
                                            contraseña = "#";
                                        }
                                        break;
                                    case 2:
                                        if (encriptar(contraseña).equals(admin)) {
                                            i = 2;
                                            do {
                                                System.out.print("Escriba la nueva contraseña: ");
                                                contraseña = teclado.nextLine();
                                                System.out.print("Escriba de nuevo la nueva contraseña: ");
                                                contraseña2 = teclado.nextLine();
                                                if (!(contraseña.equals(contraseña2))) {
                                                    System.out.println("A introducido dos contraseñas distintas, porfavor vuelva a introducirlas.");
                                                }
                                            } while (!(contraseña.equals(contraseña2)));
                                            admin = encriptar(contraseña);
                                            System.out.println("La nueva contraseña de empleado es: " + contraseña);
                                            System.out.println("Si desea que el cambio de contraseña sea permanente, cambie en el codigo la variable empleado y ponga como valor: " + encriptar(contraseña));
                                            System.out.println("Puse enter para continuar");
                                            teclado.nextLine();
                                            teclado.nextLine();
                                            limpiar();
                                        } else {
                                            contraseña = "#";
                                        }
                                        break;
                                    case 3:
                                        if (encriptar(contraseña).equals(estadistica)) {
                                            i = 2;
                                            do {
                                                System.out.print("Escriba la nueva contraseña: ");
                                                contraseña = teclado.nextLine();
                                                System.out.print("Escriba de nuevo la nueva contraseña: ");
                                                contraseña2 = teclado.nextLine();
                                                if (!(contraseña.equals(contraseña2))) {
                                                    System.out.println("A introducido dos contraseñas distintas, porfavor vuelva a introducirlas.");
                                                }
                                            } while (!(contraseña.equals(contraseña2)));
                                            estadistica = encriptar(contraseña);
                                            System.out.println("La nueva contraseña de empleado es: " + contraseña);
                                            System.out.println("Si desea que el cambio de contraseña sea permanente, cambie en el codigo la variable empleado y ponga como valor: " + encriptar(contraseña));
                                            System.out.println("Puse enter para continuar");
                                            teclado.nextLine();
                                            teclado.nextLine();
                                            limpiar();
                                        } else {
                                            contraseña = "#";
                                        }
                                        break;
                                }

                            } while (contraseña == "#");
                        }
                        usuario = ""; contraseña = "#"; opcion=0; user=0;
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
            switch (user) {
                case 1:
                    for (; pSalas < 1; ) {
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
                            case 0:
                                pSalas = 2;
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
                    break;
                case 2:

                    break;
                case 3:

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
