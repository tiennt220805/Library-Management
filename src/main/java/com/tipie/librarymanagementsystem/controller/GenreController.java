package com.tipie.librarymanagementsystem.controller;

import com.tipie.librarymanagementsystem.payload.request.genre.CreateGenreRequest;
import com.tipie.librarymanagementsystem.payload.response.ApiResponse;
import com.tipie.librarymanagementsystem.payload.response.GenreResponse;
import com.tipie.librarymanagementsystem.service.GenreService;
import com.tipie.librarymanagementsystem.util.ResponseFactory;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService  genreService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<GenreResponse>> createGenre(@Valid @RequestBody CreateGenreRequest request) {
        GenreResponse createdGenre = genreService.createGenre(request);
        return ResponseFactory.created(createdGenre, "Genre created successfully");
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GenreResponse>>> getAllGenres() {
        List<GenreResponse> genres = genreService.getAllGenres();
        return ResponseFactory.ok(genres, "Get genres successfully");
    }
}
