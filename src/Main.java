package com.tecnm.morelia.itics.poo.archivos.bags;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Crear manejadores de archivos
        ManejoArchivosTexto archivosTexto = new ManejoArchivosTexto();
        ManejoArchivosBinarios archivosBinarios = new ManejoArchivosBinarios();

        // Crear y capturar una inversión
        Inversion inversion = new Inversion();
        inversion.capturarDatos();
        inversion.mostrarInformacion();

        // Guardar datos en archivos
        archivosTexto.escribir("inversion.txt", inversion.toString());
        archivosBinarios.escribir("inversion.dat", inversion);

        System.out.println("\n✅ Datos guardados en inversion.txt e inversion.dat\n");

        // Leer desde los archivos
        System.out.println("📄 Contenido del archivo de texto:");
        System.out.println(archivosTexto.leer("inversion.txt"));

        System.out.println("\n💾 Objeto leído desde el archivo binario:");
        Inversion leida = (Inversion) archivosBinarios.leer("inversion.dat");
        leida.mostrarInformacion();
    }
}
