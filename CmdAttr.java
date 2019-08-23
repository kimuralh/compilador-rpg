import javax.print.attribute.standard.PrinterName;
import javax.print.event.PrintJobListener;

public class CmdAttr extends Comando
{
	private String idVar;

	public CmdAttr(String idVar, String type, String value) 
	{
		this.idVar = idVar;
		this.type = type;
		this.value = value;
	}

	@Override
	public String toJava() 
	{	
//		System.out.println(this.value);
//		switch(this.type)
//		{
//			case "rune":
//				return "int " + idVar + "="+ value.toString();
//
//			case "scroll":
//			return "double " + idVar + "="+ value.toString();
//			
//			default:
//				throw new RuntimeException("Type " + this.type + " couldn't be recognized!");
//		}
		return null;
	}

}
