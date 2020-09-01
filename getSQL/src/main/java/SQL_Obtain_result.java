import java.io.IOException;
import java.util.Stack;

/**
 * @描述
 * @创建人 Duanhaibo
 * @创建时间 2020/8/31
 * @修改人和其它信息
 */
public class SQL_Obtain_result {
    private Expression expression;
    private SQL2CoreArray sta = new SQL2CoreArray();

    public void obtain_result(String str) throws IOException {
//        this.expression = expression;
        Stack<Expression> stack = new Stack();
//        String str = "(Company='HuaTai') OR (age<=30 AND sex!='male')";
        String afterReplace = sta.SQL_after_replace(str);
        String[] SQLArray = sta.getCoreSQLArray(afterReplace);
        int len = afterReplace.length();
        Expression left = null;
        Expression right = null;


        Stack<String> stack1 = new Stack();
        Stack<String> stack2 = new Stack();

        int j = 0;

//        for (int i = 0; i < afterReplace.length(); i++)
        int i=0;
        while(i<afterReplace.length()){
            String tmpstr = afterReplace.substring(i, i + 1);

            String comb = new String();

            if (tmpstr.equals("(") || tmpstr.equals("*") || tmpstr.equals("#") || tmpstr.equals(")")) {
                i++;
                stack1.push(tmpstr);
                String left1 = new String();
                String right1 = new String();
                StringBuilder sb = new StringBuilder();
                if (tmpstr.equals(")")) {
//                        StringBuilder sb1 = new StringBuilder();
                    do {
                        left1 = stack1.pop();
                        if(stack2.empty()){
                            right1="";
                        }
                        else {
                            right1 = stack2.pop();
                        }
                        sb.insert(0, left1);
                        sb.insert(0, right1);
                    } while (!left1.equals("("));

                    stack2.push(sb.toString());
                }


                else if (!stack1.contains("(")) {
                    left1 = stack1.pop();
                    right1 = stack2.pop();
                    sb.append(right1);
                    sb.append(left1);
                    stack2.push(sb.toString());
                }
                else continue;
            }

            else {
                //                System.out.println(j);
                stack2.push(SQLArray[j++]);
                i += SQLArray[j - 1].length();
            }
                }



            String result=stack2.pop();
            result=result.replaceAll("#"," OR ");
            result=result.replaceAll("\\*"," AND ");
            System.out.println("Select * from where "+result);

}

}

