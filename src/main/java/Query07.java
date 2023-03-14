import pojos.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query07 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Antonio577");

        Statement st = con.createStatement();

        //SORU: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)

        //String sql01 = "create table urunler (id int, isim varchar (10), fiyat int)";
        //st.execute(sql01);

        List<Urun> kayitlar = new ArrayList<>();
        kayitlar.add(new Urun(100, "laptop", 35000));
        kayitlar.add(new Urun(101, "iPad", 25000));
        kayitlar.add(new Urun(102, "MacBook", 55000));
        kayitlar.add(new Urun(103, "Anakart", 35000));
        kayitlar.add(new Urun(104, "iMac", 15000));
        kayitlar.add(new Urun(105, "iPhone", 45000));

        //Cok miktarda data eklemek icin PreparedStatement kullanmaliyiz.
        PreparedStatement tablo = con.prepareStatement("insert into urunler values(?, ?, ?)");

        for(Urun each : kayitlar) {
            tablo.setInt(1, each.getId());          //id: 100
            tablo.setString(2, each.getIsim());     //isim: laptop
            tablo.setDouble(3, each.getFiyat());    //fiyat:35000
            tablo.addBatch(); //Butun data'lari birlestiriyor
        }
        tablo.executeBatch();

    }
}
