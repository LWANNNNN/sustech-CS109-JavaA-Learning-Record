package homework04.ShoppingCartSystem;

import homework04.ProductSystem.Product;

public class CartItem
{
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct()
    {
        return this.product;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public int getSubtotal()
    {
        return this.product.getPrice() * quantity;
    }

    public String toString()
    {
        String name = product.getName();
        int price = product.getPrice();
        int subtotal = this.getSubtotal();

        return name + " x" + quantity + " - $" + price + "/ea = $" + subtotal;
    }

    public void addQuantity(int qty)
    {
        int currentQuantity = this.getQuantity();
        int stock = this.product.getStockQuantity();
        if (currentQuantity + qty >= stock)
        {
            quantity = stock;
        } else
        {
            quantity += qty;
        }
    }

    public void reduceQuantity(int qty)
    {
        int currentQuantity = this.getQuantity();
        if (currentQuantity <= qty)
        {
            quantity = 0;
        } else
        {
            quantity -= qty;
        }
    }
}
