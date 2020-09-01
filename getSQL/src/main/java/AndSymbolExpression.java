/**
 * @描述
 * @创建人 Duanhaibo
 * @创建时间 2020/8/31
 * @修改人和其它信息
 */
public class AndSymbolExpression extends SymbolExpression {

    public AndSymbolExpression(Expression left, Expression right) {
        super(left, right);
    }

    public String interpreter() {
        return super.left.interpreter() + " AND "+super.right.interpreter();
    }
}
