package io.github.rkeeves.sauce.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String id;
    private String name;
    private String desc;
    private Double price;
    private String imgUrl;
}
