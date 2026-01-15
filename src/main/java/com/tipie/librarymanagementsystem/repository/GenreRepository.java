package com.tipie.librarymanagementsystem.repository;

import com.tipie.librarymanagementsystem.modal.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
