import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @描述
 * @创建人 Duanhaibo
 * @创建时间 2020/8/31
 * @修改人和其它信息
 */
public class SQL_Obtain {
    private Expression expression;
    private SQL2CoreArray sta = new SQL2CoreArray();

    public SQL_Obtain(String SQL) throws IOException {
//        this.expression = expression;
        Stack<Expression> stack = new Stack();
        String str = "Company=='HuaTai' OR (age<=30 and sex!='male')";
        String afterReplace = sta.SQL_after_replace(str);
        String[] SQLArray = sta.getCoreSQLArray(afterReplace);
        int len = afterReplace.length();
        Expression left = null;
        Expression right = null;
        Stack<String> stack1 = new Stack();
        Stack<String> stack2 = new Stack();
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < afterReplace.length(); i++) {
            String tmpstr = afterReplace.substring(i, i + 1);
            String comb = new String();
            if (tmpstr == "(" || tmpstr == "*" || tmpstr == "#" || tmpstr == ")") {
                stack1.push(tmpstr);
                String left1 = new String();
                String right1 = new String();
                if (tmpstr == ")") {
                    do {
                        left1 = stack1.pop();
                        right1 = stack2.pop();
                        sb.insert(0, left1);
                        sb.insert(0, right1);
                    }
                    while (left1 != "(");
                }
                stack2.push(sb.toString());
            } else {
                stack2.push(SQLArray[j++]);
                i += SQLArray[j - 1].length() - 1;
            }


//            stack1.push(afterReplace.substring(i,i+1));
//            switch (afterReplace.substring(i,i+1)) {
//                case "(":    //加法
//                    left = stack.pop();
//                    right = new VarExpression(String.valueOf(SQLchar[++i]));
//                    stack.push(new AndSymbolExpression(left, right));
//                    break;
//                case "#":    //减法
//                    left = stack.pop();
//                    right = new VarExpression(String.valueOf(SQLchar[++i]));
//                    stack.push(new OrSymbolExpression(left, right));
//                    break;
//                default:    //公式中的变量
//                    stack.push(new VarExpression(String.valueOf(SQLchar[i])));
//                    break;
//            }
//        }
//        this.expression = stack.pop();
//    }

//    public SQL_Obtain() {
//
//    }
//
//    public String run() {
//        return this.expression.interpreter();
//    }
        }

    }
}
