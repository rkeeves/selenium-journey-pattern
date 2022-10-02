package io.github.rkeeves.sauce.data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Products {

    private static final Product BIKE = Product.builder()
            .id("0")
            .name("Sauce Labs Bike Light")
            .desc("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.")
            .price(9.99)
            .imgUrl("bike-light-1200x1500")
            .build();

    private static final Product TSHIRT = Product.builder()
            .id("1")
            .name("Sauce Labs Bolt T-Shirt")
            .desc("Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.")
            .price(15.99)
            .imgUrl("bolt-shirt-1200x1500")
            .build();

    private static final Product ONESIE = Product.builder()
            .id("2")
            .name("Sauce Labs Onesie")
            .desc("Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.")
            .price(7.99)
            .imgUrl("red-onesie-1200x1500")
            .build();

    private static final Product TAT_TSHIRT = Product.builder()
            .id("3")
            .name("Test.allTheThings() T-Shirt (Red)")
            .desc("This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.")
            .price(15.99)
            .imgUrl("red-tatt-1200x1500")
            .build();

    private static final Product BACKPACK = Product.builder()
            .id("4")
            .name("Sauce Labs Backpack")
            .desc("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.")
            .price(29.99)
            .imgUrl("sauce-backpack-1200x1500")
            .build();


    private static final Product JACKET = Product.builder()
            .id("5")
            .name("Sauce Labs Fleece Jacket")
            .desc("It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.")
            .price(49.99)
            .imgUrl("sauce-pullover-1200x1500")
            .build();

    private static final List<Product> PRODUCTS_NATURAL_ORDER = List.of(
            BIKE,
            TSHIRT,
            ONESIE,
            TAT_TSHIRT,
            BACKPACK,
            JACKET
    );

    private static final List<Product> PRODUCTS_A_TO_Z = PRODUCTS_NATURAL_ORDER.stream()
            .sorted(Comparator.comparing(Product::getName))
            .collect(Collectors.toList());

    private static final List<Product> PRODUCTS_Z_TO_A = PRODUCTS_NATURAL_ORDER.stream()
            .sorted(Comparator.comparing(Product::getName).reversed())
            .collect(Collectors.toList());

    private static final List<Product> PRODUCTS_LO_TO_HI = PRODUCTS_NATURAL_ORDER.stream()
            .sorted(Comparator.comparing(Product::getPrice))
            .collect(Collectors.toList());

    private static final List<Product> PRODUCTS_HI_TO_LO = PRODUCTS_NATURAL_ORDER.stream()
            .sorted(Comparator.comparing(Product::getPrice).reversed())
            .collect(Collectors.toList());

    public static List<Product> sorted(ProductSortKind productSortKind) {
        return switch (productSortKind) {
            case A_TO_Z -> PRODUCTS_A_TO_Z;
            case Z_TO_A -> PRODUCTS_Z_TO_A;
            case LO_TO_HI -> PRODUCTS_LO_TO_HI;
            case HI_TO_LO -> PRODUCTS_HI_TO_LO;
        };
    }
}
