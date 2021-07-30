package com.example.synergybackend.services;

import com.example.synergybackend.model.Image;
import com.example.synergybackend.repository.ImageRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imgRepo;

    public static String addPhoto(String title, MultipartFile file) throws IOException {
        Image img = new Image(title);
        img.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        img = imgRepo.insert(img); return img.getId();
    }

    public static Image getPhoto(String id) {
        return imgRepo.findById(id).get();
    }
}
