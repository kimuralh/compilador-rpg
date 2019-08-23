public class CmdLeia extends Comando{
	private String idVar;
	
	public CmdLeia(String idVar, String type)
	{
		this.idVar = idVar;
		this.type = type;
	}
	
	public String toJava()
	{
		switch(this.type)
		{
			case "rune":
				return idVar + "="+Tradutor.INPUT+".nextInt();";

			case "scroll":
			return idVar + "="+Tradutor.INPUT+".nextDouble();";
			
			default:
				return null;
		}
	}
}