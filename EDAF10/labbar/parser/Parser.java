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
        } else {
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
        // TODO
        return result;
    }

    private Expr primary() {
        Expr result, term;
        result = term();
        // TODO
        return result;
     }

    private Expr term() {
        Expr result, factor;
        result = factor();
        // TODO
        return result;
   }

    private Expr factor() {
        switch (token) {
        //TODO
        default:
            throw new ParserException("Unexpected " + scanner.token());
        }
    }
}