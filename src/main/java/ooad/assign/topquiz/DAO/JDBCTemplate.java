package ooad.assign.topquiz.DAO;
import ooad.assign.topquiz.models.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCTemplate {
    private String url;
    private Properties props;

    public JDBCTemplate() {
        this.url = "jdbc:postgresql://localhost/postgres";
        this.props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "apple");
        props.setProperty("ssl", "false");
    }

    public List<List<String>> get(String sqlStatement,ArrayList<String> cols){
        List<List<String>> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(this.url);
             Statement stmt = conn.createStatement()) {

            try {
                ResultSet rs = stmt.executeQuery(sqlStatement);
                while(rs.next()){
                    ArrayList<String> row = new ArrayList<>();
                    for(String col : cols){
                        row.add(rs.getString(col));
                    }
                    result.add(row);
                }
                return result;
            } catch (SQLException e ) {
                throw new Error("Problem", e);
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }


}
