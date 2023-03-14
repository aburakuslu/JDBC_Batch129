import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //drivera kaydol
        Class.forName("org.postgresql.Driver");

        //database e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Antonio577");

        //statement olustur
        Statement st = con.createStatement();

        ResultSet veri = st.executeQuery("select * from ogrenciler");

        System.out.println("Connection Success");

        while (veri.next()) {


            System.out.println("|" + veri.getInt(1) + "| |"
                    + veri.getString(2) + "| |"
                    + veri.getString(3) + "| |"
                    + veri.getString(4) + "|")  ;
        }

//        con.close();
//        st.close();
//        veri.close();
    }

}