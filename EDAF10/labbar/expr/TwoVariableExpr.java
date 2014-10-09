package expr;

import java.util.Map;
import java.util.Set;

public abstract class TwoVariableExpr extends Expr {
	

	protected Expr e1, e2;

	public TwoVariableExpr(Expr e1, Expr e2) {
		this.e1 = e1;
		this.e2 = e2;

	}

	@Override
	public abstract boolean value(Map<Variable, Boolean> map);

	@Override
	protected void collectVariables(Set<Variable> set) {
		e1.collectVariables(set);
		e2.collectVariables(set);
	}
	
	protected abstract String getOperand();
	
	public String toString() {
		String res = "";
		res = "( " + e1 + " " + getOperand() + " " + e2 + " )";
		return res;
	}
}
