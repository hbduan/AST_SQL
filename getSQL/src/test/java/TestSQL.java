import org.junit.Test;

import java.io.IOException;

/**
 * @描述
 * @创建人 Duanhaibo
 * @创建时间 2020/9/1
 * @修改人和其它信息
 */
public class TestSQL {
    SQL2CoreArray s2a = new SQL2CoreArray();

    //对从SQL中得到核心数组进行测试
    @Test
    public void SQL2ListTest() throws IOException {
        String input=new String("(Company=='HuaTai') OR (age<=30 AND sex!='male')");
        String afterReplace=s2a.SQL_after_replace(input);
        System.out.println(afterReplace);
        String[] result=s2a.getCoreSQLArray(afterReplace);// input="Company=="HuaTai" OR (age<=30 and sex!="male")";
        for(String d:result){
            System.out.println(d);
        }

    }


    @Test
    public void testSQL_Obtain_result() throws IOException {
        String input=new String("(Company=='HuaTai') OR (age<=30 AND sex!='male')");
        SQL_Obtain_result sor=new SQL_Obtain_result();
        sor.obtain_result(input);

    }


    @Test
    public void testSQL_Obtain_result_Complex() throws IOException {
        String input=new String("(Userid=6 OR (Company=='HuaTai' AND (time=12.30 OR CompanyID=9))) OR (age<=30 AND sex!='male')");
        SQL_Obtain_result sor=new SQL_Obtain_result();
        sor.obtain_result(input);

    }


}
