package com.tipie.librarymanagementsystem.mapper;

import com.tipie.librarymanagementsystem.modal.Genre;
import com.tipie.librarymanagementsystem.payload.dto.GenreDTO;

import java.util.stream.Collectors;

public class GenreMapper {
    public static GenreDTO toDTO(Genre genre) {
        if (genre == null) {
            return null;
        }

        GenreDTO genreDTO = GenreDTO.builder()
                .id(genre.getId())
                .code(genre.getCode())
                .name(genre.getName())
                .description(genre.getDescription())
                .displayOrder(genre.getDisplayOrder())
                .active(genre.getActive())
                .createdDate(genre.getCreatedAt())
                .updatedDate(genre.getUpdatedAt())
                .build();

        if (genre.getParentGenre() != null) {
            genreDTO.setParentGenreId(genre.getParentGenre().getId());
            genreDTO.setParentGenreName(genre.getParentGenre().getName());
        }

        if (genre.getSubGenres() != null && !genre.getSubGenres().isEmpty()) {
            genreDTO.setSubGenre(genre.getSubGenres().stream()
                    .filter(Genre::getActive)
                    .map(GenreMapper::toDTO).collect(Collectors.toList()));
        }

        //genreDTO.setBookCount((long) genre.get);

        return genreDTO;
    }

    public static Genre toEntity(GenreDTO genreDTO) {
        if (genreDTO == null) {
            return null;
        }

        return Genre.builder()
                .code(genreDTO.getCode())
                .name(genreDTO.getName())
                .description(genreDTO.getDescription())
                .displayOrder(genreDTO.getDisplayOrder())
                .active(true)
                .build();
    }
}
