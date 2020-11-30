package dyh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimestam {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

        try {
            Date parse = dateFormat.parse("2020-11-27 23:12:07:861");
            System.out.println("==" + parse.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
