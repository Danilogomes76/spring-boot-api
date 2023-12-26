package com.example.apiJavaT.domain.product;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Record para saber o formato que o body ira vir, no caso com name, e price_in_cents
public record RequestProduct(

        String id,

        @NotBlank String name,

        @NotNull Integer price_in_cents
) {

}
