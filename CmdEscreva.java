public class CmdEscreva extends Comando{
	private String  conteudo;
	
	public CmdEscreva(String conteudo){		
		this.conteudo = conteudo;
	}
	
	public String toJava(){
		return "System.out.println("+conteudo+");\n";
	}	
}