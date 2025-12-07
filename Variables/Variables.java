/* 
In Java, there are different types of variables, for example:

String - stores text, such as "Hello". String values are surrounded by double quotes
int - stores integers (whole numbers), without decimals, such as 123 or -123
float - stores floating point numbers, with decimals, such as 19.99 or -19.99
char - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes
boolean - stores values with two states: true or false

*/

package Variables;

public class Variables{
    public static void main(String[] args){
        final int uid2= 54;
        System.out.println(uid2);
        String name = "Pranav";
        System.out.println(name);
        int uid = 23005054 ;
        System.out.println(uid);
        float percentage = 99.99f;
        System.out.println(percentage + "%");
        char first_alpha = 'P';
        System.err.println(first_alpha);
        boolean mybool = true ;
        System.out.println(mybool);
    }
}

/* If you don't want others (or yourself) to overwrite existing values, use the final keyword (this will declare the variable as "final" or "constant", which means unchangeable and read-only): */