package com.org.id.inventoryservice;

import com.org.id.inventoryservice.entities.Product;
import com.org.id.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(new Product(null,"cacao",10,5000));
            productRepository.save(new Product(null,"banane",110,1000));
            productRepository.save(new Product(null,"voiture",50,5000000));
            productRepository.save(new Product(null,"moto",100,500000));
            productRepository.findAll().forEach(System.out::println);
        };
    }

}
