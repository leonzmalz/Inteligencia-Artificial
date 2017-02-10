import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;

public class EqualConstraint implements Constraint {

	private Variable var1;
	private Variable var2;
	private List<Variable> scope;
	
	public EqualConstraint(Variable var1, Variable var2) {
		this.var1 = var1;
		this.var2 = var2;
		scope = new ArrayList<Variable>(2);
		scope.add(var1);
		scope.add(var2);
	}

	@Override
	public List<Variable> getScope() {
		// TODO Auto-generated method stub
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment assignment) {
		Object value1 = assignment.getAssignment(var1);
		Object value2 = assignment.getAssignment(var2);
		return value1 == null || value2 == null || value1.equals(value2);
	}

}
