package Classes;

class Calculator{
int add(int a,int b){
return a+b;
}
int add(int a,int b,int c){
return a+b+c;
}
void check(int result){
if(result%2==0){
System.out.println(result+" is Even");
}
else{
System.out.println(result+" is Odd");
}
}
}
class Main{
public static void main(String[] args){
Calculator obj=new Calculator();
int sum1=obj.add(10,20);
int sum2=obj.add(5,6,7);
obj.check(sum1);
obj.check(sum2);
}
}