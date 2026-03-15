package Vector;

import java.util.Vector;
public class VectorOperations{
  public static void main(String[] args){
    Vector<Integer> v = new Vector<Integer>();
    v.add(100);
    v.add(200);
    v.add(300);
    v.add(400);
    v.add(500);
    System.out.println(" Vector : "+v);
    System.out.println(" Vector Size : "+v.size());
    v.remove(4);
    System.out.println(" Vector : "+v);
    System.out.println(" Vector Size : "+v.size());
  }
}