package ru.example.bookmarket.controller.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.example.bookmarket.controller.ImageController;
import ru.example.bookmarket.model.Image;
import ru.example.bookmarket.service.ImageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImageControllerImpl implements ImageController {
    private final ImageService imageService;

    public ResponseEntity<?> save(@RequestBody List<MultipartFile> files) {
        imageService.save(files);
        return ResponseEntity.ok().build();
    }

    public Image findById(@PathVariable Long id) {
        return imageService.findById(id);
    }

    public void deleteById(@PathVariable Long id) {
        imageService.deleteById(id);
    }
}
