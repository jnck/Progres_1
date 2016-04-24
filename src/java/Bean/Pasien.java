/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Farewell
 */
public class Pasien {
    
    private int id_mr;
    private String nama_pasien;
    private String jenis_kelamin;
    private String ttl;
    private String status_perkawinan;
    private String alamat_pasien;
    private String telepon;

    /**
     * @return the id_mr
     */
    public int getId_mr() {
        return id_mr;
    }

    /**
     * @param id_mr the id_mr to set
     */
    public void setId_mr(int id_mr) {
        this.id_mr = id_mr;
    }

    /**
     * @return the nama_pasien
     */
    public String getNama_pasien() {
        return nama_pasien;
    }

    /**
     * @param nama_pasien the nama_pasien to set
     */
    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    /**
     * @return the jenis_kelamin
     */
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    /**
     * @param jenis_kelamin the jenis_kelamin to set
     */
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    /**
     * @return the ttl
     */
    public String getTtl() {
        return ttl;
    }

    /**
     * @param ttl the ttl to set
     */
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
    
    /**
     * @return the status_perkawinan
     */
    public String getStatus_perkawinan() {
        return status_perkawinan;
    }

    /**
     * @param status_perkawinan the status_perkawinan to set
     */
    public void setStatus_perkawinan(String status_perkawinan) {
        this.status_perkawinan = status_perkawinan;
    }
    
    /**
     * @return the alamat_pasien
     */
    public String getAlamat_pasien() {
        return alamat_pasien;
    }

    /**
     * @param alamat_pasien the alamat_pasien to set
     */
    public void setAlamat_pasien(String alamat_pasien) {
        this.alamat_pasien = alamat_pasien;
    }
    
    /**
     * @return the telepon
     */
    public String getTelepon() {
        return telepon;
    }

    /**
     * @param telepon the telepon to set
     */
    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

}