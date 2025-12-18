package com.tecnm.morelia.itics.poo.archivos.bags;

import java.io.*;

public class ManejoArchivosTexto {

    public void escribir(String nombreArchivo, String contenido) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write(contenido);
        }
    }

    public String leer(String nombreArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString();
    }
}
