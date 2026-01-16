package com.tipie.librarymanagementsystem.payload.request.genre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGenreRequest {
    @NotBlank(message = "Mã loại là bắt buộc")
    @Size(max = 50, message = "Mã không được quá 50 kí tự")
    private String code;

    @NotBlank(message = "Tên thể loại là bắt buộc")
    private String name;

    private String description;
    private Integer displayOrder;
    private Long parentGenreId;
}
