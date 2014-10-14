package parser;

import java.io.Reader;
import java.io.StringReader;
import expr.And;
import expr.Expr;
import expr.Implies;
import expr.Not;
import expr.Or;
import expr.Variable;

public class Parser {
	private Scanner scanner;
	private int token;

	public Expr build(Reader reader) {
		scanner = new Scanner(reader);
		token = scanner.nextToken();
		Expr expr = expr();
		if (token == Scanner.EOF) {
			return expr;
		} 
			else {
			throw new ParserException("Trailing garbage after "
					+ scanner.token());
		}
	}

	public Expr build(String input) {
		return build(new StringReader(input));
	}

	private Expr expr() {
		Expr result, primary;
		result = primary();
		if (token == Scanner.IMPLIES) {
			primary = result;
			token = scanner.nextToken();
			result = new Implies(primary, primary());
		}
		// TODO
		return result;
	}

	private Expr primary() {
		Expr result, term;
		result = term();
		while (token == '|') {
			term = result;
			token = scanner.nextToken();
			result = new Or(term, term());
		}
		// TODO
		return result;
	}

	private Expr term() {
		Expr result, factor;
		result = factor();
		while (token == '&') {
			factor = result;
			token = scanner.nextToken();
			result = new And(factor, factor());
		}
		// TODO
		return result;
	}

	private Expr factor() {
		Expr expr = null;
		switch (token) {
		case Scanner.VARIABLE:
			expr = new Variable(scanner.token());
			break;

		case '!':
			token = scanner.nextToken();
			expr = new Not(new Variable(scanner.token()));
			break;

		case '(':
			token = scanner.nextToken();
			expr = expr();
			if(token == ')')	{
				token = scanner.nextToken();
			}
			else	{
				throw new ParserException("Expecting \")\", found: "
						+ scanner.token());
			}
			break;

		default:
			throw new ParserException("Unexpected " + scanner.token());
		}
		token = scanner.nextToken();
		return expr;
	}
}