package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.example.bookmarket.model.Image;
import ru.example.bookmarket.repository.ImageRepository;
import ru.example.bookmarket.util.Converter;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageService {
    ImageRepository imageRepository;

    public List<Image> save(List<MultipartFile> files) {
        List<Image> images = files.stream()
                .map(Converter::toImageEntity)
                .collect(Collectors.toList());
        return imageRepository.saveAll(images);
    }

    public Image findById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public void deleteById(Long id) {
        try {
            imageRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Image with id '%d' not exist");
        }
    }
}
