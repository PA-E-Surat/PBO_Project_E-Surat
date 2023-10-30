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
            String dbName = "e-suratdata";
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
    
//    public String[] retrieveData(String nim) {
//        try {
//            String[] data = new String[2]; // Assuming there are 2 values to retrieve (nim and nama_mahasiswa)
//            String sql = "SELECT NIM, Nama_Mahasiswa FROM data_diri WHERE NIM = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, nim);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                data[0] = resultSet.getString("NIM");
//                data[1] = resultSet.getString("Nama_Mahasiswa");
//                return data;
//            } else {
//                return null;
//            }
//        } catch (SQLException e) {
//            // Handle the exception appropriately
//            e.printStackTrace();
//            return null;
//        }
//    }


    public Object[] retrieveData(String nim) {
        try {
            String[] data = new String[10]; // Array to store the data for all columns
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
                return data; // Return the data as an array
            }
        } catch (SQLException e) {
            // Handle the error appropriately
        }
        return null; // Return null if nim is not found
    }



    public boolean checkLogin(String id_pengguna, String password) {
        try {
            String sql = "SELECT * FROM mahasiswa WHERE ID_Pengguna = ? AND Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id_pengguna);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // True if login is successful, false if not
        } catch (SQLException e) {
            return false;  // Handle the error appropriately
        }
    }

}
