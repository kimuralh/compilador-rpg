public class CmdIf extends Comando{
	private String op;
	private String left;
	private String right;
	private String status;
	
	public CmdIf(){
		this.op = null;
		this.left = null;
		this.right = null;
		this.status = null;
	}

	public CmdIf(String status){
		this.status = "fim";
	}

	public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
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
			return "}";
		}
		else {
			if (op != null){
				if(op.equals("human")){
					op = "==";
				}
				else if(op.equals("alien")){
					op = "!=";
				}
				else if(op.equals("titan")){
					op = ">";
				}
				else if(op.equals("dwarf")){
					op = "<";
				}
				else if(op.equals("halfTitan")){
					op = ">=";
				}
				else if(op.equals("halfDwarf")){
					op = "<=";
				}
				else{
					throw new RuntimeException("ERROR! Comparation '"+op+"' not supported");
				}
				
			}
			return "if (" +left+" "+op+" "+right+") { \n ";
		}
		//return "if (" + condicao + ") { \n "+ conteudo + "\n }";
	}
}