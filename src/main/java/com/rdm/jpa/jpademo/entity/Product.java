package com.rdm.jpa.jpademo.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="PRODUCT_TBL")
@Data
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name ;
    private int quantiy;
    private int price;
}
