package br.com.anderson.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {
    private final Scanner sc;

    public ScannerUtil(Scanner sc){
        this.sc = sc;
    }

    public int requestInteger(String message){
        int number;

        while(true) {
            try {
                System.out.print(message + ": ");
                number = sc.nextInt();
                sc.nextLine();
                if(number >= 0) {
                    System.out.println();
                    break;
                } else {
                    System.out.println("Números negativos não são permitidos. Tente novamente!\n");
                }
            }catch(InputMismatchException e) {
                sc.next();
                System.out.println("Digite um número inteiro. Tente novamente!\n");
            }
        }

        return number;
    }

    public double requestDouble(String message){
        double number;

        while(true){
            try {
                System.out.print(message + ": ");
                number = sc.nextDouble();
                sc.nextLine();

                if(number >= 0) {
                    System.out.println();
                    break;
                } else {
                    System.out.println("Número negativos não são permitidos. Tente novamente!\n");
                }
            } catch(InputMismatchException e){
                sc.next();
                System.out.println("Digite um número. Tente novamente!\n");
            }
        }

        return number;
    }

    public String requestString(String message){
        String text;

        while(true){
            System.out.print(message + ": ");
            text = sc.nextLine().trim();

            if(!text.isEmpty()){
                System.out.println();
                return text;
            }

            System.out.println("Digite um texto válido. Tente novamente!");
            System.out.println();
        }
    }
}