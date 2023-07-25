package org.example;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nombreBanco;
    private List<CuentaCorriente> cuentas;

    Banco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
        cuentas = new ArrayList<CuentaCorriente>();
        mostrarInfoCuentasBanco();
    }

    public boolean buscarCuenta(int dni){
        boolean existe = false;
        for (CuentaCorriente c : cuentas){
            if (c.getDni() == dni) {
                System.out.println(c);
                existe = true;
            }
            else {
                System.out.println("Error: La cuenta con dni " + dni + " no existe.");
            }
        }
        return existe;
    }

    public void añadirCuenta(int dni, String titular, String sexo, String nombreBanco) {
        int cantidad = 0;
        CuentaCorriente cuenta= new CuentaCorriente(dni, titular, sexo, cantidad, nombreBanco);
        boolean existe = buscarCuenta(cuenta.getDni());
        if (existe) {
            System.out.println("La cuenta no pudo crearse porque ya existe.");
        }
        else {
            cuentas.add(cuenta);
            System.out.println("La cuenta se ha creado con exito.");
        }

    }

    public void mostrarInfoCuentasBanco(){
        for(CuentaCorriente c: cuentas) {
            System.out.println(c);
        }
    }

    public void ingresarDinero(int dni, int cantidad) {
        for (CuentaCorriente c : cuentas) {
            if (c.getDni() == dni) {
                if (cantidad > 0) {
                    c.setCantidad(cantidad);
                    System.out.println("Se ha agregado $" + cantidad + " a la cuenta. Hay un total de $" + c.getCantidad());
                } else {
                    System.out.println("Error: la cantidad ingresada no puede tener numeros negativos.");
                }
            }
            else {
                System.out.println("Error: el dni " + dni + " no existe.");
            }
        }
    }

   public void retirarDinero(int dni, int cantidad) {
       for (CuentaCorriente c : cuentas) {
           if (c.getDni() == dni) {
               if (cantidad > 0 && cantidad <= c.getCantidad()) {
                   cantidad = c.getCantidad() - cantidad;
                   c.setCantidad(cantidad);
                   System.out.println("Se ha hecho un retiro de $" + cantidad + " a la cuenta. Hay un total de $" + c.getCantidad());
               } else {
                   System.out.println("Error: la cantidad ingresada no es valida");
               }
           } else {
               System.out.println("Error: el dni " + dni + " no existe.");
           }
       }
   }
   public void eliminarCuenta(int dni) {
        for(int i=0; i < cuentas.size();i++){
            if (dni == cuentas.get(i).getDni()) {
                cuentas.remove(i);
                System.out.println("La cuenta con dni " + cuentas.get(i).getDni() + " ha sido eliminada con exito.");
            }
            else {
                System.out.println("Error: no se puede eliminar la cuenta con dni " + dni + " porque no existe.");
            }
        }
    }

   public void contarSexo() {
        int esMasculino = 0;
        int esFemenino = 0;
        for(int i=0; i < cuentas.size();i++){
            if(cuentas.get(i).getSexo() == "M"){
                esMasculino+=1;
                System.out.println("La cantidad de generos Masculinos es: " + esMasculino);
            }
            else {
                esFemenino+=1;
                System.out.println("La cantidad de generos Femenino es: " + esFemenino);
            }
        }
   }

   public void mostrarMenu() {
       System.out.println("Elige la opcion que desees realizar:");
       System.out.println("1. Crear una cuenta corriente");
       System.out.println("2. Eliminar una cuenta corriente");
       System.out.println("3. Buscar una cuenta corriente");
       System.out.println("4. Añadir una cantidad de dinero a una cuenta");
       System.out.println("5. Retirar una cantidad de dinero de una cuenta");
       System.out.println("6. Mostrar informacion de todas las cuentas del Banco");
       System.out.println("7. Salir");
   }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
}
