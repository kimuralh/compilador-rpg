public class progtesteDo{
    public static void main(String args[]){
      java.util.Scanner scan=new java.util.Scanner(System.in);
 int a;
 int b;
System.out.println("digite um valor");

a=scan.nextInt();
b =  11 + a;
do { 
 
System.out.println(a);

a =  a + 1;
} while(a < b); 
 
}}