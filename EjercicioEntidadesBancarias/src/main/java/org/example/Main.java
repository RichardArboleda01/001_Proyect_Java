package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("BBVA");
        int opcionUsuario = 0;
        while (opcionUsuario != 7){
            banco.mostrarMenu();
            opcionUsuario = sc.nextInt();
            if (opcionUsuario == 1) {
                System.out.println("Ingresa tu nombre: ");
                String titular = sc.nextLine();
                sc.nextLine();
                System.out.println("Ingresa tu DNI: ");
                int dni = sc.nextInt();
                sc.nextLine();
                System.out.println("Ingresa tu sexo: ");
                String sexo = sc.nextLine();
                banco.añadirCuenta(dni, titular, sexo, banco.getNombreBanco());
            }
            else if (opcionUsuario == 2){
                System.out.println("Ingresa el dni de la cuenta que quieres eliminar:");
                int dni = sc.nextInt();
                banco.eliminarCuenta(dni);
            }
            else if(opcionUsuario == 3) {
                System.out.println("Ingresa el dni de la cuenta que quieres buscar:");
                int dni = sc.nextInt();
                banco.buscarCuenta(dni);
            }
            else if(opcionUsuario == 4) {
                System.out.println("Ingresa el dni de la cuenta a la que depositarás dinero: ");
                int dni = sc.nextInt();
                System.out.println("Ingresa la cantidad de dinero a depositar:");
                int cantidad = sc.nextInt();
                banco.ingresarDinero(dni, cantidad);
            }
            else if(opcionUsuario == 5) {
                System.out.println("Ingresa el dni de la cuenta de la que retirarás dinero: ");
                int dni = sc.nextInt();
                System.out.println("Ingresa la cantidad de dinero a retirar:");
                int cantidad = sc.nextInt();
                banco.retirarDinero(dni, cantidad);
            }
            else if (opcionUsuario == 6) {
                banco.mostrarInfoCuentasBanco();
            }
        }

    }
}