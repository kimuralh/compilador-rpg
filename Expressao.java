import java.util.ArrayList;

public class Expressao
{
    public ArrayList<String> termos;

    public Expressao() 
    {
        termos = new ArrayList<String>();
    }

    public void addTermo(String termo)
    {
        termos.add(termo);
    }

    public void printTermo()
    {
        for (String termo : this.termos) {
            System.out.println(termo);
        }
    }


}
