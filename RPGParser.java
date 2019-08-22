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

	java.util.HashMap<String, String> mapaVar; 
	
	public void initParser(){
		mapaVar = new java.util.HashMap<String,String>();
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
			initParser();
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
				if(mapaVar.get(LT(0).getText()) == null){
											mapaVar.put(LT(0).getText(),LT(0).getText());
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
						if(mapaVar.get(LT(0).getText()) == null){
													mapaVar.put(LT(0).getText(),LT(0).getText());
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
				if(mapaVar.get(LT(0).getText()) == null){
											mapaVar.put(LT(0).getText(),LT(0).getText());
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
						if(mapaVar.get(LT(0).getText()) == null){
													mapaVar.put(LT(0).getText(),LT(0).getText());
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
			match(LITERAL_endcampaign);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void cmd() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_take:
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
			case LITERAL_dungeon:
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
			match(LITERAL_take);
			match(T_ap);
			match(T_Id);
			if(mapaVar.get(LT(0).getText()) == null){
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
								}
							
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
				if(mapaVar.get(LT(0).getText()) == null){
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
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void cmdAttr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_Id);
			if(mapaVar.get(LT(0).getText()) == null){
								throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
								} 
							
			match(LITERAL_takes);
			expr();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void cmdIf() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_rule);
			match(T_ap);
			{
			expr();
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
			case 20:
			{
				match(20);
				break;
			}
			case 21:
			{
				match(21);
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
			expr();
			}
			match(T_fp);
			match(T_ac);
			{
			int _cnt22=0;
			_loop22:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt22>=1 ) { break _loop22; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt22++;
			} while (true);
			}
			match(T_fc);
			{
			switch ( LA(1)) {
			case LITERAL_curse:
			{
				cmdElse();
				break;
			}
			case T_Id:
			case LITERAL_endcampaign:
			case LITERAL_take:
			case LITERAL_sing:
			case LITERAL_rule:
			case T_fc:
			case LITERAL_dungeon:
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
			match(LITERAL_dungeon);
			match(T_ap);
			{
			expr();
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
			case 20:
			{
				match(20);
				break;
			}
			case 21:
			{
				match(21);
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
			expr();
			}
			match(T_fp);
			match(T_ac);
			{
			int _cnt31=0;
			_loop31:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt31>=1 ) { break _loop31; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt31++;
			} while (true);
			}
			match(T_fc);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmdDoWhile() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_action);
			match(T_ac);
			{
			int _cnt34=0;
			_loop34:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt34>=1 ) { break _loop34; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt34++;
			} while (true);
			}
			match(T_fc);
			match(LITERAL_dungeon);
			match(T_ap);
			{
			expr();
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
			case 20:
			{
				match(20);
				break;
			}
			case 21:
			{
				match(21);
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
			expr();
			}
			match(T_fp);
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
			_loop40:
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
					termo();
				}
				else {
					break _loop40;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
	}
	
	public final void cmdElse() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_curse);
			match(T_ac);
			{
			int _cnt26=0;
			_loop26:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt26>=1 ) { break _loop26; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt26++;
			} while (true);
			}
			match(T_fc);
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
			_loop44:
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
					fator();
				}
				else {
					break _loop44;
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
				if(mapaVar.get(LT(0).getText()) == null){
									throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!!");
									}
								
				break;
			}
			case T_num:
			{
				match(T_num);
				break;
			}
			case T_ap:
			{
				match(T_ap);
				expr();
				match(T_fp);
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
		"\"endcampaign\"",
		"\"take\"",
		"T_ap",
		"T_fp",
		"\"sing\"",
		"T_texto",
		"\"takes\"",
		"\"rule\"",
		"\"dwarf\"",
		"\"titan\"",
		"\"half dwarf\"",
		"\"half titan\"",
		"\"alien\"",
		"\"human\"",
		"T_ac",
		"T_fc",
		"\"curse\"",
		"\"dungeon\"",
		"\"action\"",
		"\"heals\"",
		"\"damages\"",
		"\"hits\"",
		"\"shares\"",
		"T_num",
		"T_blank"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 402803040L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 402802752L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 436358208L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 512L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 16523776L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 1627136512L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 8069587456L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	
	}
