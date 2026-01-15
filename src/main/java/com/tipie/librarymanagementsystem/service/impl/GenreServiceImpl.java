package com.tipie.librarymanagementsystem.service.impl;

import com.tipie.librarymanagementsystem.modal.Genre;
import com.tipie.librarymanagementsystem.payload.dto.GenreDTO;
import com.tipie.librarymanagementsystem.repository.GenreRepository;
import com.tipie.librarymanagementsystem.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = Genre.builder()
                .code(genreDTO.getCode())
                .name(genreDTO.getName())
                .description(genreDTO.getDescription())
                .displayOrder(genreDTO.getDisplayOrder())
                .active(true)
                .build();

        if (genreDTO.getParentGenreId() != null) {
            Genre parentGenre = genreRepository.findById(genreDTO.getParentGenreId()).get();
            genre.setParentGenre(parentGenre);
        }

        Genre createdGenre = genreRepository.save(genre);

        GenreDTO createdGenreDTO = GenreDTO.builder()
                .id(createdGenre.getId())
                .code(createdGenre.getCode())
                .name(createdGenre.getName())
                .description(createdGenre.getDescription())
                .displayOrder(createdGenre.getDisplayOrder())
                .active(createdGenre.getActive())
                .createdDate(createdGenre.getCreatedAt())
                .updatedDate(createdGenre.getUpdatedAt())
                .build();

        if (createdGenre.getParentGenre() != null) {
            createdGenreDTO.setParentGenreId(createdGenre.getParentGenre().getId());
            createdGenreDTO.setParentGenreName(createdGenre.getParentGenre().getName());
        }

        return createdGenreDTO;
    }
}
