package com.tipie.librarymanagementsystem.service.impl;

import com.tipie.librarymanagementsystem.mapper.GenreMapper;
import com.tipie.librarymanagementsystem.modal.Genre;
import com.tipie.librarymanagementsystem.payload.dto.GenreDTO;
import com.tipie.librarymanagementsystem.repository.GenreRepository;
import com.tipie.librarymanagementsystem.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = GenreMapper.toEntity(genreDTO);

        if (genreDTO.getParentGenreId() != null) {
            genreRepository.findById(genreDTO.getParentGenreId())
                    .ifPresent(genre::setParentGenre);
        }

        Genre createdGenre = genreRepository.save(genre);

        return GenreMapper.toDTO(createdGenre);
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        return genreRepository.findAll().stream()
                .map(GenreMapper::toDTO).collect(Collectors.toList());
    }
}
