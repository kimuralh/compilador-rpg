public class CmdElse extends Comando{

	private String status;
	
	public CmdElse(){

		this.status = null;
	}

	public CmdElse(String status){
		this.status = "fim";
	}

	
		/*
	private String idVar;
	public String toJava(){
		return idVar + "="+Programa.INPUT+".nextInt();";
	}
	*/
	//precisamos pegar a condição de comparacao do if (algo) { conteudo} e o conteudo
	public String toJava(){
		if (this.status == ("fim")){
			return "} \n";
		}
		else {
			return "else { \n ";
		}
	}
}