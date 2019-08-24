public class progtesteMedia{
    public static void main(String args[]){
      java.util.Scanner scan=new java.util.Scanner(System.in);
 Double a;
 Double b;
 Double c;
 Double media;
 Double soma;
System.out.println("Digite a nota da P1");

a=scan.nextDouble();
System.out.println("Digite a nota da P2");

b=scan.nextDouble();
System.out.println("Digite a nota da P3");

c=scan.nextDouble();
soma =  a + b + c;
media =  soma / 3;
System.out.println(media);

if (media >= 5) { 
 
System.out.println("Parabens voce esta aprovado");

}
else { 
 
System.out.println("reprovado");

} 

}}