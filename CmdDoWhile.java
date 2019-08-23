
public class CmdDoWhile extends Comando{
	private String op;
	private String left;
	private String right;
	private String status;
	
	public CmdDoWhile(){
		this.op = null;
		this.left = null;
		this.right = null;
		this.status = null;
	}

	public CmdDoWhile(String status){
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
	
	@Override
	public String toJava() {
		if (this.status == ("fim")){
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
				else if(op.equals("half titan")){
					op = ">=";
				}
				else if(op.equals("half dwarf")){
					op = "<=";
				}
				else{
					throw new RuntimeException("ERROR! Comparation '"+op+"' not supported");
				}
				
			}
			return "} while(" +left+" "+op+" "+right+"); \n ";
		}
		else {
			
			return "do { \n ";
		}
	}
}
