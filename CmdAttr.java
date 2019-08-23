import javax.print.attribute.standard.PrinterName;
import javax.print.event.PrintJobListener;

public class CmdAttr extends Comando
{
    String javaExpression;

	public CmdAttr(String var, Expressao exp) 
	{
        this.expression = exp;
        javaExpression = var + " = ";
	}

	@Override
	public String toJava() 
	{	
        for (String termo : this.expression.termos) 
        {
            termo = termo.trim();
            String newTermo;
            switch(termo)
            {
                case "heals":
                    newTermo = "+";
                    break;
                case "damages":
                    newTermo = "-";
                    break;
                case "hits":
                    newTermo = "*";
                    break;
                case "shares":
                    newTermo = "/";
                    break;
                default:
                    newTermo = termo;
                    break;
            }
            javaExpression += (" " + newTermo);
        }
        javaExpression += ";";
		return javaExpression;
	}

}
