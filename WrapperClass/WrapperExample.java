package WrapperClass;

public class WrapperExample {
    public static void main(String[] args){
    int a = 10;
    System.out.println(" Primitive Variable : " +a);
    Integer object = a; 
    System.out.println(" Autoboxed Variable  = " + object );


    int value = object ;
    System.out.println(" Unboxed object : "+ value);
}
}