package ru.rosbank.javaschool.cinema.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.rosbank.javaschool.cinema.dto.UploadResponseDto;
import ru.rosbank.javaschool.cinema.exception.FileStorageException;
import ru.rosbank.javaschool.cinema.exception.NullContentTypeException;
import ru.rosbank.javaschool.cinema.exception.UnsupportedFileTypeException;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
public class FileService {

    private final String uploadPath;

    public FileService(@Value("${app.upload-path}") String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @PostConstruct
    public void init() throws IOException {
        Path path = Paths.get(uploadPath);
        if (Files.notExists(path)) {
            Files.createDirectories(path);
        }
    }

    public UploadResponseDto save(MultipartFile multipartFile) {
        String extension;
        String contentType = multipartFile.getContentType();
        if (contentType == null) {
            throw new NullContentTypeException();
        }
        if ("image/jpeg".equals(contentType)) {
            extension = ".jpg";
        } else if ("image/png".equals(contentType)) {
            extension = ".png";
        } else if ("video/webm".equals(contentType)) {
            extension = ".webm";
        } else if ("video/mp4".equals(contentType)) {
            extension = ".mp4";
        } else {
            throw new UnsupportedFileTypeException(contentType);
        }

        String name = UUID.randomUUID() + extension;
        try {
            multipartFile.transferTo(Paths.get(uploadPath).resolve(name));
            return new UploadResponseDto(name);
        } catch (IOException e) {
            throw new FileStorageException(e);
        }
    }
}
