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

    public List<List<String>> getAll(String sqlStatement,ArrayList<String> cols){
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


    public List<String> getByValue(String sqlStatement,List<String> cols, List<String> values){
        List<String> row = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(this.url);
             PreparedStatement stmt = conn.prepareStatement(sqlStatement)) {
            for(int i = 0; i < values.size();i++) {
                stmt.setString(i + 1, values.get(i));
            }
            try {
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    for(String col : cols){
                        row.add(rs.getString(col));
                    }
                }
                return row;
            } catch (SQLException e ) {
                throw new Error("Problem", e);
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }


    public String createInsertStatement(String tableName,List<String> cols,List<String> values){
        String sqlStatement = "insert into " + tableName + "(";
        for(int i = 0;i < cols.size() - 1;i++){
            sqlStatement += cols.get(i) + ",";
        }
        sqlStatement += cols.get(cols.size() - 1) + ") values(";
        for(int i = 0;i < values.size() - 1;i++){
            sqlStatement += "'" + values.get(i) + "',";
        }
        sqlStatement += ")";
        return sqlStatement;
    }
    public void save(String tableName,List<String> cols,List<String> values){
        String sqlStatement = createInsertStatement(tableName,cols,values);
        try (Connection conn = DriverManager.getConnection(this.url);
             PreparedStatement stmt = conn.prepareStatement(sqlStatement)) {
            try {
                stmt.executeUpdate();
            } catch (SQLException e ) {
                throw new Error("Problem", e);
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }



}
