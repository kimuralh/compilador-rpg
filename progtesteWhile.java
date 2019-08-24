public class progtesteWhile{
    public static void main(String args[]){
      java.util.Scanner scan=new java.util.Scanner(System.in);
 int a;
 int y;
 int b;
 int c;
System.out.println("digite um valor");

a=scan.nextInt();
System.out.println("digite uma potencia");

b=scan.nextInt();
c =  1;
y =  a;
while (c < b) { 
 
a =  a * y;
c =  c + 1;
}
System.out.println(a);

}}