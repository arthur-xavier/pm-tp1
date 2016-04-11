package pm.estacionamento;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Predio predio = new Predio();
        Totem totem = new Totem(predio);

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            try {
                System.out.println(totem.realizarAtendimento(scanner.nextLine()));
            } catch(IllegalArgumentException e) {
                System.out.println("Entrada invalida");
            }
        }
    }
}
