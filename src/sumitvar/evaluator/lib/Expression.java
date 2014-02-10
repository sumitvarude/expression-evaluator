package sumitvar.evaluator.lib;

public class Expression {
    private double value = 0;
    private Expression left, right;
    BinaryOperation operation;

    public Expression(double value) {
        this.value = value;
    }

    public Expression(Expression left, Expression right, BinaryOperation operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public double evaluate() {
        return (value != 0) ? value : operation.operate(left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;

        if (Double.compare(that.value, value) != 0) return false;
        if (left != null ? !left.equals(that.left) : that.left != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;
        if (right != null ? !right.equals(that.right) : that.right != null) return false;
        return true;
    }
}
