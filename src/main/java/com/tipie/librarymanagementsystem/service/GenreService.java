package com.tipie.librarymanagementsystem.service;

import com.tipie.librarymanagementsystem.modal.Genre;
import com.tipie.librarymanagementsystem.payload.dto.GenreDTO;

public interface GenreService  {

    GenreDTO createGenre(GenreDTO genreDTO);

}
