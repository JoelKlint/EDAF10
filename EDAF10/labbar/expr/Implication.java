package expr;

import java.util.Map;

public class Implication extends TwoVariableExpr {

	public Implication(Expr e1, Expr e2) {
		super(e1, e2);
		// TODO Auto-generated constructor stub
	}

	public boolean value(Map<Variable, Boolean> map) {
		return !e1.value(map) || e2.value(map);
	}

	public String toString() {
		return super.toString("->");
	}

}
