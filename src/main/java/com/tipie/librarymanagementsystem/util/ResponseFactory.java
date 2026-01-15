package com.tipie.librarymanagementsystem.util;

import com.tipie.librarymanagementsystem.payload.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFactory {
    public static <T> ResponseEntity<ApiResponse<T>> ok(T data, String message) {
        return ResponseEntity.ok(ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(T data, String message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build()
        );
    }

    public static ResponseEntity<ApiResponse<Object>> error(String message, Object errors, HttpStatus status) {
        return ResponseEntity.status(status).body(ApiResponse.<Object>builder()
                .success(false)
                .message(message)
                .errors(errors)
                .build()
        );
    }
}
