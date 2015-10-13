package expr;

import java.util.Map;

public class Equal extends TwoVariableExpr {

	public Equal(Expr e1, Expr e2) {
		super(e1, e2);
	}

	@Override
	public boolean value(Map<Variable, Boolean> map) {
		return e1.value(map) == e2.value(map);
	}

	@Override
	protected String getOperand() {
		return "<->";
	}
}
