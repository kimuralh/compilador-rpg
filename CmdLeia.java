public class CmdLeia extends Comando{
	private String idVar;
	
	public CmdLeia(String idVar){
		this.idVar = idVar;
	}
	
	public String toJava(){
		return idVar + "="+Tradutor.INPUT+".nextInt();";
	}
}