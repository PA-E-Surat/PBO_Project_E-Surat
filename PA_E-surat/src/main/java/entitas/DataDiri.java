package entitas;

import controller.DataUpdate;
import database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataDiri extends Database {
    private String nim;
    private String alamat;
    private String tempatLahir;
    private String angkatan;
    private String ipk;
    private String program;
    private String jenjang;
    private String kontak;

    public DataDiri() {
        this.nim = nim;
    }

     public final String[] readData(String nim) {
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
        Logger.getLogger(DataDiri.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
    
   public final boolean updateData(DataUpdate dataUpdate) {
        boolean updateSuccessful = false;

        try {
            openConnection();

            String sql = "UPDATE data_diri SET Alamat = ?, Prodi = ?, Jenjang_Studi = ?, IPK = ?, Kontak = ?, Angkatan = ?, Semester = ?, TTL = ? WHERE NIM = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dataUpdate.getAlamat());
            preparedStatement.setString(2, dataUpdate.getProgram());
            preparedStatement.setString(3, dataUpdate.getJenjang());
            preparedStatement.setString(4, dataUpdate.getIpk());
            preparedStatement.setString(5, dataUpdate.getKontak());
            preparedStatement.setString(6, dataUpdate.getAngkatan());
            preparedStatement.setString(7, dataUpdate.getSemester());
            preparedStatement.setString(8, dataUpdate.getTanggalLahir());
            preparedStatement.setString(9, dataUpdate.getNim());

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                updateSuccessful = true;
            }
        } catch (SQLException e) {
        } finally {
            closeConnection();
        }

        return updateSuccessful;
    }

}
