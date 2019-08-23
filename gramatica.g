class RPGParser extends Parser;
{
	java.util.HashMap<String, String> mapaVar; 
	Tradutor t;
	
	 public void setTradutor(String name){
      t = new Tradutor(name);
    }
	
	public Tradutor getTradutor(){
       return t;
    }
	
}

prog	: { mapaVar = new java.util.HashMap<String,String>();
			
			}
		   "campaign" (declara)+ bloco
	;

declara : ("rune" T_Id {if(!mapaVar.containsKey(LT(0).getText())){
							mapaVar.put(LT(0).getText(), "rune");
												System.out.println(mapaVar.keySet());

							System.out.println(LT(0).getText() + " declarado");
							} 
						else{
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
							}
						}
			(T_virg T_Id{if(!mapaVar.containsKey(LT(0).getText())){
							mapaVar.put(LT(0).getText(), "rune");
												System.out.println(mapaVar.keySet());

							System.out.println(LT(0).getText() + " declarado");
							}
						else{
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
							}
						})* 
		| "scroll" T_Id {if(!mapaVar.containsKey(LT(0).getText())){
							mapaVar.put(LT(0).getText(), "scroll");
												System.out.println(mapaVar.keySet());

							System.out.println(LT(0).getText() + " declarado");
							}
						else{
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
							}
						} 
		(T_virg T_Id {if(!mapaVar.containsKey(LT(0).getText())){
							mapaVar.put(LT(0).getText(), "scroll");
												System.out.println(mapaVar.keySet());

							System.out.println(LT(0).getText() + " declarado");
							}
						else{
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
							}
						})*)T_pontoesc
						{
					t.setVariaveis(mapaVar);
					System.out.println("Variable list assembled...");
		   }
	;

bloco	: (cmd)+ "endCampaign"
	;

cmd	: cmdLeia T_pontoesc
	| cmdEscreva T_pontoesc
	| cmdAttr T_pontoesc
	| cmdIf 
	| cmdWhile 
	| cmdDoWhile 
	;

cmdLeia :	"equip" T_ap 
			T_Id { 
				if(!mapaVar.containsKey(LT(0).getText())){
					System.out.println(mapaVar.keySet());
				throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
					}
					t.addComando(new CmdLeia(LT(0).getText()));
				}
			T_fp
	;

cmdEscreva : "sing" T_ap (
						T_texto
						|T_Id { if(!mapaVar.containsKey(LT(0).getText())){
							System.out.println(mapaVar.keySet());
					throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
								}
							}
						) {t.addComando(new CmdEscreva(LT(0).getText()));
						}
						
						T_fp
					;

cmdAttr : 	T_Id { if(!mapaVar.containsKey(LT(0).getText())){
	System.out.println(mapaVar.keySet());
					throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
					} 
				}
			"takes" 
			expr
	;
	
cmdIf	:	"rule" T_ap (expr ("dwarf"|"titan"|"half dwarf"|"half titan"|"alien"|"human") expr) T_fp T_ac
				(cmd)+
				T_fc (cmdElse)?
		;

cmdElse :  "curse" T_ac
				(cmd)+
			T_fc
		;

cmdWhile : "loop" T_ap (expr ("dwarf"|"titan"|"half dwarf"|"half titan"|"alien"|"human") expr) T_fp T_ac
				(cmd)+
				T_fc
		;

cmdDoWhile : "action" T_ac 
				(cmd)+
			T_fc "loop" T_ap (expr ("dwarf"|"titan"|"half dwarf"|"half titan"|"alien"|"human") expr) T_fp
		;
		
expr	: termo(( "heals" | "damages")termo)*
	;

termo : fator(("hits"| "shares")fator)*
	;

fator 	: T_Id { if(mapaVar.containsKey(LT(0).getText())){
	System.out.println(mapaVar.keySet());
					throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
					}
				}
		| T_num 
		| T_ap expr T_fp
	;

class RPGLexer extends Lexer;
options{
	caseSensitive = true;
	k = 7;
}

T_ac: "turn";
	
T_fc: "endTurn"	;

T_Id	: ('a' .. 'z' | 'A' .. 'Z')('a'..'z'|'A'..'Z'|'0'..'9')*
	;

T_num : ('0') | (('1'..'9')+ ('.'('0'..'9')+)?)
	;


T_virg	: ','
	;

T_pontoesc: '!'
	;

T_ap	: '('
	;

T_fp	: ')'
	;
	


T_texto : '"'('a'..'z'|'0'..'9'|' '|'A'..'Z')+ '"'
	;

T_blank : (' ' | '\n'{newline();}| '\r' | '\t') {_ttype=Token.SKIP;} 
	;