package homework04.ShoppingCartSystem;

import homework04.MembershipSystem.Member;
import homework04.ProductSystem.Product;
import homework04.SuperMarketInventoryManagement.Supermarket;

import java.util.ArrayList;

public class ShoppingCart
{
    private Member member;
    private Supermarket supermarket;
    private ArrayList<CartItem> items;

    public ShoppingCart(Member member, Supermarket supermarket)
    {
        this.member = member;
        this.supermarket = supermarket;
        this.items = new ArrayList<CartItem>();
    }

    public ArrayList<CartItem> getItems()
    {
        return items;
    }

    public void add(String productName, int qty)
    {
        ArrayList<Product> inventory = supermarket.getInventory();
        for (int i = 0; i < inventory.size(); i++)
        {
            Product inventoryProduct = inventory.get(i);
            String inventoryProductName = inventoryProduct.getName();
            int stock = inventoryProduct.getStockQuantity();
            if (inventoryProductName.equals(productName))
            {
                for (int j = 0; j < items.size(); j++)
                {
                    String itemName = items.get(j).getProduct().getName();
                    if (itemName.equals(productName))
                    {
                        int currentQuantity = items.get(j).getQuantity();
                        if (currentQuantity + qty <= stock)
                        {
                            items.get(j).addQuantity(qty);
                            return;
                        } else
                        {
                            return;
                        }
                    }
                }
                if (qty <= stock)
                {
                    CartItem cartItem = new CartItem(inventoryProduct, qty);
                    items.add(cartItem);
                }
            }
        }
    }

    public void show()
    {
        int totalAmount = 0;
        for (int i = 0; i < items.size(); i++)
        {
            CartItem selectedCartItem = items.get(i);
            System.out.println(selectedCartItem.toString());
            totalAmount += selectedCartItem.getSubtotal();
        }
        System.out.println("Total: $" + totalAmount);
    }

    public void checkout(boolean usePoints)
    {
        int rawTotal = 0;
        ArrayList<Product> inventory = supermarket.getInventory();
        for (int i = 0; i < items.size(); i++)
        {
            CartItem selectedCartItem = items.get(i);
            String cartItemName = selectedCartItem.getProduct().getName();
            rawTotal += selectedCartItem.getSubtotal();
            for (int j = 0; j < inventory.size(); j++)
            {
                String inventoryItemName = inventory.get(j).getName();
                if (cartItemName.equals(inventoryItemName))
                {
                    supermarket.reduceStock(inventoryItemName, selectedCartItem.getQuantity());
                }
            }
        }

        int maxSafeDeduction = 0;
        if (usePoints)
        {
            maxSafeDeduction = member.usePoints(rawTotal);
        }

        int finalTotal = rawTotal - maxSafeDeduction;
        member.addPoints(finalTotal);

        System.out.println("=== Checkout Receipt ===");
        show();
        System.out.println("Points used: $" + maxSafeDeduction + " (" + maxSafeDeduction + " points)");
        System.out.println("Final Total: $" + finalTotal);
        System.out.println("Points earned: " + finalTotal);
        System.out.println("===");

        int size = items.size();
        if (size > 0)
        {
            items.subList(0, size).clear();
        }
    }

    public void checkout()
    {
        int rawTotal = 0;
        ArrayList<Product> inventory = supermarket.getInventory();
        for (int i = 0; i < items.size(); i++)
        {
            CartItem selectedCartItem = items.get(i);
            String cartItemName = selectedCartItem.getProduct().getName();
            rawTotal += selectedCartItem.getSubtotal();
            for (int j = 0; j < inventory.size(); j++)
            {
                String inventoryItemName = inventory.get(j).getName();
                if (cartItemName.equals(inventoryItemName))
                {
                    supermarket.reduceStock(inventoryItemName, selectedCartItem.getQuantity());
                }
            }
        }

        boolean usePoints = false;
        int maxSafeDeduction = 0;
        if (usePoints)
        {
            maxSafeDeduction = member.usePoints(rawTotal);
        }

        int finalTotal = rawTotal - maxSafeDeduction;
        member.addPoints(finalTotal);

        System.out.println("=== Checkout Receipt ===");
        show();
        System.out.println("Points used: $" + maxSafeDeduction + " (" + maxSafeDeduction + " points)");
        System.out.println("Final Total: $" + finalTotal);
        System.out.println("Points earned: " + finalTotal);
        System.out.println("===");

        int size = items.size();
        if (size > 0)
        {
            items.subList(0, size).clear();
        }
    }
}
