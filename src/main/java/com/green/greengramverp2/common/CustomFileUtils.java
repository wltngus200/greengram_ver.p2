package com.green.greengramverp2.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component
public class CustomFileUtils {
    private final String uploadPath;

    CustomFileUtils(@Value("${greengram.picture}") String uploadPath){
        this.uploadPath=uploadPath;
    }

    public String randomFile(){return UUID.randomUUID().toString();}
    public String randomFile(String originalName){return randomFile()+getExt(originalName);}
    public String randomFile(MultipartFile mf){return randomFile(mf.getOriginalFilename());}

    public String getExt(String originalName){
        int idx=originalName.lastIndexOf(".");
        String ext=originalName.substring(idx);
        return ext;
    }

    public void transferTo(MultipartFile mf, String target) throws Exception{
        File saveFile = new File(uploadPath, target);
        mf.transferTo(saveFile);
    }

    public String makeFolder(String path){
        File folder=new File(uploadPath, path);
        folder.mkdirs();
        return folder.getAbsolutePath();
    }
}
