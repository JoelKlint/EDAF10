package expr;

import java.util.Map;
import java.util.Set;

public class Not extends Expr{
	
	private Expr e1;
	
	public Not(Expr e1)	{
		this.e1 = e1;
	}

	@Override
	public boolean value(Map<Variable, Boolean> map) {
		return !e1.value(map);
	}

	@Override
	protected void collectVariables(Set<Variable> set) {
		e1.collectVariables(set);
		
	}
	
	public String toString() {
		String res = "";
		res = "Â" + e1;
		return res;
	}
	
}
