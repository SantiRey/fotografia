package utils;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveLoadFiles {

    public static void saveFile(UploadedFile file, String name) throws IOException {
        FileOutputStream pictureFileStream = new FileOutputStream(name);
        pictureFileStream.write(file.getContent());
        pictureFileStream.close();
    }
    public static StreamedContent loadFile(String name){
        DefaultStreamedContent fileLoaded = DefaultStreamedContent.builder()
                .name("yourFoto.jpg")
                .contentType("image/jpg")
                .stream(() -> {
                    try {
                        return new FileInputStream(name + ".png");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .build();
        return fileLoaded;

    }

}
