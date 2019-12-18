package ru.rosbank.javaschool.cinema.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileServiceTest {

    @Test
    void initCreatesFolderWhenItNotExist() throws IOException {
        String uploadPath = "c://tmp/0";
        FileService service = new FileService(uploadPath);
        service.init();

        assertTrue(Files.exists(Paths.get(uploadPath)));
    }
}