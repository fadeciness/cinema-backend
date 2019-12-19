package ru.rosbank.javaschool.cinema.rest;

import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Сохраняет переданный файл на диск")
    public UploadResponseDto uploadMultipart(@RequestParam MultipartFile file) {
        return service.save(file);
    }

}
