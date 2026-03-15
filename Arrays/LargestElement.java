package Arrays;
import java.util.Scanner;

class LargestElement {
  public static void main(String[] args){
    System.out.println("Enter Size of array : ");
    Scanner input = new Scanner(System.in);
    int  n = input.nextInt();
    int[] array = new int[n];
    System.out.println("Enter array Elements : ");
    for(int i = 0 ; i<n ; i ++ ){
      array[i] = input.nextInt();
    }
    int flag=0;
    for(int i = 0 ; i<n ; i++){
      if (array[i] > flag){
        flag = array[i];
      }
    }
    System.out.println(" Largest Element In Array : "+ flag);
    input.close();
  }
}

