import org.junit.Test;
import utilities.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedunnaRoomTest {

    @Test
    public void roomTest() throws SQLException {
        //"john doe" isimli kullanici tarafindan oda olusturuldu mu?
        JdbcUtils.connectToDataBase("medunna.com",
                "medunna_db",
                "medunna_user",
                "medunna_pass_987");

        Statement statement = JdbcUtils.createStatement();
        String sql01 = "select created_by from room";

        ResultSet resultSet = statement.executeQuery(sql01);

        List<String> created_byList = new ArrayList<>();

        while (resultSet.next()) {//Tek tek butun datalari aliyoruz.
            created_byList.add(resultSet.getString(1));
        }


    }
}
