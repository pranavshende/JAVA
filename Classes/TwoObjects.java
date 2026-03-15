package Classes;

class Student{
int roll;
String name;
}
public class TwoObjects{
public static void main(String[] args){
Student s1=new Student();
Student s2=new Student();
s1.roll=101;
s1.name="Rahul";
s2.roll=102;
s2.name="Aman";
System.out.println("Student 1");
System.out.println(s1.roll+" "+s1.name);
System.out.println("Student 2");
System.out.println(s2.roll+" "+s2.name);
}
}