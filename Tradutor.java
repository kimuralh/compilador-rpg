import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.File;

public class Tradutor{
	public static final String INPUT="scan";
    private String name;
	
	List<String>  variaveisInt;
	List<String>  variaveisDouble;
	List<Comando> comandos;
	
    public Tradutor(String name){
		this.name = name;
		comandos = new ArrayList<Comando>();
		variaveisInt = new ArrayList<String>();
		variaveisDouble = new ArrayList<String>();
	}
	
	public void setVariaveis(HashMap hmap)
	{
		Iterator it = hmap.entrySet().iterator();
    while (it.hasNext()) {
        HashMap.Entry pair = (HashMap.Entry)it.next();
				//System.out.println(pair.getKey() + " = " + pair.getValue());
				String varType = (String) pair.getValue();
				switch(varType)
				{
						case "rune":
							variaveisInt.add((String) pair.getKey());
							break;
						case "scroll":
							variaveisDouble.add((String) pair.getKey());
							break;
				}
				it.remove(); // avoids a ConcurrentModificationException
			}
	
	// public void setVariaveisDouble(Collection lista){
	// 	Iterator it = lista.iterator();
	// 	while (it.hasNext()){
	// 		variaveisDouble.add((String)it.next());
	//ss
	// 	}
		
	}
	public void addComando(Comando c){
		comandos.add(c);
	}

    public void saveToFile(){
		try{
			FileWriter f = new FileWriter(new File(name+".java"));
			f.write("public class "+name+"{\n");
			f.write("    public static void main(String args[]){\n");
			f.write("      java.util.Scanner "+INPUT+"=new java.util.Scanner(System.in);\n");
			System.out.println(" \n");
			if(variaveisDouble.size() == 0){
				for(int i=0; i<variaveisInt.size() ; i++){
					f.write(" int "+variaveisInt.get(i)+";\n");
				}
			}
			else{
				for(int i=0; i<variaveisInt.size()/2 ; i++){
					f.write(" int "+variaveisInt.get(i)+";\n");
				}
			}
			for(String s: variaveisDouble){
				f.write(" Double "+s+";\n");
			}
			for(Comando c: comandos){
				f.write(c.toJava()+"\n");
			}
			f.write("}");
			f.write("}");
			f.close();
		}
		catch(Exception ex){
			System.out.println("ERRO:"+ex.getMessage());
		}
	}		
	
}