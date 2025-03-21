package org.example;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Diga um número:");
        int numero1 = scanner.nextInt();

        if (numero1 % 2 == 0) {
            System.out.println("É par !");

        } else {
            System.out.println("É impar!");

        }
        if (numero1 > 0) {
            System.out.println("Número Positivo");

        } else if (numero1 == 0) {
            System.out.println("Número Nulo");

        } else {
            System.out.println("Número Negativo");

        }
    }
}

