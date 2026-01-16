package com.tipie.librarymanagementsystem.service.impl;

import com.tipie.librarymanagementsystem.mapper.GenreMapper;
import com.tipie.librarymanagementsystem.modal.Genre;
import com.tipie.librarymanagementsystem.payload.request.genre.CreateGenreRequest;
import com.tipie.librarymanagementsystem.payload.response.GenreResponse;
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
    public GenreResponse createGenre(CreateGenreRequest request) {
        Genre genre = GenreMapper.toEntity(request);

        if (request.getParentGenreId() != null) {
            genreRepository.findById(request.getParentGenreId())
                    .ifPresent(genre::setParentGenre);
        }

        Genre createdGenre = genreRepository.save(genre);

        return GenreMapper.toResponse(createdGenre);
    }

    @Override
    public List<GenreResponse> getAllGenres() {
        return genreRepository.findAll().stream()
                .map(GenreMapper::toResponse).collect(Collectors.toList());
    }
}
