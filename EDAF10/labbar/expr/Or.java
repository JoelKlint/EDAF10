package expr;


public class Or extends TwoVarExpr {

	public Or(Expr expr1, Expr expr2) {
		super(expr1, expr2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getSymbol() {
		return "v";
	}

	@Override
	protected boolean twoOpValue(Boolean one, Boolean two) {
		return one || two;
	}

}
