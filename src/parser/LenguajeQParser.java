// Generated from D:/UCLV/Compiladores/Old/LenguajeQ/src/grammars\LenguajeQ.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LenguajeQParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TK_BEGIN=13, TK_END=14, TK_PRINT=15, TK_PRINTLN=16, 
		TK_READ=17, TK_TIPO_INT=18, TK_TIPO_FLOAT=19, TK_TIPO_STRING=20, TK_IF=21, 
		TK_ELSE=22, TK_TIMES=23, TK_MEAN=24, TK_CTE_INT=25, TK_CTE_HEX=26, TK_CTE_FLOAT=27, 
		TK_CTE_STRING=28, TK_ID=29, LINE_COMMENT=30, COMMENT=31, WS=32;
	public static final int
		RULE_start = 0, RULE_dcl = 1, RULE_sent = 2, RULE_sentVarLocalDec = 3, 
		RULE_sentAsig = 4, RULE_sentEntrada = 5, RULE_sentSalida = 6, RULE_sentIf = 7, 
		RULE_bloque = 8, RULE_sentTimes = 9, RULE_sentMean = 10, RULE_exp = 11, 
		RULE_constante = 12, RULE_tipo = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "dcl", "sent", "sentVarLocalDec", "sentAsig", "sentEntrada", 
			"sentSalida", "sentIf", "bloque", "sentTimes", "sentMean", "exp", "constante", 
			"tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'('", "')'", "','", "'{'", "'}'", "'+'", "'-'", 
			"'!'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TK_BEGIN", "TK_END", "TK_PRINT", "TK_PRINTLN", "TK_READ", "TK_TIPO_INT", 
			"TK_TIPO_FLOAT", "TK_TIPO_STRING", "TK_IF", "TK_ELSE", "TK_TIMES", "TK_MEAN", 
			"TK_CTE_INT", "TK_CTE_HEX", "TK_CTE_FLOAT", "TK_CTE_STRING", "TK_ID", 
			"LINE_COMMENT", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LenguajeQ.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LenguajeQParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode TK_BEGIN() { return getToken(LenguajeQParser.TK_BEGIN, 0); }
		public TerminalNode TK_END() { return getToken(LenguajeQParser.TK_END, 0); }
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public List<SentContext> sent() {
			return getRuleContexts(SentContext.class);
		}
		public SentContext sent(int i) {
			return getRuleContext(SentContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0)) {
				{
				{
				setState(28);
				dcl();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(TK_BEGIN);
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				sent();
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549421120L) != 0) );
			setState(40);
			match(TK_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DclContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode TK_ID() { return getToken(LenguajeQParser.TK_ID, 0); }
		public ConstanteContext constante() {
			return getRuleContext(ConstanteContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			tipo();
			setState(43);
			match(TK_ID);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(44);
				match(T__0);
				setState(45);
				constante();
				}
			}

			setState(48);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentContext extends ParserRuleContext {
		public SentVarLocalDecContext sentVarLocalDec() {
			return getRuleContext(SentVarLocalDecContext.class,0);
		}
		public SentAsigContext sentAsig() {
			return getRuleContext(SentAsigContext.class,0);
		}
		public SentSalidaContext sentSalida() {
			return getRuleContext(SentSalidaContext.class,0);
		}
		public SentEntradaContext sentEntrada() {
			return getRuleContext(SentEntradaContext.class,0);
		}
		public SentIfContext sentIf() {
			return getRuleContext(SentIfContext.class,0);
		}
		public SentTimesContext sentTimes() {
			return getRuleContext(SentTimesContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterSent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitSent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitSent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentContext sent() throws RecognitionException {
		SentContext _localctx = new SentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sent);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TK_TIPO_INT:
			case TK_TIPO_FLOAT:
			case TK_TIPO_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				sentVarLocalDec();
				}
				break;
			case TK_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				sentAsig();
				}
				break;
			case TK_PRINT:
			case TK_PRINTLN:
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				sentSalida();
				}
				break;
			case TK_READ:
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				sentEntrada();
				}
				break;
			case TK_IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(54);
				sentIf();
				}
				break;
			case TK_TIMES:
				enterOuterAlt(_localctx, 6);
				{
				setState(55);
				sentTimes();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 7);
				{
				setState(56);
				bloque();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentVarLocalDecContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode TK_ID() { return getToken(LenguajeQParser.TK_ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SentVarLocalDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentVarLocalDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterSentVarLocalDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitSentVarLocalDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitSentVarLocalDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentVarLocalDecContext sentVarLocalDec() throws RecognitionException {
		SentVarLocalDecContext _localctx = new SentVarLocalDecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sentVarLocalDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			tipo();
			setState(60);
			match(TK_ID);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(61);
				match(T__0);
				setState(62);
				exp(0);
				}
			}

			setState(65);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentAsigContext extends ParserRuleContext {
		public TerminalNode TK_ID() { return getToken(LenguajeQParser.TK_ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SentAsigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentAsig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterSentAsig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitSentAsig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitSentAsig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentAsigContext sentAsig() throws RecognitionException {
		SentAsigContext _localctx = new SentAsigContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sentAsig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(TK_ID);
			setState(68);
			match(T__0);
			setState(69);
			exp(0);
			setState(70);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentEntradaContext extends ParserRuleContext {
		public TerminalNode TK_READ() { return getToken(LenguajeQParser.TK_READ, 0); }
		public TerminalNode TK_ID() { return getToken(LenguajeQParser.TK_ID, 0); }
		public SentEntradaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentEntrada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterSentEntrada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitSentEntrada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitSentEntrada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentEntradaContext sentEntrada() throws RecognitionException {
		SentEntradaContext _localctx = new SentEntradaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sentEntrada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(TK_READ);
			setState(73);
			match(T__2);
			setState(74);
			match(TK_ID);
			setState(75);
			match(T__3);
			setState(76);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentSalidaContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TK_PRINT() { return getToken(LenguajeQParser.TK_PRINT, 0); }
		public TerminalNode TK_PRINTLN() { return getToken(LenguajeQParser.TK_PRINTLN, 0); }
		public SentSalidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentSalida; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterSentSalida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitSentSalida(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitSentSalida(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentSalidaContext sentSalida() throws RecognitionException {
		SentSalidaContext _localctx = new SentSalidaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentSalida);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !(_la==TK_PRINT || _la==TK_PRINTLN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(79);
			match(T__2);
			setState(80);
			exp(0);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(81);
				match(T__4);
				setState(82);
				exp(0);
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(T__3);
			setState(89);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentIfContext extends ParserRuleContext {
		public TerminalNode TK_IF() { return getToken(LenguajeQParser.TK_IF, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<SentContext> sent() {
			return getRuleContexts(SentContext.class);
		}
		public SentContext sent(int i) {
			return getRuleContext(SentContext.class,i);
		}
		public TerminalNode TK_ELSE() { return getToken(LenguajeQParser.TK_ELSE, 0); }
		public SentIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterSentIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitSentIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitSentIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentIfContext sentIf() throws RecognitionException {
		SentIfContext _localctx = new SentIfContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sentIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(TK_IF);
			setState(92);
			match(T__2);
			setState(93);
			exp(0);
			setState(94);
			match(T__3);
			setState(95);
			sent();
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(96);
				match(TK_ELSE);
				setState(97);
				sent();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BloqueContext extends ParserRuleContext {
		public List<SentContext> sent() {
			return getRuleContexts(SentContext.class);
		}
		public SentContext sent(int i) {
			return getRuleContext(SentContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__5);
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				sent();
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549421120L) != 0) );
			setState(106);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentTimesContext extends ParserRuleContext {
		public TerminalNode TK_TIMES() { return getToken(LenguajeQParser.TK_TIMES, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SentContext sent() {
			return getRuleContext(SentContext.class,0);
		}
		public SentTimesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentTimes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterSentTimes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitSentTimes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitSentTimes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentTimesContext sentTimes() throws RecognitionException {
		SentTimesContext _localctx = new SentTimesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sentTimes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(TK_TIMES);
			setState(109);
			match(T__2);
			setState(110);
			exp(0);
			setState(111);
			match(T__3);
			setState(112);
			sent();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentMeanContext extends ParserRuleContext {
		public TerminalNode TK_MEAN() { return getToken(LenguajeQParser.TK_MEAN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SentMeanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentMean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterSentMean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitSentMean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitSentMean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentMeanContext sentMean() throws RecognitionException {
		SentMeanContext _localctx = new SentMeanContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentMean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(TK_MEAN);
			setState(115);
			match(T__2);
			setState(116);
			exp(0);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(117);
				match(T__4);
				setState(118);
				exp(0);
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpMeanContext extends ExpContext {
		public SentMeanContext sentMean() {
			return getRuleContext(SentMeanContext.class,0);
		}
		public ExpMeanContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterExpMean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitExpMean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitExpMean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpCteContext extends ExpContext {
		public ConstanteContext constante() {
			return getRuleContext(ConstanteContext.class,0);
		}
		public ExpCteContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterExpCte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitExpCte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitExpCte(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpMulDivContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpMulDivContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterExpMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitExpMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitExpMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpSignoContext extends ExpContext {
		public Token op;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpSignoContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterExpSigno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitExpSigno(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitExpSigno(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpIDContext extends ExpContext {
		public TerminalNode TK_ID() { return getToken(LenguajeQParser.TK_ID, 0); }
		public ExpIDContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterExpID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitExpID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitExpID(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpNegContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpNegContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterExpNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitExpNeg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitExpNeg(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpParentContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpParentContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterExpParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitExpParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitExpParent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpAddSubContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpAddSubContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterExpAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitExpAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitExpAddSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__8:
				{
				_localctx = new ExpSignoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(127);
				((ExpSignoContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
					((ExpSignoContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(128);
				exp(8);
				}
				break;
			case T__9:
				{
				_localctx = new ExpNegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(T__9);
				setState(130);
				exp(7);
				}
				break;
			case T__2:
				{
				_localctx = new ExpParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(T__2);
				setState(132);
				exp(0);
				setState(133);
				match(T__3);
				}
				break;
			case TK_CTE_INT:
			case TK_CTE_HEX:
			case TK_CTE_FLOAT:
			case TK_CTE_STRING:
				{
				_localctx = new ExpCteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				constante();
				}
				break;
			case TK_ID:
				{
				_localctx = new ExpIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(TK_ID);
				}
				break;
			case TK_MEAN:
				{
				_localctx = new ExpMeanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				sentMean();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(146);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExpMulDivContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(140);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(141);
						((ExpMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((ExpMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(142);
						exp(7);
						}
						break;
					case 2:
						{
						_localctx = new ExpAddSubContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(143);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(144);
						((ExpAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__7 || _la==T__8) ) {
							((ExpAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(145);
						exp(6);
						}
						break;
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstanteContext extends ParserRuleContext {
		public ConstanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constante; }
	 
		public ConstanteContext() { }
		public void copyFrom(ConstanteContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CteFloatContext extends ConstanteContext {
		public TerminalNode TK_CTE_FLOAT() { return getToken(LenguajeQParser.TK_CTE_FLOAT, 0); }
		public CteFloatContext(ConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterCteFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitCteFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitCteFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CteHexContext extends ConstanteContext {
		public TerminalNode TK_CTE_HEX() { return getToken(LenguajeQParser.TK_CTE_HEX, 0); }
		public CteHexContext(ConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterCteHex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitCteHex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitCteHex(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CteStringContext extends ConstanteContext {
		public TerminalNode TK_CTE_STRING() { return getToken(LenguajeQParser.TK_CTE_STRING, 0); }
		public CteStringContext(ConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterCteString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitCteString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitCteString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CteIntContext extends ConstanteContext {
		public TerminalNode TK_CTE_INT() { return getToken(LenguajeQParser.TK_CTE_INT, 0); }
		public CteIntContext(ConstanteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterCteInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitCteInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitCteInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstanteContext constante() throws RecognitionException {
		ConstanteContext _localctx = new ConstanteContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constante);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TK_CTE_INT:
				_localctx = new CteIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				match(TK_CTE_INT);
				}
				break;
			case TK_CTE_HEX:
				_localctx = new CteHexContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(TK_CTE_HEX);
				}
				break;
			case TK_CTE_FLOAT:
				_localctx = new CteFloatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				match(TK_CTE_FLOAT);
				}
				break;
			case TK_CTE_STRING:
				_localctx = new CteStringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				match(TK_CTE_STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	 
		public TipoContext() { }
		public void copyFrom(TipoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TipoFloatContext extends TipoContext {
		public TerminalNode TK_TIPO_FLOAT() { return getToken(LenguajeQParser.TK_TIPO_FLOAT, 0); }
		public TipoFloatContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterTipoFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitTipoFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitTipoFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TipoStringContext extends TipoContext {
		public TerminalNode TK_TIPO_STRING() { return getToken(LenguajeQParser.TK_TIPO_STRING, 0); }
		public TipoStringContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterTipoString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitTipoString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitTipoString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TipoIntContext extends TipoContext {
		public TerminalNode TK_TIPO_INT() { return getToken(LenguajeQParser.TK_TIPO_INT, 0); }
		public TipoIntContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).enterTipoInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LenguajeQListener ) ((LenguajeQListener)listener).exitTipoInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LenguajeQVisitor ) return ((LenguajeQVisitor<? extends T>)visitor).visitTipoInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tipo);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TK_TIPO_INT:
				_localctx = new TipoIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(TK_TIPO_INT);
				}
				break;
			case TK_TIPO_FLOAT:
				_localctx = new TipoFloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(TK_TIPO_FLOAT);
				}
				break;
			case TK_TIPO_STRING:
				_localctx = new TipoStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				match(TK_TIPO_STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u00a3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0005\u0000\u001e\b\u0000\n\u0000"+
		"\f\u0000!\t\u0000\u0001\u0000\u0001\u0000\u0004\u0000%\b\u0000\u000b\u0000"+
		"\f\u0000&\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001/\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002:\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003@\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006T\b\u0006\n\u0006\f\u0006W\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007c\b\u0007"+
		"\u0001\b\u0001\b\u0004\bg\b\b\u000b\b\f\bh\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\nx\b\n\n\n\f\n{\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u008b\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0093\b\u000b\n\u000b\f\u000b\u0096\t\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u009c\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u00a1\b\r"+
		"\u0001\r\u0000\u0001\u0016\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u0000\u0003\u0001\u0000\u000f\u0010\u0001"+
		"\u0000\b\t\u0001\u0000\u000b\f\u00ae\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0002*\u0001\u0000\u0000\u0000\u00049\u0001\u0000\u0000\u0000\u0006;"+
		"\u0001\u0000\u0000\u0000\bC\u0001\u0000\u0000\u0000\nH\u0001\u0000\u0000"+
		"\u0000\fN\u0001\u0000\u0000\u0000\u000e[\u0001\u0000\u0000\u0000\u0010"+
		"d\u0001\u0000\u0000\u0000\u0012l\u0001\u0000\u0000\u0000\u0014r\u0001"+
		"\u0000\u0000\u0000\u0016\u008a\u0001\u0000\u0000\u0000\u0018\u009b\u0001"+
		"\u0000\u0000\u0000\u001a\u00a0\u0001\u0000\u0000\u0000\u001c\u001e\u0003"+
		"\u0002\u0001\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e!\u0001\u0000"+
		"\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000"+
		"\u0000 \"\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000\"$\u0005"+
		"\r\u0000\u0000#%\u0003\u0004\u0002\u0000$#\u0001\u0000\u0000\u0000%&\u0001"+
		"\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000"+
		"\'(\u0001\u0000\u0000\u0000()\u0005\u000e\u0000\u0000)\u0001\u0001\u0000"+
		"\u0000\u0000*+\u0003\u001a\r\u0000+.\u0005\u001d\u0000\u0000,-\u0005\u0001"+
		"\u0000\u0000-/\u0003\u0018\f\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000"+
		"\u0000\u0000/0\u0001\u0000\u0000\u000001\u0005\u0002\u0000\u00001\u0003"+
		"\u0001\u0000\u0000\u00002:\u0003\u0006\u0003\u00003:\u0003\b\u0004\u0000"+
		"4:\u0003\f\u0006\u00005:\u0003\n\u0005\u00006:\u0003\u000e\u0007\u0000"+
		"7:\u0003\u0012\t\u00008:\u0003\u0010\b\u000092\u0001\u0000\u0000\u0000"+
		"93\u0001\u0000\u0000\u000094\u0001\u0000\u0000\u000095\u0001\u0000\u0000"+
		"\u000096\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u000098\u0001\u0000"+
		"\u0000\u0000:\u0005\u0001\u0000\u0000\u0000;<\u0003\u001a\r\u0000<?\u0005"+
		"\u001d\u0000\u0000=>\u0005\u0001\u0000\u0000>@\u0003\u0016\u000b\u0000"+
		"?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000"+
		"\u0000AB\u0005\u0002\u0000\u0000B\u0007\u0001\u0000\u0000\u0000CD\u0005"+
		"\u001d\u0000\u0000DE\u0005\u0001\u0000\u0000EF\u0003\u0016\u000b\u0000"+
		"FG\u0005\u0002\u0000\u0000G\t\u0001\u0000\u0000\u0000HI\u0005\u0011\u0000"+
		"\u0000IJ\u0005\u0003\u0000\u0000JK\u0005\u001d\u0000\u0000KL\u0005\u0004"+
		"\u0000\u0000LM\u0005\u0002\u0000\u0000M\u000b\u0001\u0000\u0000\u0000"+
		"NO\u0007\u0000\u0000\u0000OP\u0005\u0003\u0000\u0000PU\u0003\u0016\u000b"+
		"\u0000QR\u0005\u0005\u0000\u0000RT\u0003\u0016\u000b\u0000SQ\u0001\u0000"+
		"\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001"+
		"\u0000\u0000\u0000VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"XY\u0005\u0004\u0000\u0000YZ\u0005\u0002\u0000\u0000Z\r\u0001\u0000\u0000"+
		"\u0000[\\\u0005\u0015\u0000\u0000\\]\u0005\u0003\u0000\u0000]^\u0003\u0016"+
		"\u000b\u0000^_\u0005\u0004\u0000\u0000_b\u0003\u0004\u0002\u0000`a\u0005"+
		"\u0016\u0000\u0000ac\u0003\u0004\u0002\u0000b`\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000c\u000f\u0001\u0000\u0000\u0000df\u0005\u0006"+
		"\u0000\u0000eg\u0003\u0004\u0002\u0000fe\u0001\u0000\u0000\u0000gh\u0001"+
		"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jk\u0005\u0007\u0000\u0000k\u0011\u0001\u0000"+
		"\u0000\u0000lm\u0005\u0017\u0000\u0000mn\u0005\u0003\u0000\u0000no\u0003"+
		"\u0016\u000b\u0000op\u0005\u0004\u0000\u0000pq\u0003\u0004\u0002\u0000"+
		"q\u0013\u0001\u0000\u0000\u0000rs\u0005\u0018\u0000\u0000st\u0005\u0003"+
		"\u0000\u0000ty\u0003\u0016\u000b\u0000uv\u0005\u0005\u0000\u0000vx\u0003"+
		"\u0016\u000b\u0000wu\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000"+
		"\u0000{y\u0001\u0000\u0000\u0000|}\u0005\u0004\u0000\u0000}\u0015\u0001"+
		"\u0000\u0000\u0000~\u007f\u0006\u000b\uffff\uffff\u0000\u007f\u0080\u0007"+
		"\u0001\u0000\u0000\u0080\u008b\u0003\u0016\u000b\b\u0081\u0082\u0005\n"+
		"\u0000\u0000\u0082\u008b\u0003\u0016\u000b\u0007\u0083\u0084\u0005\u0003"+
		"\u0000\u0000\u0084\u0085\u0003\u0016\u000b\u0000\u0085\u0086\u0005\u0004"+
		"\u0000\u0000\u0086\u008b\u0001\u0000\u0000\u0000\u0087\u008b\u0003\u0018"+
		"\f\u0000\u0088\u008b\u0005\u001d\u0000\u0000\u0089\u008b\u0003\u0014\n"+
		"\u0000\u008a~\u0001\u0000\u0000\u0000\u008a\u0081\u0001\u0000\u0000\u0000"+
		"\u008a\u0083\u0001\u0000\u0000\u0000\u008a\u0087\u0001\u0000\u0000\u0000"+
		"\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u0094\u0001\u0000\u0000\u0000\u008c\u008d\n\u0006\u0000\u0000\u008d"+
		"\u008e\u0007\u0002\u0000\u0000\u008e\u0093\u0003\u0016\u000b\u0007\u008f"+
		"\u0090\n\u0005\u0000\u0000\u0090\u0091\u0007\u0001\u0000\u0000\u0091\u0093"+
		"\u0003\u0016\u000b\u0006\u0092\u008c\u0001\u0000\u0000\u0000\u0092\u008f"+
		"\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000\u0094\u0092"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0017"+
		"\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u009c"+
		"\u0005\u0019\u0000\u0000\u0098\u009c\u0005\u001a\u0000\u0000\u0099\u009c"+
		"\u0005\u001b\u0000\u0000\u009a\u009c\u0005\u001c\u0000\u0000\u009b\u0097"+
		"\u0001\u0000\u0000\u0000\u009b\u0098\u0001\u0000\u0000\u0000\u009b\u0099"+
		"\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u0019"+
		"\u0001\u0000\u0000\u0000\u009d\u00a1\u0005\u0012\u0000\u0000\u009e\u00a1"+
		"\u0005\u0013\u0000\u0000\u009f\u00a1\u0005\u0014\u0000\u0000\u00a0\u009d"+
		"\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u009f"+
		"\u0001\u0000\u0000\u0000\u00a1\u001b\u0001\u0000\u0000\u0000\u000e\u001f"+
		"&.9?Ubhy\u008a\u0092\u0094\u009b\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}