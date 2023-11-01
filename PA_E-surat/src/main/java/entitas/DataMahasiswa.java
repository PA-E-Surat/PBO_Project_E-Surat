package entitas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.Database;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataMahasiswa extends Database {

     public final String[] retrieveData(String nim) {
        try {
            openConnection();

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
    } catch (SQLException ex) {
        Logger.getLogger(DataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
    
    public final boolean checkLogin(String id_pengguna, String password) {
        boolean loginSuccessful = false;

        try {
            openConnection();

            String sql = "SELECT * FROM pengguna WHERE ID_Pengguna = ? AND Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id_pengguna);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            loginSuccessful = resultSet.next();
        } catch (SQLException e) {
        } finally {
            closeConnection();
        }

        return loginSuccessful;
    }
    
//    public final boolean updateData() {
//    boolean updateSuccessful = false;
//
//    try {
//        this.openConnection();
//
//        String sql = "UPDATE `data_diri` SET `NIM`=?, `Nama_Mahasiswa`=?, `Prodi`=?, `Jenjang_Studi`=?, `IPK`=?, `Kontak`=?, `Angkatan`=?, `Semester`=?, `Alamat`=?, `TTL`=? WHERE 1";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//        preparedStatement.setString(1, this.nim);
//        preparedStatement.setString(2, this.nama_mahasiswa);
//        preparedStatement.setString(3, this.prodi);
//        preparedStatement.setString(4, this.jenjang_studi);
//        preparedStatement.setDouble(5, this.ipk);
//        preparedStatement.setString(6, this.kontak);
//        preparedStatement.setString(7, this.angkatan);
//        preparedStatement.setString(8, this.semester);
//        preparedStatement.setString(9, this.alamat);
//        preparedStatement.setString(10, this.ttl);
//
//        int result = preparedStatement.executeUpdate();
//
//        if (result > 0) {
//            updateSuccessful = true;
//        }
//
//    } catch (SQLException ex) {
//    } finally {
//        closeConnection();
//    }
//    return updateSuccessful;
//    }
}

    