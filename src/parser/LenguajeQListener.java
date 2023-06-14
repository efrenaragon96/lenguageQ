// Generated from D:/UCLV/Compiladores/Old/LenguajeQ/src/grammars\LenguajeQ.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LenguajeQParser}.
 */
public interface LenguajeQListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(LenguajeQParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(LenguajeQParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(LenguajeQParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(LenguajeQParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#sent}.
	 * @param ctx the parse tree
	 */
	void enterSent(LenguajeQParser.SentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#sent}.
	 * @param ctx the parse tree
	 */
	void exitSent(LenguajeQParser.SentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#sentVarLocalDec}.
	 * @param ctx the parse tree
	 */
	void enterSentVarLocalDec(LenguajeQParser.SentVarLocalDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#sentVarLocalDec}.
	 * @param ctx the parse tree
	 */
	void exitSentVarLocalDec(LenguajeQParser.SentVarLocalDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#sentAsig}.
	 * @param ctx the parse tree
	 */
	void enterSentAsig(LenguajeQParser.SentAsigContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#sentAsig}.
	 * @param ctx the parse tree
	 */
	void exitSentAsig(LenguajeQParser.SentAsigContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#sentEntrada}.
	 * @param ctx the parse tree
	 */
	void enterSentEntrada(LenguajeQParser.SentEntradaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#sentEntrada}.
	 * @param ctx the parse tree
	 */
	void exitSentEntrada(LenguajeQParser.SentEntradaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#sentSalida}.
	 * @param ctx the parse tree
	 */
	void enterSentSalida(LenguajeQParser.SentSalidaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#sentSalida}.
	 * @param ctx the parse tree
	 */
	void exitSentSalida(LenguajeQParser.SentSalidaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#sentIf}.
	 * @param ctx the parse tree
	 */
	void enterSentIf(LenguajeQParser.SentIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#sentIf}.
	 * @param ctx the parse tree
	 */
	void exitSentIf(LenguajeQParser.SentIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(LenguajeQParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(LenguajeQParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#sentTimes}.
	 * @param ctx the parse tree
	 */
	void enterSentTimes(LenguajeQParser.SentTimesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#sentTimes}.
	 * @param ctx the parse tree
	 */
	void exitSentTimes(LenguajeQParser.SentTimesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeQParser#sentMean}.
	 * @param ctx the parse tree
	 */
	void enterSentMean(LenguajeQParser.SentMeanContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeQParser#sentMean}.
	 * @param ctx the parse tree
	 */
	void exitSentMean(LenguajeQParser.SentMeanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpMean}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpMean(LenguajeQParser.ExpMeanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpMean}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpMean(LenguajeQParser.ExpMeanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpCte}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpCte(LenguajeQParser.ExpCteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpCte}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpCte(LenguajeQParser.ExpCteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpMulDiv}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpMulDiv(LenguajeQParser.ExpMulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpMulDiv}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpMulDiv(LenguajeQParser.ExpMulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpSigno}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpSigno(LenguajeQParser.ExpSignoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpSigno}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpSigno(LenguajeQParser.ExpSignoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpID}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpID(LenguajeQParser.ExpIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpID}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpID(LenguajeQParser.ExpIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpNeg}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpNeg(LenguajeQParser.ExpNegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpNeg}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpNeg(LenguajeQParser.ExpNegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpParent}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpParent(LenguajeQParser.ExpParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpParent}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpParent(LenguajeQParser.ExpParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpAddSub}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpAddSub(LenguajeQParser.ExpAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpAddSub}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpAddSub(LenguajeQParser.ExpAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CteInt}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 */
	void enterCteInt(LenguajeQParser.CteIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CteInt}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 */
	void exitCteInt(LenguajeQParser.CteIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CteHex}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 */
	void enterCteHex(LenguajeQParser.CteHexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CteHex}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 */
	void exitCteHex(LenguajeQParser.CteHexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CteFloat}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 */
	void enterCteFloat(LenguajeQParser.CteFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CteFloat}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 */
	void exitCteFloat(LenguajeQParser.CteFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CteString}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 */
	void enterCteString(LenguajeQParser.CteStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CteString}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 */
	void exitCteString(LenguajeQParser.CteStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TipoInt}
	 * labeled alternative in {@link LenguajeQParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipoInt(LenguajeQParser.TipoIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TipoInt}
	 * labeled alternative in {@link LenguajeQParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipoInt(LenguajeQParser.TipoIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TipoFloat}
	 * labeled alternative in {@link LenguajeQParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipoFloat(LenguajeQParser.TipoFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TipoFloat}
	 * labeled alternative in {@link LenguajeQParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipoFloat(LenguajeQParser.TipoFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TipoString}
	 * labeled alternative in {@link LenguajeQParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipoString(LenguajeQParser.TipoStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TipoString}
	 * labeled alternative in {@link LenguajeQParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipoString(LenguajeQParser.TipoStringContext ctx);
}