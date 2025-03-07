package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR="F:\\SpringBoot_Concepts\\bootrestbook\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile multipartFile){
        boolean b = false;

        try {
            // InputStream is = multipartFile.getInputStream();
            // byte data[] = new byte[is.available()];
            // //read file
            // is.read(data);

            // // write file
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
            // fos.write(data);

            // fos.flush();
            // fos.close();
            
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);




            b = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }
}
