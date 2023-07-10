package com.wagner.cardapio.foods;

import com.wagner.cardapio.Models.LogModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "food")
@Entity(name = "food")
@NoArgsConstructor
@AllArgsConstructor
public class Food extends LogModel {

    private String title;

    @Column(name = "image", length = 2000)
    private String image;

    private Float price;

    public Food(FoodRequestDTO data){
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }
}
