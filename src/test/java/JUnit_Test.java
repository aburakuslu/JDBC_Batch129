import org.junit.Assert;
import org.junit.Test;
import utilities.DatabaseUtility;

import static utilities.DatabaseUtility.*;

public class JUnit_Test {

    @Test
    public void test01() {
        //Nil Naz ve Ali Can isimli ogrencilerin DataBase'de kayitli oldugunu dogrulayiniz
        DatabaseUtility.createConnection();

        String sql01 = "select * from ogrenciler";
        System.out.println("Ogrenci ismi: " + getColumnData(sql01, "ogrenci_ismi"));
        Assert.assertTrue("DataBase'de kayit bulunamadi.",
                getColumnData(sql01, "ogrenci_ismi").contains("Ali Can"));

        //getColumnData(sql01, "ogrenci_ismi") tablodaki ogrenci isimlerini verir

        closeConnection();
    }

    @Test
    public void test02() {

        //120 numarali kayit var mi?
        createConnection();
        Assert.assertTrue("DataBase'de kayit bulunamadi",
                getColumnData("select * from ogrenciler", "okul_no").contains(1200));



    }
}
