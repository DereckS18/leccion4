package ec.edu.espoch.leccion4;

import java.util.Scanner;

public class SimuladorDificultad {
    private Scanner teclado;

    public SimuladorDificultad(Scanner teclado) {
        this.teclado = teclado;
    }

    public double simularIncremento(double factorActual) {
        System.out.print("Ingrese el porcentaje de incremento: ");
        double porcentaje = leerPorcentaje();
        double nuevo = factorActual * (1 + porcentaje / 100);
        System.out.println("Factor actual: " + factorActual);
        System.out.println("Factor propuesto: " + nuevo);
        return nuevo;
    }

    private double leerPorcentaje() {
        while (true) {
            try {
                String texto = teclado.nextLine();
                double valor = Double.parseDouble(texto);
                if (valor > -100) {
                    return valor;
                }
                System.out.print("El porcentaje debe ser mayor que -100. Intente de nuevo: ");
            } catch (NumberFormatException e) {
                System.out.print("Valor invalido. Ingrese un numero: ");
            }
        }
    }
}