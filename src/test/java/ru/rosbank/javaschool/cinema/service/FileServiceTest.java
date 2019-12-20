package ru.rosbank.javaschool.cinema.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;
import ru.rosbank.javaschool.cinema.dto.UploadResponseDto;
import ru.rosbank.javaschool.cinema.exception.FileStorageException;
import ru.rosbank.javaschool.cinema.exception.NullContentTypeException;
import ru.rosbank.javaschool.cinema.exception.UnsupportedFileTypeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileServiceTest {

    String uploadPath = "c://tmp/0";
    private MultipartFile multipartFile;

    @BeforeEach
    void setup() {
        multipartFile = mock(MultipartFile.class);
    }

    @Test
    void initCreatesFolderWhenItNotExist() throws IOException {
        Files.delete(Paths.get(uploadPath));
        FileService service = new FileService(uploadPath);
        service.init();

        assertTrue(Files.exists(Paths.get(uploadPath)));
    }

    @Test
    void saveMultipartThrowExceptionWhenContentTypeNull() {
        when(multipartFile.getContentType()).thenReturn(null);
        FileService service = new FileService(uploadPath);

        assertThrows(NullContentTypeException.class, () -> service.save(multipartFile));
    }

    @Test
    void saveMultipartJpegCheckExtension() {
        when(multipartFile.getContentType()).thenReturn("image/jpeg");
        FileService service = new FileService(uploadPath);

        UploadResponseDto result = service.save(multipartFile);

        assertTrue(result.getName().endsWith(".jpg"));
    }

    @Test
    void saveMultipartPngCheckExtension() {
        when(multipartFile.getContentType()).thenReturn("image/png");
        FileService service = new FileService(uploadPath);

        UploadResponseDto result = service.save(multipartFile);

        assertTrue(result.getName().endsWith(".png"));
    }

    @Test
    void saveMultipartWebmCheckExtension() {
        when(multipartFile.getContentType()).thenReturn("video/webm");
        FileService service = new FileService(uploadPath);

        UploadResponseDto result = service.save(multipartFile);

        assertTrue(result.getName().endsWith(".webm"));
    }

    @Test
    void saveMultipartMp4CheckExtension() {
        when(multipartFile.getContentType()).thenReturn("video/mp4");
        FileService service = new FileService(uploadPath);

        UploadResponseDto result = service.save(multipartFile);

        assertTrue(result.getName().endsWith(".mp4"));
    }

    @Test
    void saveMultipartThrowExceptionWhenNoValidExtension() {
        when(multipartFile.getContentType()).thenReturn("abracadabra");
        FileService service = new FileService(uploadPath);

        assertThrows(UnsupportedFileTypeException.class, () -> service.save(multipartFile));
    }

    @Test
    void saveMultipartThrowExceptionWhenWasIOException() throws IOException {
        when(multipartFile.getContentType()).thenReturn("image/jpeg");
        doThrow(IOException.class).when(multipartFile).transferTo((Path) any());
        FileService service = new FileService(uploadPath);

        assertThrows(FileStorageException.class, () -> service.save(multipartFile));
    }

    @Test
    void saveMultipartReturnUploadResponseDtoWhenSaveIsOk() {
        when(multipartFile.getContentType()).thenReturn("image/jpeg");
        FileService service = new FileService(uploadPath);

        UploadResponseDto result = service.save(multipartFile);

        assertNotNull(result);
    }

}