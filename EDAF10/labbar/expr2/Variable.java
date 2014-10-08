package expr2;

import java.util.Map;
import java.util.Set;

public class Variable extends Expr {
	
	private String name;

	public Variable(String name){
		this.name = name;
	}

	@Override
	protected void collectVariables(Set<Variable> set) {
		set.add(this);
	}

	@Override
	public boolean value(Map<Variable, Boolean> map) {
		return map.get(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variable other = (Variable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String toString()	{
		return name;
	}
	

}
