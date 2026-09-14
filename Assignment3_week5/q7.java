import java.util.*;

class ApplicationException extends Exception {
    ApplicationException(String msg) {
        super(msg);
    }
}

class ProductException extends ApplicationException {
    ProductException(String msg) {
        super(msg);
    }
}

class ProductNotFoundException extends ProductException {
    ProductNotFoundException(String msg) {
        super(msg);
    }
}

class OutOfStockException extends ProductException {
    OutOfStockException(String msg) {
        super(msg);
    }
}

class PaymentException extends ApplicationException {
    PaymentException(String msg) {
        super(msg);
    }
}

class InvalidPaymentException extends PaymentException {
    InvalidPaymentException(String msg) {
        super(msg);
    }
}

class InsufficientFundsException extends PaymentException {
    InsufficientFundsException(String msg) {
        super(msg);
    }
}

class OrderException extends ApplicationException {
    OrderException(String msg) {
        super(msg);
    }
}

class EmptyCartException extends OrderException {
    EmptyCartException(String msg) {
        super(msg);
    }
}

class ShoppingCart {
    HashMap<String, Integer> products = new HashMap<>();
    HashMap<String, Integer> stock = new HashMap<>();
    ArrayList<String> cart = new ArrayList<>();

    ShoppingCart() {
        products.put("Laptop", 50000);
        products.put("Phone", 30000);
        products.put("Headphones", 2000);

        stock.put("Laptop", 2);
        stock.put("Phone", 5);
        stock.put("Headphones", 0);
    }

    void searchProduct(String name) throws ProductNotFoundException {
        if (!products.containsKey(name)) {
            throw new ProductNotFoundException(
                "Product not found: " + name
            );
        }

        System.out.println(
            name + " found. Price = " + products.get(name)
        );
    }

    void addProduct(String name) throws ProductException {
        if (!products.containsKey(name)) {
            throw new ProductNotFoundException(
                "Product not found: " + name
            );
        }

        if (stock.get(name) <= 0) {
            throw new OutOfStockException(
                name + " is out of stock"
            );
        }

        cart.add(name);
        stock.put(name, stock.get(name) - 1);

        System.out.println(name + " added to cart");
    }

    void removeProduct(String name)
            throws OrderException, ProductNotFoundException {

        if (cart.isEmpty()) {
            throw new EmptyCartException("Cart is empty");
        }

        if (!cart.contains(name)) {
            throw new ProductNotFoundException(
                name + " is not present in cart"
            );
        }

        cart.remove(name);
        stock.put(name, stock.get(name) + 1);

        System.out.println(name + " removed from cart");
    }

    double getTotal() throws EmptyCartException {
        if (cart.isEmpty()) {
            throw new EmptyCartException("Cart is empty");
        }

        double total = 0;

        for (String item : cart) {
            total += products.get(item);
        }

        return total;
    }

    void makePayment(double amount)
            throws PaymentException, EmptyCartException {

        double total = getTotal();

        if (amount <= 0) {
            throw new InvalidPaymentException(
                "Invalid payment amount"
            );
        }

        if (amount < total) {
            throw new InsufficientFundsException(
                "Insufficient funds. Required = " + total
            );
        }

        System.out.println("Payment successful");
        System.out.println("Amount paid = " + amount);
        System.out.println("Change = " + (amount - total));

        cart.clear();
    }
}

public class q7 {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        try {
            cart.searchProduct("Laptop");

            cart.addProduct("Laptop");

            cart.addProduct("Phone");

            System.out.println("Total = " + cart.getTotal());

            cart.makePayment(80000);

        } catch (ProductNotFoundException e) {
            System.out.println("Product Error: " + e.getMessage());

        } catch (OutOfStockException e) {
            System.out.println("Stock Error: " + e.getMessage());

        } catch (InvalidPaymentException e) {
            System.out.println("Payment Error: " + e.getMessage());

        } catch (InsufficientFundsException e) {
            System.out.println("Payment Error: " + e.getMessage());

        } catch (EmptyCartException e) {
            System.out.println("Order Error: " + e.getMessage());

        } catch (ApplicationException e) {
            System.out.println("Application Error: " + e.getMessage());
        }
    }
}