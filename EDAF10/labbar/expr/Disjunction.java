package expr;

import java.util.Map;

public class Disjunction extends TwoVariableExpr {

	public Disjunction(Expr e1, Expr e2) {
		super(e1, e2);
	}

	public boolean value(Map<Variable, Boolean> map) {
		return e1.value(map) || e2.value(map);
	}

	@Override
	protected String getOperand() {
		return "v";
	}
}
