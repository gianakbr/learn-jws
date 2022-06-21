/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barang.controller;

import com.barang.koneksi.DBKoneksi;
import com.barang.model.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gian
 */
public class BarangController {
        public static Connection conn;

    public BarangController() {
    }

    public BarangController(Connection conn) {
        this.conn = conn;
    }

    public static BarangController getKoneksi() {
        BarangController barangController = new BarangController(DBKoneksi.getConnectionDB());
        return barangController;
    }

    public List<Barang> getAllBarang() {
        ArrayList<Barang> barangs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM BARANG";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Barang brg = new Barang();
                brg.setId(rs.getLong("id"));
                brg.setNama(rs.getString("nama"));
                brg.setDeskripsi(rs.getString("deskripsi"));
                brg.setHarga(rs.getInt("harga"));
                brg.setKategori(rs.getString("kategori"));
                brg.setStok(rs.getInt("stok"));
                barangs.add(brg);
            }
            conn.commit();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        return barangs;
    }

    public Barang getBarang(Long id) {
        Barang brg = new Barang();
        ArrayList<Barang> Daftarbrg = new ArrayList<>();
        try {
            String sql = "SELECT * FROM BARANG WHERE id  = " + id;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                brg.setId(rs.getLong("id"));
                brg.setNama(rs.getString("nama"));
                brg.setDeskripsi(rs.getString("deskripsi"));
                brg.setKategori(rs.getString("kategori"));
                brg.setStok(rs.getInt("stok"));
                brg.setHarga(rs.getInt("harga"));
            }
            conn.commit();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        return brg;
    }

    public void insertBarang(Barang brg) {
        try {
            String sql = "INSERT INTO BARANG(nama,deskripsi,kategori,stok,harga) VALUES(?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, brg.getNama());
            st.setString(2, brg.getDeskripsi());
            st.setString(3, brg.getKategori());
            st.setInt(4, brg.getStok());
            st.setInt(5, brg.getHarga());
            st.executeUpdate();
            conn.commit();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateBarang(Barang brg) {
        try {
            String sql = "UPDATE BARANG SET nama=?,deskripsi=?,kategori=?,stok=?,harga=? WHERE id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, brg.getNama());
            st.setString(2, brg.getDeskripsi());
            st.setString(3, brg.getKategori());
            st.setInt(4, brg.getStok());
            st.setInt(5, brg.getHarga());
            st.setLong(6, brg.getId());
            st.executeUpdate();
            conn.commit();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteBarang(Long id) {
        try {
            String sql = "DELETE FROM BARANG WHERE id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setLong(1, id);
            st.executeUpdate();
            conn.commit();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
//        Test method
        BarangController bc = BarangController.getKoneksi();

//        Method insertBarang
//        Barang b = new Barang("Pena Pilot", "Pena Pilot Ukuran 0.4", "Pena", 200, 5000);
//        bc.insertBarang(b);

//        Method getAllBarang
 //         System.out.println(bc.getAllBarang());
        
//        Method getBarang
//        System.out.println(bc.getBarang(8L));

//        Method updateBarang
//        Barang b2 = new Barang(8L, "Pena Pilot", "Pena Pilot Ukuran 0.4", "Pena", 200, 5400);
//        bc.updateBarang(b2);

//        Method deleteBarang
//        bc.deleteBarang(8L);

// Semua method sudah oke. :)
    }
}
