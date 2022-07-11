package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.example.bookmarket.exception.ImageNotFoundException;
import ru.example.bookmarket.model.Image;
import ru.example.bookmarket.repository.ImageRepository;
import ru.example.bookmarket.util.Converter;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public List<Image> save(List<MultipartFile> files) {
        List<Image> images = files.stream()
                .map(Converter::toImageEntity)
                .collect(Collectors.toList());
        return imageRepository.saveAll(images);
    }

    @Transactional
    public Image findById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ImageNotFoundException(id));
    }

    public void deleteById(Long id) {
        if (imageRepository.existsById(id)) {
            imageRepository.deleteById(id);
        } else throw new ImageNotFoundException(id);


    }
}
