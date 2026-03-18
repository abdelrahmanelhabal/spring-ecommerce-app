package com.adminPanel.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "product_details")
@Setter
@Getter
@ToString
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "price")
    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be > 0")
    private double price ;

    @Column(name = "manufacturer")
    @NotBlank(message = "Product manufacturer is required")
    private String manufacturer ;

    @Column(name = "availability")
    private boolean available ;

    @Column(name = "photo")
    private String photo ;

    @Column(name = "expiration_date")
    @NotNull(message = "Product expired date is required")
    @Future(message = "Expired date must be in future")
    @Temporal(TemporalType.DATE)
    private Date expiration_date ;

}
