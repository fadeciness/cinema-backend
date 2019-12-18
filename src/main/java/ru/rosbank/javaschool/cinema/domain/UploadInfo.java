package ru.rosbank.javaschool.cinema.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadInfo {

    private Resource resource;
    private String mimeType;

}
