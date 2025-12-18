package com.tecnm.morelia.itics.poo.archivos.bags;

import java.io.Serializable;
import java.util.Scanner;

public class Inversion implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private double capital;
    private String moneda;
    private double porcentajeRiesgo;
    private double porcentajeGanancia;

    public Inversion(String nombre, double capital, String moneda) {
        this.nombre = nombre;
        this.capital = capital;
        this.moneda = moneda;
        calcularRiesgoYGanancia();
    }

    public Inversion() {}

    private void calcularRiesgoYGanancia() {
        this.porcentajeRiesgo = Math.random() * 9 + 1;   // 1–10%
        this.porcentajeGanancia = Math.random() * 15 + 5; // 5–20%
    }

    public void mostrarInformacion() {
        double capitalFinalPerdida = capital * (1 - (porcentajeRiesgo / 100));
        double capitalFinalGanancia = capital * (1 + (porcentajeGanancia / 100));

        System.out.println("\n===== RESULTADO DE LA INVERSIÓN =====");
        System.out.println("Nombre: " + nombre);
        System.out.println("Capital inicial: " + capital + " " + moneda);
        System.out.printf("Riesgo: %.2f%% → Capital final si pierdes: %.2f %s\n",
                porcentajeRiesgo, capitalFinalPerdida, moneda);
        System.out.printf("Ganancia estimada: %.2f%% → Capital final si ganas: %.2f %s\n",
                porcentajeGanancia, capitalFinalGanancia, moneda);
    }

    public void capturarDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce tu nombre: ");
        this.nombre = scanner.nextLine();

        do {
            System.out.print("Introduce el capital que tienes: ");
            this.capital = scanner.nextDouble();
            if (this.capital <= 0) {
                System.out.println("❌ El capital debe ser mayor que 0.");
            }
        } while (this.capital <= 0);

        scanner.nextLine(); // limpiar buffer

        System.out.print("Introduce el tipo de moneda (Ejemplo: USD, EUR, MXN): ");
        this.moneda = scanner.nextLine();

        calcularRiesgoYGanancia();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nCapital: " + capital + " " + moneda +
                String.format("\nRiesgo: %.2f%%", porcentajeRiesgo) +
                String.format("\nGanancia estimada: %.2f%%", porcentajeGanancia);
    }
}
