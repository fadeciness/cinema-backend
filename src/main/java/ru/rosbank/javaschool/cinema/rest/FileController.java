package ru.rosbank.javaschool.cinema.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.rosbank.javaschool.cinema.dto.UploadResponseDto;
import ru.rosbank.javaschool.cinema.service.FileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class FileController {

    private final FileService service;

    @PostMapping("/multipart")
    public UploadResponseDto uploadMultipart(@RequestParam MultipartFile file) {
        return service.save(file);
    }

}
