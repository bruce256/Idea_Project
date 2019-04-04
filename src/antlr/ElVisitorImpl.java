package antlr;

import antlr.gen.El2BaseVisitor;
import antlr.gen.El2Parser;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author lvsheng
 * @date 2019-03-23
 **/
public class ElVisitorImpl extends El2BaseVisitor<Double> {
	
	public static final double TRUE = 1d;
	public static final double FALSE = -1d;
	
	private Map<String, Double> context = Maps.newHashMap();
	
	/*************************************************
	 * 算术运算
	 *************************************************/
	@Override
	public Double visitProgram(El2Parser.ProgramContext ctx) {
		Double result = null;
		for (int i = 0; i < ctx.statement().size(); i++) {
			result = visit(ctx.statement().get(i));
			System.out.println(ctx.statement().get(i).getText() + "\tresult:\t" + result);
		}
		return result;
	}
	
	@Override
	public Double visitStatement(El2Parser.StatementContext ctx) {
		if (ctx.logicStat() != null) {
			return visit(ctx.logicStat());
		} else {
			return visit(ctx.stat());
		}
	}
	
	@Override
	public Double visitAdd(El2Parser.AddContext ctx) {
		Double left  = visit(ctx.stat(0));
		Double right = visit(ctx.stat(1));
		return left + right;
	}
	
	@Override
	public Double visitDivide(El2Parser.DivideContext ctx) {
		Double left  = visit(ctx.stat(0));
		Double right = visit(ctx.stat(1));
		return left / right;
	}
	
	@Override
	public Double visitNum(El2Parser.NumContext ctx) {
		return Double.parseDouble(ctx.NUM().getText());
	}
	
	@Override
	public Double visitMultiply(El2Parser.MultiplyContext ctx) {
		Double left  = visit(ctx.stat(0));
		Double right = visit(ctx.stat(1));
		return left * right;
	}
	
	@Override
	public Double visitSubtract(El2Parser.SubtractContext ctx) {
		Double left  = visit(ctx.stat(0));
		Double right = visit(ctx.stat(1));
		return left - right;
	}
	
	@Override
	public Double visitId(El2Parser.IdContext ctx) {
		return context.get(ctx.ID().getText());
	}
	
	@Override
	public Double visitParenthesis(El2Parser.ParenthesisContext ctx) {
		return visit(ctx.stat());
	}
	
	@Override
	public Double visitAssign(El2Parser.AssignContext ctx) {
		Double val = visit(ctx.stat());
		context.put(ctx.ID().getText(), val);
		return val;
	}
	
	
	/*************************************************
	 * 逻辑运算
	 *************************************************/
	@Override
	public Double visitOr(El2Parser.OrContext ctx) {
		Double left  = visit(ctx.logicStat(0));
		Double right = visit(ctx.logicStat(1));
		return (left > 0 || right > 0) ? TRUE : FALSE;
	}
	
	@Override
	public Double visitLogicParenthesis(El2Parser.LogicParenthesisContext ctx) {
		return visit(ctx.logicStat());
	}
	
	@Override
	public Double visitAnd(El2Parser.AndContext ctx) {
		Double left  = visit(ctx.logicStat(0));
		Double right = visit(ctx.logicStat(1));
		return (left > 0 && right > 0) ? TRUE : FALSE;
	}
	
	@Override
	public Double visitRelation(El2Parser.RelationContext ctx) {
		return visit(ctx.relStat());
	}
	
	@Override
	public Double visitEqual(El2Parser.EqualContext ctx) {
		Double left  = visit(ctx.relStat(0));
		Double right = visit(ctx.relStat(1));
		return left.equals(right) ? TRUE : FALSE;
	}
	
	@Override
	public Double visitRelId(El2Parser.RelIdContext ctx) {
		return context.get(ctx.ID().getText());
	}
	
	@Override
	public Double visitRelNum(El2Parser.RelNumContext ctx) {
		return Double.parseDouble(ctx.NUM().getText());
	}
	
	@Override
	public Double visitLt(El2Parser.LtContext ctx) {
		Double left  = visit(ctx.relStat(0));
		Double right = visit(ctx.relStat(1));
		return left < right ? TRUE : FALSE;
	}
	
	@Override
	public Double visitGt(El2Parser.GtContext ctx) {
		Double left  = visit(ctx.relStat(0));
		Double right = visit(ctx.relStat(1));
		return left > right ? TRUE : FALSE;
	}
	
	@Override
	public Double visitGte(El2Parser.GteContext ctx) {
		Double left  = visit(ctx.relStat(0));
		Double right = visit(ctx.relStat(1));
		return left >= right ? TRUE : FALSE;
	}
	
	@Override
	public Double visitLte(El2Parser.LteContext ctx) {
		Double left  = visit(ctx.relStat(0));
		Double right = visit(ctx.relStat(1));
		return left <= right ? TRUE : FALSE;
	}
}
