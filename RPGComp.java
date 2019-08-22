public class RPGComp{
	public static void main(String args[]){
		try{
			RPGLexer lexer = new RPGLexer(System.in);
			RPGParser parser = new RPGParser(lexer);
			
			System.out.println("Starting Adventure...");
			
			parser.prog();
			
			System.out.println("Adventure Finished With Success :)");
			
		}
		catch(Exception ex){
		System.err.println("You died :( Your big mistake was: "+ ex.getMessage());
		}
	}
}