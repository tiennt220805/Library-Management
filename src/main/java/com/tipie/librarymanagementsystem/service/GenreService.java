package com.tipie.librarymanagementsystem.service;

import com.tipie.librarymanagementsystem.payload.request.genre.CreateGenreRequest;
import com.tipie.librarymanagementsystem.payload.response.GenreResponse;

import java.util.List;

public interface GenreService  {

    GenreResponse createGenre(CreateGenreRequest request);

    List<GenreResponse> getAllGenres();

    //GenreDTO getGenreById(Long id);

    //GenreDTO updateGenre(long id, GenreDTO genreDTO);

    //void deleteGenre(long id);

    //void hardDeleteGenre(long id);

    //<GenreDTO> getAllActiveGenresWithSubGenres();

    //List<GenreDTO> getTopLevelGenres();

    // Page<GenreDTO> searchGenres(Pageable pageable);

    //long getTotalActiveGenres();

    //long getBookCountByGenre(long genreId);
}
