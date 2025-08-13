package org.assignment11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CreateUsers {
    public static void main(String[] args) {
        String[][] userData = {
                {"arjun92", "Arj@9215"},
                {"rohan07", "Roh@0703"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"priya24", "Pri@2408"},
                {"sneha95", "Sne@9512"},
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"vikas11", "Vik@1107"},
                {"visual_user", "secret_sauce"}
        };

        try (Connection con = DBConnection.getConnection()) {
            Statement createTable = con.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "username VARCHAR(50), "
                    + "password VARCHAR(50))";

            createTable.executeUpdate(createTableQuery);
            System.out.println("Table 'users' created or already exists.");

            String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            for (String[] user : userData) {
                ps.setString(1, user[0]);
                ps.setString(2, user[1]);
                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println("10 Users Inserted Successfully into DB");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
