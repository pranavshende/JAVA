package ExceptionHandeling;

public class ExceptionExample {
    public static void main(String[] args){
    int a = 10;
    int b = 0;
    try{
    int result = a/b;
    System.out.println(result);
}
catch(ArithmeticException e){
System.out.println("Arithmetic Error ");
}
finally {
    System.out.println("Program finished  ");
}
}
}