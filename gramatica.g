class RPGParser extends Parser;
{
	java.util.HashMap<String, String> mapaVar  = new java.util.HashMap<String,String>();
	Tradutor t;
	String var;

	java.util.Stack<Expressao> expressoes = new java.util.Stack<Expressao>();
	
	 public void setTradutor(String name){
      t = new Tradutor(name);
    }
	
	public Tradutor getTradutor(){
       return t;
    }

	
}

prog	: 
		   "campaign" (declara)+ bloco
	;

declara : ("rune" T_Id {if(!mapaVar.containsKey(LT(0).getText())){
							mapaVar.put(LT(0).getText(), "rune");

							} 
						else{
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
							}
						}
			(T_virg T_Id{if(!mapaVar.containsKey(LT(0).getText())){
							mapaVar.put(LT(0).getText(), "rune");

							}
						else{
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
							}
						})* 
		| "scroll" T_Id {if(!mapaVar.containsKey(LT(0).getText())){
							mapaVar.put(LT(0).getText(), "scroll");

							}
						else{
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
							}
						} 
		(T_virg T_Id {if(!mapaVar.containsKey(LT(0).getText())){
							mapaVar.put(LT(0).getText(), "scroll");

							}
						else{
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
							}
						})*)T_pontoesc
						{
					
					t.setVariaveis(new java.util.HashMap<String,String>(mapaVar));
					System.out.println("Variable list assembled...");

		   }
	;

bloco	: (cmd)+ "endCampaign"
	;

cmd	: cmdLeia T_pontoesc
	| cmdEscreva T_pontoesc
	| cmdAttr {System.out.println(LT(0).getText());} T_pontoesc
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
					t.addComando(new CmdLeia(LT(0).getText(), mapaVar.get(LT(0).getText())));
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
					throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
					} 
					else
					{
						var = LT(0).getText();
					}
				}
			"takes" 
			
			expr
			{
				t.addComando(new CmdAttr(var, expressoes.pop()));
			}
			
	;
	
cmdIf	:	{CmdIf expressaoIf =  new CmdIf();}
			"rule" T_ap ((T_Id|T_num)
			{
				expressaoIf.setLeft(LT(0).getText());
			} 
			("dwarf"|"titan"|"half dwarf"|"half titan"|"alien"|"human")
			{
				expressaoIf.setOp(LT(0).getText());
			} 
			 (T_Id|T_num) 
			 {
			 	expressaoIf.setRight(LT(0).getText());
			 }) T_fp T_ac 
			{
				t.addComando(expressaoIf);
			}
				(cmd)+
				T_fc
				{
					CmdIf expressaoIfFim =  new CmdIf("fim");
					t.addComando(expressaoIfFim);
				}
				(cmdElse)?
		;

cmdElse :{CmdElse expressaoElse =  new CmdElse();}
  		"curse" T_ac 
  				{
					t.addComando(expressaoElse);
				} 
				(cmd)+
			T_fc
			{
				CmdElse expressaoElseFim =  new CmdElse("fim");
				t.addComando(expressaoElseFim);
			}
		;

cmdWhile : 		{CmdWhile expressaoWhile =  new CmdWhile();}
				"loop" T_ap ((T_Id|T_num)
				{
					expressaoWhile.setLeft(LT(0).getText());
				} 
				("dwarf"|"titan"|"half dwarf"|"half titan"|"alien"|"human") 
				{
					expressaoWhile.setOp(LT(0).getText());
				} 
					(T_Id|T_num)
				{
					expressaoWhile.setRight(LT(0).getText());
				}) T_fp T_ac
				{
				t.addComando(expressaoWhile);
				}
				(cmd)+
				T_fc{
					CmdWhile expressaoWhileFim =  new CmdWhile("fim");
					t.addComando(expressaoWhileFim);
				}
		;

cmdDoWhile :	{CmdDoWhile expressaoDoWhile =  new CmdDoWhile();
				CmdDoWhile expressaoDoWhileFim =  new CmdDoWhile("fim");
				} 
				"action" T_ac 
				{
					t.addComando(expressaoDoWhile);
				}
					(cmd)+
				T_fc "loop" T_ap ((T_Id|T_num)
				{
					expressaoDoWhileFim.setLeft(LT(0).getText());
				} 
					("dwarf"|"titan"|"half dwarf"|"half titan"|"alien"|"human") 
				{
					expressaoDoWhileFim.setOp(LT(0).getText());
				}
					(T_Id|T_num)
				{
					expressaoDoWhileFim.setRight(LT(0).getText());
				})
				
				T_fp{
					
					t.addComando(expressaoDoWhileFim);
				}
		;
		
expr	: {Expressao novo = new Expressao();} 
		termo {novo.addTermo(LT(0).getText()); } (( "heals" | "damages") {novo.addTermo(LT(0).getText());; }termo)*{novo.addTermo(LT(0).getText());}
		{expressoes.push(novo);}
	;

termo : fator(("hits"| "shares")fator)*
	;

fator 	: T_Id { if(!mapaVar.containsKey(LT(0).getText())){
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