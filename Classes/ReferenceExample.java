package Classes;

class  ReferenceVariable{
int number;
}
public class ReferenceExample{
public static void main(String[] args){
 ReferenceVariable obj1=new ReferenceVariable();
obj1.number=50;
ReferenceVariable obj2=obj1;
System.out.println("Value from obj1: "+obj1.number);
System.out.println("Value from obj2: "+obj2.number);
}
}