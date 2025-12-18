package homework04.SuperMarketInventoryManagement;

import homework04.ProductSystem.Product;

import java.util.ArrayList;

public class Supermarket
{
    private ArrayList<Product> inventory;

    public Supermarket()
    {
        inventory = new ArrayList<>();
    }

    public ArrayList<Product> getInventory()
    {
        return this.inventory;
    }

    public void addProduct(Product p)
    {
        if (inventory == null)
        {
            inventory.add(p);
        } else
        {
            for (int i = 0; i < inventory.size(); i++)
            {
                Product selectedProduct = inventory.get(i);
                if (p.getName().equals(selectedProduct.getName()))
                {
                    inventory.get(i).addStock(p.getStockQuantity());
                    return;
                }
            }
            inventory.add(p);
        }
    }

    public void reduceStock(String name, int qty)
    {
        for (int i = 0; i < inventory.size(); i++)
        {
            Product selectedProduct = inventory.get(i);
            int currrentStock = selectedProduct.getStockQuantity();
            if (selectedProduct.getName().equals(name))
            {
                if (qty >= currrentStock)
                {
                    selectedProduct.setStockQuantity(0);
                    inventory.remove(i);
                } else
                {
                    selectedProduct.setStockQuantity(currrentStock - qty);
                }
            }
        }
    }

    public int getStock(String name)
    {
        for (int i = 0; i < inventory.size(); i++)
        {
            Product selectedProduct = inventory.get(i);
            int currentStock = selectedProduct.getStockQuantity();
            if (selectedProduct.getName().equals(name))
            {
                return currentStock;
            }
        }
        return 0;
    }

    public Product getProduct(String name)
    {
        for (int i = 0; i < inventory.size(); i++)
        {
            Product selectedProduct = inventory.get(i);
            if (selectedProduct.getName().equals(name))
            {
                return selectedProduct;
            }
        }
        return null;
    }

    public void showInventory()
    {
        int totalNumber = inventory.size();
        for (int i = 0; i < inventory.size(); i++)
        {
            Product selectedProduct = inventory.get(i);
            System.out.println(selectedProduct.toString());
        }
        System.out.println("Total products: " + totalNumber);
    }
}
