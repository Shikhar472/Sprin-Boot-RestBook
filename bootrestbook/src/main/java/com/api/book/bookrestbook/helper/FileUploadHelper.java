package com.api.book.bookrestbook.helper;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR="C:\\SpringBootPractice\\bootrestbook\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile multipartFile){
        boolean f=false;

        try {
            //
//           InputStream inputStream =  multipartFile.getInputStream();
//           byte data[] = new byte[inputStream.available()];
//           inputStream.read(data);
//
//           //write
//            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+ File.separator +multipartFile.getOriginalFilename());
//            fos.write(data);
//            fos.flush();
//            fos.close();
//            f=true;

            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            e.printStackTrace();
        }

        return f;
    }
}
