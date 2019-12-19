package ru.rosbank.javaschool.cinema.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @ApiModelProperty(position = 1)
    private final int status;

    @ApiModelProperty(position = 2)
    private final String message;

    @ApiModelProperty(position = 3)
    private final Map<String, List<String>> errors;

}
