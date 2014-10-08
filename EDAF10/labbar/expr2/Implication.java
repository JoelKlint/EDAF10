package expr2;


public class Implication extends TwoVarExpr {

	public Implication(Expr expr1, Expr expr2) {
		super(expr1, expr2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getSymbol() {
		return "-->";
	}

	@Override
	protected boolean twoOpValue(Boolean one, Boolean two) {
		return !one || two;
	}

}
