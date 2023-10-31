package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private final Connection connection;
    
    public Database() {
        Connection conn = null;
        try {
            String dbHost = "localhost";
            String dbName = "database_e_surat";
            String dbUser = "root";
            String dbPass = "";

            String url = "jdbc:mysql://" + dbHost + "/" + dbName;
            conn = DriverManager.getConnection(url, dbUser, dbPass);
            System.out.println("Database Connected!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
        }
        this.connection = conn;
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database Closed");
            }
        } catch (SQLException ex) {
            System.out.println("Failed to close the database.");
        }
    }

    public Object[] retrieveData(String nim) {
        try {
            String[] data = new String[10];
            String sql = "SELECT * FROM data_diri WHERE NIM = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                data[0] = resultSet.getString("NIM");
                data[1] = resultSet.getString("Nama_Mahasiswa");
                data[2] = resultSet.getString("Prodi");
                data[3] = resultSet.getString("Jenjang_Studi");
                data[4] = resultSet.getString("IPK");
                data[5] = resultSet.getString("Kontak");
                data[6] = resultSet.getString("Angkatan");
                data[7] = resultSet.getString("Semester");
                data[8] = resultSet.getString("Alamat");
                data[9] = resultSet.getString("TTL");
                return data; 
            }
        } catch (SQLException e) {
        }
        return null;
    }


    public boolean checkLogin(String id_pengguna, String password) {
        try {
            String sql = "SELECT * FROM pengguna WHERE ID_Pengguna = ? AND Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id_pengguna);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            return false; 
        }
    }

}
