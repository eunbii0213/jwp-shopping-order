package cart.domain;

import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private int price;
    private String imageUrl;
    private boolean isDiscounted;
    private int discountRate;
    private int discountedPrice;

    public Product(Long id, String name, int price, String imageUrl, boolean isDiscounted, int discountRate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.isDiscounted = isDiscounted;
        this.discountRate = discountRate;
        this.discountedPrice = calculateDiscountedPrice();
    }

    public Product(String name, int price, String imageUrl, boolean isDiscounted, int discountRate) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.isDiscounted = isDiscounted;
        this.discountRate = discountRate;
        this.discountedPrice = calculateDiscountedPrice();
    }

    public int calculateDiscountedPrice(int memberDiscount) {
        if (getIsDiscounted()) {
            return (discountRate * price / 100 - price) * -1;
        } else {
            return (memberDiscount * price / 100 - price) * -1;
        }
    }

    public int calculateDiscountedPrice() {
        if (getIsDiscounted()) {
            return ((discountRate * price / 100 - price) * -1);
        }
        return 0;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean getIsDiscounted() {
        return isDiscounted;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && isDiscounted == product.isDiscounted && discountRate == product.discountRate && Objects.equals(name, product.name) && Objects.equals(imageUrl, product.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, imageUrl, isDiscounted, discountRate);
    }
}
