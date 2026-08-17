package food.service;

import food.model.FoodOrder;
import food.model.Discountable;

public class OrderService {

    public static void displayBill(FoodOrder order) {

        double amount = order.getAmount();
        double discount = ((Discountable) order).applyDiscount();
        double delivery = order.calculateDeliveryCharge();

        double finalAmount = amount - discount + delivery;

        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Bill Amount: Rs. " + amount);
        System.out.println("Discount: Rs. " + discount);
        System.out.println("Delivery Charge: Rs. " + delivery);
        System.out.println("Final Payable Amount: Rs. " + finalAmount);
        System.out.println("-----------------------------");
    }
}