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
	private int open, close;

	public Expr build(Reader reader) {
		scanner = new Scanner(reader);
		token = scanner.nextToken();
		Expr expr = expr();
		System.out.println(open + "   !   " + close);
		if (token == Scanner.EOF && open == close) {
			return expr;
		} 
		else if(token == Scanner.EOF && open != close)	{
			throw new ParserException("Expecting \")\", found: "
					+ scanner.token());
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
		if (token == -3) {
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
		while (token == 124) {
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
		while (token == 38) {
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
		case -2:
			expr = new Variable(scanner.token());
			break;

		// "!" en factor
		case 33:
			token = scanner.nextToken();
			expr = new Not(new Variable(scanner.token()));
			break;

		// "(" början på expr
		case 40:
			open++;
			token = scanner.nextToken();
			expr = expr();
//			")"	slutet av expr
			if(token == 41)	{
				close++;
				token = scanner.nextToken();
			}
			break;

		default:
			throw new ParserException("Unexpected " + scanner.token());
		}
		token = scanner.nextToken();
		return expr;
	}
}