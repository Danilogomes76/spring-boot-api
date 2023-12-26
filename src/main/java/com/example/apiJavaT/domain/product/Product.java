package com.example.apiJavaT.domain.product;

import jakarta.persistence.*;
import lombok.*;


//Representação da nossa tabela.
@Table(name = "products") //Nome da Tabela no DB
@Entity(name = "products") //Entidade da tabela do DB
@Getter // Lombok colocando Getters e Setters, para não precissarmos criar métodos para isso.
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price_in_cents;



    //Criado a mão um método para settar o requestProduct(data)
    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
    }
}
