package com.tipie.librarymanagementsystem.mapper;

import com.tipie.librarymanagementsystem.modal.Genre;
import com.tipie.librarymanagementsystem.payload.request.genre.CreateGenreRequest;
import com.tipie.librarymanagementsystem.payload.response.GenreResponse;

public class GenreMapper {
    public static GenreResponse toResponse(Genre genre) {
        if (genre == null) {
            return null;
        }

        GenreResponse response = GenreResponse.builder()
                .id(genre.getId())
                .code(genre.getCode())
                .name(genre.getName())
                .description(genre.getDescription())
                .displayOrder(genre.getDisplayOrder())
                .active(genre.getActive())
                .createdDate(genre.getCreatedAt())
                .updatedDate(genre.getUpdatedAt())
                .build();

        // Thiết lập thông tin cha nếu có
        if (genre.getParentGenre() != null) {
            response.setParentGenreId(genre.getParentGenre().getId());
            response.setParentGenreName(genre.getParentGenre().getName());
        }

        // Đệ quy xử lý các thể loại con (Sub-genres)
        if (genre.getSubGenres() != null && !genre.getSubGenres().isEmpty()) {
            response.setSubGenres(genre.getSubGenres().stream()
                    .filter(Genre::getActive)
                    .map(GenreMapper::toResponse)
                    .toList());
        }

        //response.setBookCount((long) genre.get);

        return response;
    }

    public static Genre toEntity(CreateGenreRequest request) {
        if (request == null) {
            return null;
        }

        return Genre.builder()
                .code(request.getCode())
                .name(request.getName())
                .description(request.getDescription())
                .displayOrder(request.getDisplayOrder())
                .active(true)
                .build();
    }

//    public static void updateEntity(UpdateGenreRequest request, Genre existingGenre) {
//        if (request == null || existingGenre == null) {
//            return;
//        }
//
//        // Kiểm tra null trước khi gán để tránh ghi đè dữ liệu cũ bằng giá trị null
//        if (request.getName() != null) existingGenre.setName(request.getName());
//        if (request.getDescription() != null) existingGenre.setDescription(request.getDescription());
//        if (request.getDisplayOrder() != null) existingGenre.setDisplayOrder(request.getDisplayOrder());
//        if (request.getActive() != null) existingGenre.setActive(request.getActive());
//    }
}
