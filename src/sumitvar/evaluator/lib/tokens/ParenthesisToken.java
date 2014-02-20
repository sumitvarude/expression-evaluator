package sumitvar.evaluator.lib.tokens;

import sumitvar.evaluator.lib.tokens.Token;

/**
 * Created by sumitvar on 2/10/14.
 */
public enum ParenthesisToken implements Token {
    LROUNDBRACKET('('),RROUNDBRACKET(')');
    private Character parenthesis;

    private ParenthesisToken(Character parenthesis) {
        this.parenthesis = parenthesis;
    }
}
