// $ANTLR 2.7.6 (2005-12-22): "gramatica.g" -> "RPGParser.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class RPGParser extends antlr.LLkParser       implements RPGParserTokenTypes
 {

	java.util.HashMap<String, String> mapaVar  = new java.util.HashMap<String,String>();
	Tradutor t;
	String var;
	Expressao novo;

	java.util.Stack<Expressao> expressoes = new java.util.Stack<Expressao>();
	
	 public void setTradutor(String name){
      t = new Tradutor(name);
    }
	
	public Tradutor getTradutor(){
       return t;
    }

	

protected RPGParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public RPGParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected RPGParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public RPGParser(TokenStream lexer) {
  this(lexer,1);
}

public RPGParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void prog() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_campaign);
			{
			int _cnt3=0;
			_loop3:
			do {
				if ((LA(1)==LITERAL_rune||LA(1)==LITERAL_scroll)) {
					declara();
				}
				else {
					if ( _cnt3>=1 ) { break _loop3; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt3++;
			} while (true);
			}
			bloco();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void declara() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_rune:
			{
				match(LITERAL_rune);
				match(T_Id);
				if(!mapaVar.containsKey(LT(0).getText())){
											mapaVar.put(LT(0).getText(), "rune");
				
											} 
										else{
												throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
											}
										
				{
				_loop7:
				do {
					if ((LA(1)==T_virg)) {
						match(T_virg);
						match(T_Id);
						if(!mapaVar.containsKey(LT(0).getText())){
													mapaVar.put(LT(0).getText(), "rune");
						
													}
												else{
														throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
													}
												
					}
					else {
						break _loop7;
					}
					
				} while (true);
				}
				break;
			}
			case LITERAL_scroll:
			{
				match(LITERAL_scroll);
				match(T_Id);
				if(!mapaVar.containsKey(LT(0).getText())){
											mapaVar.put(LT(0).getText(), "scroll");
				
											}
										else{
												throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
											}
										
				{
				_loop9:
				do {
					if ((LA(1)==T_virg)) {
						match(T_virg);
						match(T_Id);
						if(!mapaVar.containsKey(LT(0).getText())){
													mapaVar.put(LT(0).getText(), "scroll");
						
													}
												else{
														throw new RuntimeException("ERROR ID "+LT(0).getText()+" ja foi declarado!!");
													}
												
					}
					else {
						break _loop9;
					}
					
				} while (true);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(T_pontoesc);
			
								
								t.setVariaveis(new java.util.HashMap<String,String>(mapaVar));
								System.out.println("Variable list assembled...");
			
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final void bloco() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			int _cnt12=0;
			_loop12:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt12>=1 ) { break _loop12; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt12++;
			} while (true);
			}
			match(LITERAL_endCampaign);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void cmd() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_equip:
			{
				cmdLeia();
				match(T_pontoesc);
				break;
			}
			case LITERAL_sing:
			{
				cmdEscreva();
				match(T_pontoesc);
				break;
			}
			case T_Id:
			{
				cmdAttr();
				match(T_pontoesc);
				break;
			}
			case LITERAL_rule:
			{
				cmdIf();
				break;
			}
			case LITERAL_loop:
			{
				cmdWhile();
				break;
			}
			case LITERAL_action:
			{
				cmdDoWhile();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmdLeia() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_equip);
			match(T_ap);
			match(T_Id);
			
							if(!mapaVar.containsKey(LT(0).getText())){
							throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
								}
								t.addComando(new CmdLeia(LT(0).getText(), mapaVar.get(LT(0).getText())));
							
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void cmdEscreva() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_sing);
			match(T_ap);
			{
			switch ( LA(1)) {
			case T_texto:
			{
				match(T_texto);
				break;
			}
			case T_Id:
			{
				match(T_Id);
				if(!mapaVar.containsKey(LT(0).getText())){
											
									throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
												}
											
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			t.addComando(new CmdEscreva(LT(0).getText()));
									
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void cmdAttr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			novo = new Expressao();
			match(T_Id);
			if(!mapaVar.containsKey(LT(0).getText())){
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
								} 
								else
								{
									var = LT(0).getText();
								}
							
			match(LITERAL_takes);
			expr();
			
							t.addComando(new CmdAttr(var, expressoes.pop()));
						
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void cmdIf() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			CmdIf expressaoIf =  new CmdIf();
			match(LITERAL_rule);
			match(T_ap);
			{
			{
			switch ( LA(1)) {
			case T_Id:
			{
				match(T_Id);
				break;
			}
			case T_num:
			{
				match(T_num);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
							expressaoIf.setLeft(LT(0).getText());
						
			{
			switch ( LA(1)) {
			case LITERAL_dwarf:
			{
				match(LITERAL_dwarf);
				break;
			}
			case LITERAL_titan:
			{
				match(LITERAL_titan);
				break;
			}
			case LITERAL_halfDwarf:
			{
				match(LITERAL_halfDwarf);
				break;
			}
			case LITERAL_halfTitan:
			{
				match(LITERAL_halfTitan);
				break;
			}
			case LITERAL_alien:
			{
				match(LITERAL_alien);
				break;
			}
			case LITERAL_human:
			{
				match(LITERAL_human);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
							expressaoIf.setOp(LT(0).getText());
						
			{
			switch ( LA(1)) {
			case T_Id:
			{
				match(T_Id);
				break;
			}
			case T_num:
			{
				match(T_num);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
						 	expressaoIf.setRight(LT(0).getText());
						
			}
			match(T_fp);
			match(T_ac);
			
							t.addComando(expressaoIf);
						
			{
			int _cnt24=0;
			_loop24:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt24>=1 ) { break _loop24; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt24++;
			} while (true);
			}
			match(T_fc);
			
								CmdIf expressaoIfFim =  new CmdIf("fim");
								t.addComando(expressaoIfFim);
							
			{
			switch ( LA(1)) {
			case LITERAL_curse:
			{
				cmdElse();
				break;
			}
			case T_Id:
			case LITERAL_endCampaign:
			case LITERAL_equip:
			case LITERAL_sing:
			case LITERAL_rule:
			case T_fc:
			case LITERAL_loop:
			case LITERAL_action:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmdWhile() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			CmdWhile expressaoWhile =  new CmdWhile();
			match(LITERAL_loop);
			match(T_ap);
			{
			{
			switch ( LA(1)) {
			case T_Id:
			{
				match(T_Id);
				break;
			}
			case T_num:
			{
				match(T_num);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
								expressaoWhile.setLeft(LT(0).getText());
							
			{
			switch ( LA(1)) {
			case LITERAL_dwarf:
			{
				match(LITERAL_dwarf);
				break;
			}
			case LITERAL_titan:
			{
				match(LITERAL_titan);
				break;
			}
			case 29:
			{
				match(29);
				break;
			}
			case 30:
			{
				match(30);
				break;
			}
			case LITERAL_alien:
			{
				match(LITERAL_alien);
				break;
			}
			case LITERAL_human:
			{
				match(LITERAL_human);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
								expressaoWhile.setOp(LT(0).getText());
							
			{
			switch ( LA(1)) {
			case T_Id:
			{
				match(T_Id);
				break;
			}
			case T_num:
			{
				match(T_num);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
								expressaoWhile.setRight(LT(0).getText());
							
			}
			match(T_fp);
			match(T_ac);
			
							t.addComando(expressaoWhile);
							
			{
			int _cnt35=0;
			_loop35:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt35>=1 ) { break _loop35; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt35++;
			} while (true);
			}
			match(T_fc);
			
								CmdWhile expressaoWhileFim =  new CmdWhile("fim");
								t.addComando(expressaoWhileFim);
							
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmdDoWhile() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			CmdDoWhile expressaoDoWhile =  new CmdDoWhile();
							CmdDoWhile expressaoDoWhileFim =  new CmdDoWhile("fim");
							
			match(LITERAL_action);
			match(T_ac);
			
								t.addComando(expressaoDoWhile);
							
			{
			int _cnt38=0;
			_loop38:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt38>=1 ) { break _loop38; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt38++;
			} while (true);
			}
			match(T_fc);
			match(LITERAL_loop);
			match(T_ap);
			{
			{
			switch ( LA(1)) {
			case T_Id:
			{
				match(T_Id);
				break;
			}
			case T_num:
			{
				match(T_num);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
								expressaoDoWhileFim.setLeft(LT(0).getText());
							
			{
			switch ( LA(1)) {
			case LITERAL_dwarf:
			{
				match(LITERAL_dwarf);
				break;
			}
			case LITERAL_titan:
			{
				match(LITERAL_titan);
				break;
			}
			case 29:
			{
				match(29);
				break;
			}
			case 30:
			{
				match(30);
				break;
			}
			case LITERAL_alien:
			{
				match(LITERAL_alien);
				break;
			}
			case LITERAL_human:
			{
				match(LITERAL_human);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
								expressaoDoWhileFim.setOp(LT(0).getText());
							
			{
			switch ( LA(1)) {
			case T_Id:
			{
				match(T_Id);
				break;
			}
			case T_num:
			{
				match(T_num);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
								expressaoDoWhileFim.setRight(LT(0).getText());
							
			}
			match(T_fp);
			
								
								t.addComando(expressaoDoWhileFim);
							
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			termo();
			{
			_loop46:
			do {
				if ((LA(1)==LITERAL_heals||LA(1)==LITERAL_damages)) {
					{
					switch ( LA(1)) {
					case LITERAL_heals:
					{
						match(LITERAL_heals);
						break;
					}
					case LITERAL_damages:
					{
						match(LITERAL_damages);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					novo.addTermo(LT(0).getText());
					termo();
				}
				else {
					break _loop46;
				}
				
			} while (true);
			}
			expressoes.push(novo);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
	}
	
	public final void cmdElse() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			CmdElse expressaoElse =  new CmdElse();
			match(LITERAL_curse);
			match(T_ac);
			
								t.addComando(expressaoElse);
							
			{
			int _cnt28=0;
			_loop28:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt28>=1 ) { break _loop28; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt28++;
			} while (true);
			}
			match(T_fc);
			
							CmdElse expressaoElseFim =  new CmdElse("fim");
							t.addComando(expressaoElseFim);
						
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void termo() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			fator();
			{
			_loop50:
			do {
				if ((LA(1)==LITERAL_hits||LA(1)==LITERAL_shares)) {
					{
					switch ( LA(1)) {
					case LITERAL_hits:
					{
						match(LITERAL_hits);
						break;
					}
					case LITERAL_shares:
					{
						match(LITERAL_shares);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					novo.addTermo(LT(0).getText());
					fator();
				}
				else {
					break _loop50;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_6);
		}
	}
	
	public final void fator() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case T_Id:
			{
				match(T_Id);
				if(!mapaVar.containsKey(LT(0).getText())){
									throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
									}
									else
									{
										{novo.addTermo(LT(0).getText());}
									}
								
				break;
			}
			case T_num:
			{
				match(T_num);
				novo.addTermo(LT(0).getText());
				break;
			}
			case T_ap:
			{
				match(T_ap);
				expr();
				match(T_fp);
				novo.addTermo(LT(0).getText());
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"campaign\"",
		"\"rune\"",
		"T_Id",
		"T_virg",
		"\"scroll\"",
		"T_pontoesc",
		"\"endCampaign\"",
		"\"equip\"",
		"T_ap",
		"T_fp",
		"\"sing\"",
		"T_texto",
		"\"takes\"",
		"\"rule\"",
		"T_num",
		"\"dwarf\"",
		"\"titan\"",
		"\"halfDwarf\"",
		"\"halfTitan\"",
		"\"alien\"",
		"\"human\"",
		"T_ac",
		"T_fc",
		"\"curse\"",
		"\"loop\"",
		"\"half dwarf\"",
		"\"half titan\"",
		"\"action\"",
		"\"heals\"",
		"\"damages\"",
		"\"hits\"",
		"\"shares\"",
		"T_blank"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 2416068960L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 2416068672L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 2483178560L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 512L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 8704L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 12884910592L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 64424518144L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	
	}
