package com.example.synergybackend.controller;

import com.example.synergybackend.model.Image;
import com.example.synergybackend.services.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ImageController {
    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title,
                           @RequestParam("image") MultipartFile image, Image model)
            throws IOException {
        String id = ImageService.addPhoto(title, image);
        return "redirect:/photos/" + id;
    }

    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable String id, Image model) {
        Image img = ImageService.getPhoto(id);
        img.addAttribute("title", img.getTitle());
        img.addAttribute("image",
                Base64.getEncoder().encodeToString(img.getImage().getData()));
        return "photos";
    }
}
