package ru.rosbank.javaschool.cinema.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadResponseDto {

    @ApiModelProperty(position = 1)
    private String name;

}
