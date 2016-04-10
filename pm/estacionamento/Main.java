package pm.estacionamento;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Predio predio = new Predio();
        Totem totem = new Totem(predio);

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            totem.realizarAtendimento(scanner.nextLine());
        }
    }
}
