package com.tecnm.morelia.itics.poo.archivos.bags;

import java.io.*;

public class ManejoArchivosBinarios {

    public void escribir(String nombreArchivo, Object objeto) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(objeto);
        }
    }

    public Object leer(String nombreArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return ois.readObject();
        }
    }
}
