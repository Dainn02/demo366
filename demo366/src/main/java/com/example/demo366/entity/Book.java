package com.example.demo366.entity;

import com.example.demo366.validator.annotation.ValidCategoryId;
import com.example.demo366.validator.annotation.ValidUserId;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.Data;


@Data

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50)
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 50,min = 1,message = "Title must be less than 50 characters ")
    @NotNull(message = "Title must not be null")
    private String title;

    @Column(name = "author", length = 50)
    @Size(max = 50, message = "Author must be less than 50 characters")
    private String author;

    @Column(name = "price")
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be  greater than 0 ")
    private Double price;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ValidCategoryId
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id" )
    @ValidUserId
    private User user;

}
