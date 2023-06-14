// Generated from D:/UCLV/Compiladores/Old/LenguajeQ/src/grammars\LenguajeQ.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LenguajeQParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LenguajeQVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(LenguajeQParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(LenguajeQParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#sent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSent(LenguajeQParser.SentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#sentVarLocalDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentVarLocalDec(LenguajeQParser.SentVarLocalDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#sentAsig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentAsig(LenguajeQParser.SentAsigContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#sentEntrada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentEntrada(LenguajeQParser.SentEntradaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#sentSalida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentSalida(LenguajeQParser.SentSalidaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#sentIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentIf(LenguajeQParser.SentIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(LenguajeQParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#sentTimes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentTimes(LenguajeQParser.SentTimesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeQParser#sentMean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentMean(LenguajeQParser.SentMeanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpMean}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpMean(LenguajeQParser.ExpMeanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpCte}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpCte(LenguajeQParser.ExpCteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpMulDiv}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpMulDiv(LenguajeQParser.ExpMulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpSigno}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpSigno(LenguajeQParser.ExpSignoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpID}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpID(LenguajeQParser.ExpIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpNeg}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpNeg(LenguajeQParser.ExpNegContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpParent}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpParent(LenguajeQParser.ExpParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpAddSub}
	 * labeled alternative in {@link LenguajeQParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAddSub(LenguajeQParser.ExpAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CteInt}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCteInt(LenguajeQParser.CteIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CteHex}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCteHex(LenguajeQParser.CteHexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CteFloat}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCteFloat(LenguajeQParser.CteFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CteString}
	 * labeled alternative in {@link LenguajeQParser#constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCteString(LenguajeQParser.CteStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TipoInt}
	 * labeled alternative in {@link LenguajeQParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoInt(LenguajeQParser.TipoIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TipoFloat}
	 * labeled alternative in {@link LenguajeQParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoFloat(LenguajeQParser.TipoFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TipoString}
	 * labeled alternative in {@link LenguajeQParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoString(LenguajeQParser.TipoStringContext ctx);
}