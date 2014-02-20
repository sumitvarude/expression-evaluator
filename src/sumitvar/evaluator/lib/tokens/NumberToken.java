package sumitvar.evaluator.lib.tokens;

public class NumberToken implements Token {
    double number;

    public NumberToken(double number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberToken that = (NumberToken) o;

        if (Double.compare(that.number, number) != 0) return false;

        return true;
    }
}
