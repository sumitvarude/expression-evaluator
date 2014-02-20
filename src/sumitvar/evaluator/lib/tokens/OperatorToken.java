package sumitvar.evaluator.lib.tokens;

import sumitvar.evaluator.lib.tokens.Token;

/**
 * Represents operators
 */
public enum OperatorToken implements Token {
    ADDITION('+'),SUBTRACTION('-'),MULTIPLICATION('*'),DIVISION('/'),POWER('^');
    Character operator;

    private OperatorToken(Character operator) {
        this.operator = operator;
    }
}
