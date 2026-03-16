package com.adminPanel.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_details")
@Setter
@Getter
@ToString
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @Column(name = "price")
    private double price ;

    @Column(name = "manufacturer")
    private String manufacturer ;

    @Column(name = "availability")
    private boolean available ;

    @Column(name = "photo")
    private String photo ;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expiration_date ;

}
