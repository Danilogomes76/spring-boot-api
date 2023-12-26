package com.example.apiJavaT.controllers;




import com.example.apiJavaT.domain.product.Product;
import com.example.apiJavaT.domain.product.ProductRepository;
import com.example.apiJavaT.domain.product.RequestProduct;
import com.example.apiJavaT.domain.product.ResponseMessage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    //Autowired diz para o spring que quem deve fazer a injerção de dependencia é ele em tempo de execução.
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProdutcs(){
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity addNewPoduct(@RequestBody @Valid RequestProduct data){

        Product newProduct = new Product(data);
        repository.save(newProduct);


        ResponseMessage message = new ResponseMessage(Optional.of(newProduct), "Sucess to post Product");


        return ResponseEntity.status(201).body(message);
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data){

        Optional<Product> optionalProduct = repository.findById(data.id());

        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            repository.save(product);


            ResponseMessage message = new ResponseMessage(Optional.of(product), "Sucess To update Product");


            return ResponseEntity.ok(message);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id ){
        Optional<Product> toDeleteProduct = repository.findById(id);

        if (toDeleteProduct.isPresent()){

            repository.deleteById(id);

            ResponseMessage message = new ResponseMessage(toDeleteProduct, "Sucess To delete");

            return ResponseEntity.ok(message);
        }

        return ResponseEntity.notFound().build();
    }
}
