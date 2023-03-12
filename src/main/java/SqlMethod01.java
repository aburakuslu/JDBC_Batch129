import java.sql.*;

public class SqlMethod01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproeducation",
                "postgres",
                "Antonio577");
        Statement st = con.createStatement();

        ResultSet veri = st.executeQuery("select * from elemanlar");

        while(veri.next()) {
            System.out.println(veri.getInt("eleman_id") + veri.getString(2) + veri.getString(3));
        }
        
        ResultSet veri01 = st.executeQuery("select eleman_id from elemanlar where eleman_id=100");
        while(veri01.next()) {
            System.out.println(veri01.getInt(1));
        }

    }
}
