package com.dnzocoud.mantix_api.domain.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class FileUtilities {
    /**
     * Convierte una cadena Base64 a un arreglo de bytes.
     * 
     * @param base64 Cadena Base64 a decodificar.
     * @return Arreglo de bytes decodificado, o null si ocurre un error.
     */
    private static byte[] base64ToBytes(String base64) {
        if (base64 == null || base64.isEmpty()) {
            throw new IllegalArgumentException("La cadena Base64 no puede ser nula o vacía.");
        }

        try {
            return Base64.getDecoder().decode(base64);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error al decodificar la cadena Base64: " + e.getMessage(), e);
        }
    }

    /**
     * Guarda un arreglo de bytes como un archivo en la carpeta 'temp'.
     *
     * @param fileBytes Arreglo de bytes a guardar.
     * @return Archivo creado.
     * @throws IOException Si ocurre un error al guardar el archivo.
     */

    public static File saveBytesToFile(byte[] fileBytes) throws IOException {
        if (fileBytes == null) {
            throw new IOException("Los bytes son obligatorios");
        }

        Path tempDir = Paths.get("temp");

        if (!Files.exists(tempDir)) {
            Files.createDirectories(tempDir);
        }
        Path tempFile = Files.createTempFile(tempDir, "archivo_", ".tmp");
        try (FileOutputStream fos = new FileOutputStream(tempFile.toFile())) {
            fos.write(fileBytes);
        }

        return tempFile.toFile();
    }

    /**
     * Convierte una cadena Base64 a un archivo y lo guarda en la carpeta 'temp'.
     *
     * @param base64 Cadena Base64 a convertir.
     * @return Archivo creado.
     * @throws IOException Si ocurre un error al decodificar o guardar el archivo.
     */
    public static File base64ToFile(String base64) throws IOException {
        byte[] fileBytes = base64ToBytes(base64);
        return saveBytesToFile(fileBytes);
    }

    public static String bytesToBase64(byte[] fileBytes) {
        return Base64.getEncoder().encodeToString(fileBytes);
    }
}
