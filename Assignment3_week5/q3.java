
import java.util.Scanner;
public class q3 {
    public static void main(String[] args) {
      try{  int a , b ;
     System.out.println("Enter two numbers");
     Scanner sc= new Scanner(System.in);
     a = sc.nextInt();
     b = sc.nextInt() ;
     System.out.println("Enter the operator ");
     sc.nextLine();
     String op = sc.nextLine();
     

      switch (op) {
        case "+":
            System.out.println(a+b);
            break;
        case "-":
            System.out.println(a-b);
            break ;
        case "*":
            System.out.println(a*b);
            break ;

        case "/":
            if(b==0){
                throw new ArithmeticException("Division by Zero");
            }
            System.out.println(a/b);
            break ;
        default:
            throw new IllegalArgumentException("Operator not found");
            
      }
    }catch(NumberFormatException e){
        System.out.println(e.getMessage());
    }
    catch(ArithmeticException e){
        System.out.println(e.getMessage());
    }
    catch(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
      
    }
     

}
