package dev.manfertej.sherlock.model;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    Long id;
    String category;
    String name;
    String subtitle;
    String price;
    String discount_price;
    String main_image_url;
    String secondary_image_url;
    String nutritional_info;
    List<Long> embedding;
}
