package expr2;

import java.util.Map;
import java.util.Set;

public abstract class TwoVarExpr extends Expr {
	
	private Expr expr1;
	private Expr expr2;

	public TwoVarExpr(Expr expr1, Expr expr2)	{
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	protected abstract boolean twoOpValue(Boolean one, Boolean two);
	
	protected abstract String getSymbol();
	
	public String toString()	{
		return "(" + expr1.toString() + " " + this.getSymbol() + " " + expr2.toString() + ")";
	}

	@Override
	protected void collectVariables(Set<Variable> set) {
		expr1.collectVariables(set);
        expr2.collectVariables(set);
	}

	@Override
	public boolean value(Map<Variable, Boolean> map) {
		return twoOpValue(expr1.value(map), expr2.value(map));
	}

}
