package homework04.ProductSystem;

public class Product
{
    private String name;
    private int price;
    private int stockQuantity;
    private ProductType type;

    public Product(String name, int price, int stockQuantity, ProductType type)
    {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.type = type;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public void setStockQuantity(int stockQuantity)
    {
        this.stockQuantity = stockQuantity;
    }
    public void setType(ProductType type)
    {
        this.type = type;
    }

    public String getName()
    {
        return this.name;
    }
    public int getPrice()
    {
        return this.price;
    }
    public int getStockQuantity()
    {
        return this.stockQuantity;
    }
    public ProductType getType()
    {
        return this.type;
    }

    public String toString()
    {
        return this.type + " - " + this.name + ": $" + this.price + ", Stock: " + this.stockQuantity;
    }

    public void addStock(int qty)
    {
        this.stockQuantity += qty;
    }
    public void reduceStock(int qty)
    {
        if (qty >= stockQuantity)
        {
            stockQuantity = 0;
        } else
        {
            stockQuantity -= qty;
        }
    }
}
