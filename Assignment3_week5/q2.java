
public class q2 {
  public static void main(String[] args){
    try{
      
      try{
        int[] b = {1,2,3};
        System.out.println(b[5]);
      }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("inner :array index out of bounds");
      }
      int a = 10 /0 ;
    }catch(ArithmeticException e){
        System.out.println("outer :arithmetic exception ");

    }
  }
}
