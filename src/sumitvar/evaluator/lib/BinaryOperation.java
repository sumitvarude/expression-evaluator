package sumitvar.evaluator.lib;

/**
 * Gives common operate method for all binary operators
 */
public abstract class BinaryOperation {
    public abstract double operate(Expression left, Expression right);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }
}
