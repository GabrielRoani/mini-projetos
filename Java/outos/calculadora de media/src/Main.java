import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("digite sua nota 1");
        int nota1 = scanner.nextInt();

        System.out.println("digite sua nota 2");
        int nota2 = scanner.nextInt();

        System.out.println("digite sua nota 3");
        int nota3 = scanner.nextInt();

        System.out.println("digite sua nota 4");
        int nota4 = scanner.nextInt();
        int media = (nota1+nota2+nota3+nota4)/4;
        System.out.println("sua media é:" + media);


        if (media>7) {
            System.out.println("Você passou!");

        }
        else if (media<7) {
            System.out.println("Você esta reprovado");
        }

         else {
            System.out.println("Você esta em recuperação");
        }
    }
}