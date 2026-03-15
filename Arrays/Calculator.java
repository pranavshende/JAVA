package Arrays;
import java.util.Scanner;

public class Calculator{
    public static void main(String[] args){
      Scanner input = new Scanner(System.in);
    
     calculatorOperations s = new calculatorOperations();
     s.array();
    }  
}

class calculatorOperations {
  
int [] array = new int[100000];
int flag=1;
void array(){
for (int i=0 ; i<100000 ; i++){
  array[i]=flag;
  flag++;
}
for (int i=0 ; i<100000 ; i++){
  System.out.println(array[i]);
}
}
}
