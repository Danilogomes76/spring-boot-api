package com.example.apiJavaT.domain.product;


import lombok.Data;

import java.util.Optional;


@Data
public class ResponseMessage {

    private Optional<Product> data;
    private String message;

    public ResponseMessage(Optional<Product> data, String message){
        this.message = message;
        this.data = data;
    }
}
