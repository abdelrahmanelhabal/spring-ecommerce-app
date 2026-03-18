DROP DATABASE IF EXISTS ProductDB ;

CREATE DATABASE ProductDB ;

USE ProductDB ;

CREATE TABLE product_details(
    id INT PRIMARY KEY AUTO_INCREMENT,
    expiration_date DATE NOT NULL ,
    manufacturer VARCHAR(255) NOT NULL ,
    price DOUBLE   NOT NULL ,
    availability BOOLEAN   ,
    photo VARCHAR(255)
);

CREATE TABLE product(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL ,
    product_details_id INT unique ,
    FOREIGN KEY (product_details_id) REFERENCES product_details(id)
);