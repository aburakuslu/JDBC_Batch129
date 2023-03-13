import java.sql.*;

public class Query06 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Antonio577");

        Statement st = con.createStatement();
        //st.executeUpdate("insert into ogrenciler values (850, 'Ali Can', 11, 'E')");

        PreparedStatement ps = con.prepareStatement("insert into ogrenciler values (?, ?, ?, ?)");
        ps.setInt(1, 950);
        ps.setString(2, "Ali Can");
        ps.setString(3, "11");
        ps.setString(4, "E");

        ps.executeUpdate();

        ps.close();
    }
}
