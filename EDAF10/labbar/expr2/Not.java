package expr2;

import java.util.Map;
import java.util.Set;

public class Not extends Expr {
	
	private Expr expr;

	public Not(Expr expr)	{
		this.expr = expr;
	}
	
	public String toString()	{
		return "(�" + expr.toString() + ")";
	}

	@Override
	protected void collectVariables(Set<Variable> set) {
		expr.collectVariables(set);
	}

	@Override
	public boolean value(Map<Variable, Boolean> map) {
		return !(expr.value(map));
	}

}
