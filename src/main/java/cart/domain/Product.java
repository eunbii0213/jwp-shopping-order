package cart.domain;

public class Product {
    private Long id;
    private String name;
    private int price;
    private String image;
    private boolean isDiscounted;
    private int discountRate;
    private int discountedPrice;

    public Product(String name, int price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Product(Long id, String name, int price, String image, boolean isDiscounted, int discountRate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.isDiscounted = isDiscounted;
        this.discountRate = discountRate;
        initDiscountedPrice(price, discountRate);
    }

    private void initDiscountedPrice(int price, int discountRate) {
        if(discountRate > 0){
            this.discountedPrice = calculateDiscountedPrice();
        }else{
            this.discountedPrice = price;
        }
    }

    public Product(String name, int price, String image, boolean isDiscounted, int discountRate) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.isDiscounted = isDiscounted;
        this.discountRate = discountRate;
        initDiscountedPrice(price, discountRate);
    }

    public int calculateDiscountedPrice(int memberDiscount) {
        if (getIsDiscounted()) {
            return (discountRate * price / 100 - price) * -1;
        } else {
            return (memberDiscount * price / 100 - price) * -1;
        }
    }

    public int calculateProductDiscountedPrice() {
        return (discountRate * price / 100 - price) * -1;
    }

    public int calculateProductDiscountAmount(){
        int discountedPrice = calculateProductDiscountedPrice();
        return price - discountedPrice;
    }

    public int calculateMemberDiscountedPrice(int memberDiscount) {
        if (!getIsDiscounted()) {
            return (memberDiscount * price / 100 - price) * -1;
        }
        return price;
    }

    public int calculateDiscountedPrice() {
        if (getIsDiscounted()) {
            return (discountRate * price / 100 - price) * -1;
        }
        return price;
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

    public String getImage() {
        return image;
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
}
