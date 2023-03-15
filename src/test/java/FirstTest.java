import org.junit.Assert;
import org.junit.Test;

public class FirstTest {
    @Test
    public void test01() {
        Assert.assertTrue(7 < 9);
        //assertTrue(boolean) => sadece testin true yada false olmasını saglar
    }

    @Test
    public void test02() {
        Assert.assertTrue("Test Fail", 7 < 9);
        //Test basarisiz oldugunda mesaj aliriz.
        //assertTrue(String message, boolean) ==> testin false olması halinde
        // konsolda yazdıgımız String message ifade gorulur
    }

    @Test
    public void test03() {
        Assert.assertEquals("SAYILAR ESIT DEGIL", "3", "6");
    }

}
