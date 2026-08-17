package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.utility.OrderUtility;
import food.service.OrderService;

public class main {

    public static void main(String[] args) {

        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Harjeet", 500);
        orders[1] = new PremiumOrder(102, "Aman", 800);
        orders[2] = new RegularOrder(103, "Riya", 600);
        orders[3] = new PremiumOrder(104, "Simran", 1000);
        orders[4] = new RegularOrder(105, "Karan", 700);
        orders[5] = new PremiumOrder(106, "Neha", 1200);

        System.out.println("Restaurant: " + FoodOrder.restaurantName);
        System.out.println();

        for (FoodOrder order : orders) {

            if (OrderUtility.validateAmount(order.getAmount())
                    && OrderUtility.validateCustomerName(order.getCustomerName())) {

                OrderService.displayBill(order);

            } else {
                System.out.println("Invalid Order");
            }
        }

        FoodOrder.displayTotalOrders();
    }
}