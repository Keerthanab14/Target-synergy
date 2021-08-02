package com.example.synergybackend.controller;


import com.example.synergybackend.model.Image;
import com.example.synergybackend.repository.ImageRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ImageController {
    @Autowired
    private ImageRepository imageRepo;

    @PostMapping("/file/uploadImage")
    public String uploadImage(@RequestBody MultipartFile file){
//        if(file.isEmpty())
//            return  JSONResult.build (200, "please select a picture", null);
//
//        //This class can encapsulate itself
//        JSONResult jsonResult = null;
        String fileName = file.getOriginalFilename();
        try {
            Image uploadFile = new Image();
            uploadFile.setTitle(fileName);
            uploadFile.setImage(new Binary(file.getBytes()));

            Image savedFile = imageRepo.save(uploadFile);
            String url = "http://localhost:8080/file/image/"+ savedFile.getId();

//            jsonResult =   JSONResult.build (200, "image uploaded successfully", URL);
        } catch (IOException e) {
            e.printStackTrace();
//            jsonResult =   JSONResult.build (500, "image upload failed", null);
        }
        return "saved";

    }
}
