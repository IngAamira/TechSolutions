package com.ingaamira.techsolutions.application.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Esta clase proporciona métodos para subir y eliminar archivos en la aplicación.
 */
public class UploadFile {
    private final String FOLDER = "images//";
    private final String IMG_DEFAULT = "default.jpg";

    /**
     * Sube un archivo al directorio de imágenes.
     *
     * @param multipartFile El archivo a subir.
     * @return El nombre del archivo subido.
     * @throws IOException Si ocurre un error durante la operación de escritura.
     */
    public String upload(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()){
            byte [] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            Files.write(path ,bytes);
            return multipartFile.getOriginalFilename();
        }
        return IMG_DEFAULT;
    }

    /**
     * Elimina un archivo del directorio de imágenes.
     *
     * @param nameFile El nombre del archivo a eliminar.
     */
    public void delete(String nameFile){
        File file = new File(FOLDER + nameFile);
        file.delete();
    }

}
