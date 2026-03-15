package Classes;

class Student{
int roll;
String name;
static String college="SVPCET";
final String course="BTech";
Student(int r,String n){
roll=r;
name=n;
}
void display(){
System.out.println("Roll: "+roll);
System.out.println("Name: "+name);
System.out.println("College: "+college);
System.out.println("Course: "+course);
System.out.println();
}
}
public class Main{
public static void main(String[] args){
Student s1=new Student(101,"Pranav");
Student s2=new Student(102,"Rahul");
s1.display();
s2.display();
}
}