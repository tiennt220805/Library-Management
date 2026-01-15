package com.tipie.librarymanagementsystem.payload.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDTO {

    private Long id;

    private String code;

    private String name;

    private String description;

    private Integer displayOrder=0;

    private boolean active;

    private Long parentGenreId;

    private String parentGenreName;

    private List<GenreDTO> subGenre;

    private Long bookCount;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
