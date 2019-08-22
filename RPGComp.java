public class RPGComp{
	public static void main(String args[]){
		try{
			if(args.length == 0){
				System.out.println("Use: java IsiComp [filename] < [source file].isi");
			}
			else {
			RPGLexer lexer = new RPGLexer(System.in);
			RPGParser parser = new RPGParser(lexer);
			
			System.out.println("Starting Adventure...");
			
			
			parser.setTradutor(args[0]);
			parser.prog();
			
			System.out.println("Adventure Finished With Success :)");
			parser.getTradutor().saveToFile();
			}
		}
		catch(Exception ex){
		System.err.println("You died :( Your big mistake was: "+ ex.getMessage());
		}
	}
}