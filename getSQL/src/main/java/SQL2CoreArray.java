import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @描述
 * @创建人 Duanhaibo
 * @创建时间 2020/9/1
 * @修改人和其它信息
 */
public class SQL2CoreArray {

    public String SQL_after_replace(String inputSQL) throws IOException{

//        Scanner in=new Scanner(System.in);
//        System.out.print("请输入表达式：");
//        String inputSQL= in.nextLine();
        inputSQL=inputSQL.replaceAll(" AND ","*");  //使用*代替AND
        inputSQL=inputSQL.replaceAll(" OR ","#");   //使用#代替OR
//        System.out.println(inputSQL);
        return inputSQL;
    }
    public String[] getCoreSQLArray(String inputSQL) throws IOException {
        String[] stringList;

//        inputSQL=inputSQL.replaceAll(" AND ","*");  //使用*代替AND
//        inputSQL=inputSQL.replaceAll(" OR ","#");   //使用#代替OR
//        System.out.println(inputSQL);
        stringList=inputSQL.split("\\(|\\)|\\*|#");   //得到实际的所有操作语句构成数组
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<stringList.length;i++){
            if(stringList[i].length()!=0){
                list.add(stringList[i]);
            }
        }
        int len=list.size();
        String[] outing=new String[len];
        for(int i=0;i<len;i++){
            outing[i]=list.get(i);
//            System.out.println(outing[i]);
        }
        return outing;

    }
}
