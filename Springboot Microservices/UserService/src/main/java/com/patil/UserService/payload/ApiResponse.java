package com.patil.UserService.payload;

import org.springframework.http.HttpStatus;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

//    // No-arg constructor
//    public ApiResponse() {
//    }
//
//    // All-arg constructor
//    public ApiResponse(String message, boolean success, HttpStatus status) {
//        this.message = message;
//        this.success = success;
//        this.status = status;
//    }
//
//    // Getter methods
//    public String getMessage() {
//        return message;
//    }
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public HttpStatus getStatus() {
//        return status;
//    }
//
//    // Setter methods
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public void setStatus(HttpStatus status) {
//        this.status = status;
//    }
//
//    // Builder pattern implementation
//    public static ApiResponseBuilder builder() {
//        return new ApiResponseBuilder();
//    }
//
//    public static class ApiResponseBuilder {
//        private String message;
//        private boolean success;
//        private HttpStatus status;
//
//        public ApiResponseBuilder message(String message) {
//            this.message = message;
//            return this;
//        }
//
//        public ApiResponseBuilder success(boolean success) {
//            this.success = success;
//            return this;
//        }
//
//        public ApiResponseBuilder status(HttpStatus status) {
//            this.status = status;
//            return this;
//        }
//
//        public ApiResponse build() {
//            return new ApiResponse(message, success, status);
//        }
//    }
}
