/**
 * @描述
 * @创建人 Duanhaibo
 * @创建时间 2020/8/31
 * @修改人和其它信息
 */
public class VarExpression extends Expression {
    private String __var;

    public VarExpression(String __var) {
        this.__var = __var;
    }

    public String interpreter() {
        return this.__var;
    }
}
