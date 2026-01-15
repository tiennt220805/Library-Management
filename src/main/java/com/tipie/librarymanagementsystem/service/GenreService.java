package com.tipie.librarymanagementsystem.service;

import com.tipie.librarymanagementsystem.payload.dto.GenreDTO;

import java.util.List;

public interface GenreService  {

    GenreDTO createGenre(GenreDTO genreDTO);

    List<GenreDTO> getAllGenres();
}
