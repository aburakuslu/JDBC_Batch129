import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DatabaseUtility;

public class TestNG_Test {

    @Test
    public void test01() {
        //Derya Soylu database'e kayitli mi?
        DatabaseUtility.createConnection();
        String sql = "select * from ogrenciler";
        Assert.assertTrue(DatabaseUtility.getColumnData(sql, "ogrenci_ismi")
                .contains("Derya Soylu"), "DataBase'de kayit bulunamadi!");
        DatabaseUtility.closeConnection();
    }

    @Test
    public void test02() {
        //111 numarali kayit var mi?
        DatabaseUtility.createConnection();
        Assert.assertTrue(DatabaseUtility.getColumnData("select * from ogrenciler",
                "okul_no").contains(111),"DataBase'de kayit bulunamadi!");
        DatabaseUtility.closeConnection();
    }
}
