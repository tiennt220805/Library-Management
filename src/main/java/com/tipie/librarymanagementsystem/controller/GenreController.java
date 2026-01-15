package com.tipie.librarymanagementsystem.controller;

import com.tipie.librarymanagementsystem.payload.dto.GenreDTO;
import com.tipie.librarymanagementsystem.payload.response.ApiResponse;
import com.tipie.librarymanagementsystem.modal.Genre;
import com.tipie.librarymanagementsystem.service.GenreService;
import com.tipie.librarymanagementsystem.util.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService  genreService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<GenreDTO>> createGenre(@RequestBody GenreDTO genreDTO) {
        GenreDTO createdGenre = genreService.createGenre(genreDTO);
        return ResponseFactory.created(createdGenre, "Genre created successfully");
    }
}
