package expr;

import java.util.Map;
import java.util.Set;

public class Variable extends Expr{
	
	private String name;
	
	public Variable(String name)	{
		this.name = name;
	}

	@Override
	public boolean value(Map<Variable, Boolean> map) {
		return map.get(this);
	}

	@Override
	protected void collectVariables(Set<Variable> set) {
		set.add(this);
		// TODO Auto-generated method stub
		
	}
	
	private String getName(){
		return name;
	}
	
	public boolean equals(Object other)	{
		if(other instanceof Variable)	{
			String otherName = ((Variable)other).getName();
			if(otherName.equals(name))	{
				return true;
			}
		}
		return false;
	}
	
	public int hashCode()	{
		int hashCode = name.hashCode();
		return hashCode;
	}

	public String toString()	{
		return name;
	}
	
	
	
	

}
