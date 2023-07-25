package org.example;

public class CuentaCorriente extends Banco{

    private int dni;
    private String titular;
    private String sexo;
    private int cantidad;

    CuentaCorriente(int dni, String titular, String sexo, int cantidad, String nombreBanco) {
        super(nombreBanco);
        this.dni = dni;
        this.titular = titular;
        this.sexo = sexo;
        this.cantidad = cantidad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "dni=" + dni +
                ", titular='" + titular + '\'' +
                ", sexo='" + sexo + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
