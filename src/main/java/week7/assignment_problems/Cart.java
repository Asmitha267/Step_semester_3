package main.java.week7.assignment_problems;
// File name: Cart.java

public class Cart {
    private double[] prices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int maxSize) {
        this.cartId = cartId;
        prices = new double[maxSize];
        itemCount = 0;
    }

    public void addItem(double price) {
        if (price > 0 && itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Invalid price or cart is full");
        }
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}

