package com.eclothing.clothing.programming;

public class YieldExample  {
    public static void main(String[] args) {
        String orderStatus = "FAILED";
        String message = getOrderMessage(orderStatus);
        System.out.println(message);
    }

    private static String getOrderMessage(String orderStatus) {
        return switch (orderStatus) {
            case "PLACED" -> "Your order has been placed successfully!";
            case "SHIPPED" -> "Your order is on the way 🚚";
            case "DELIVERED" -> {
                System.out.println("Updating delivery logs...");
                yield "Your order has been delivered 📦";
            }
            case "FAILED" -> {
                System.err.println("⚠ Payment failed. Logging issue...");
                yield "Order failed due to payment issues!";
            }
            default -> "Unknown order status!";
        };
    }
}
