package DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import Bean.Pasien;
import static DAO.FD.FD;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import myUtil.ConnectionDB;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Farewell
 */
public class PasienDao {
    private final Connection conn;    
    public PasienDao(){
        conn = ConnectionDB.getConnectionDB();
    }
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private static KeySpec myKeySpec;
    private static SecretKeyFactory mySecretKeyFactory;
    private static Cipher cipher;
    public static byte[] keyAsBytes;
    private static String myEncryptionKey;
    private static String myEncryptionScheme;
    public static SecretKey key;
    
    public static enum Mode {
        ALPHA, ALPHANUMERIC, NUMERIC 
    }
	
    public static String generateRandomString(int length, Mode mode) throws Exception {
        StringBuilder buffer = new StringBuilder();
        String characters = "";
        switch(mode){
        case ALPHA:
                characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
        case ALPHANUMERIC:
                characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                break;
        case NUMERIC:
                characters = "1234567890";
            break;
        }
        int charactersLength = characters.length();
        for (int i = 0; i < length; i++) {
                double index = Math.random() * charactersLength;
                buffer.append(characters.charAt((int) index));
        }
        return buffer.toString();
    }

    public static String encrypt(String unencryptedString,String myEncryptionKey) {
        String encryptedString = null;      
        try {            
            long waktu = 0;  
            for (int i = 1; i <= 100; i++) {
                long lStartTime = System.nanoTime();
                myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
                keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
                myKeySpec = new DESedeKeySpec(keyAsBytes);
                mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
                cipher = Cipher.getInstance(myEncryptionScheme);
                key = mySecretKeyFactory.generateSecret(myKeySpec);
                cipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
                byte[] encryptedText = cipher.doFinal(plainText);
                BASE64Encoder base64encoder = new BASE64Encoder();
                encryptedString = base64encoder.encode(encryptedText);
                long lEndTime = System.nanoTime();
                long difference = lEndTime - lStartTime;
                System.out.println("Waktu Enkripsi "+unencryptedString+" ke-"+i+" adalah : "+difference+" ns");
                waktu = waktu + difference;
            }
            System.out.println("Total waktu Enkripsi dari 100 percobaan : "+waktu+" ns");
            System.out.println("Rata-rata waktu Enkripsi dari 100 percobaan : "+waktu/100+" ns");
            System.out.println("==================================");
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException | IllegalBlockSizeException | BadPaddingException e) {
        }
        return encryptedString;
    }
    /**
     * Method To Decrypt An Ecrypted String
     * @param encryptedString
     * @param myEncryptionKey
     * @return 
     */
    public static String decrypt(String encryptedString,String myEncryptionKey) {
        String decryptedText=null;
        try {
            long waktu = 0;  
            for (int i = 1; i <= 100; i++) {
                long lStartTime = System.nanoTime();
                myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
                keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
                myKeySpec = new DESedeKeySpec(keyAsBytes);
                mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
                cipher = Cipher.getInstance(myEncryptionScheme);
                key = mySecretKeyFactory.generateSecret(myKeySpec);		
                cipher.init(Cipher.DECRYPT_MODE, key);
                BASE64Decoder base64decoder = new BASE64Decoder();
                byte[] encryptedText = base64decoder.decodeBuffer(encryptedString);
                byte[] plainText = cipher.doFinal(encryptedText);
                decryptedText= bytes2String(plainText);
                long lEndTime = System.nanoTime();
                long difference = lEndTime - lStartTime;
                System.out.println("Waktu Dekripsi "+encryptedString+" ke-"+i+" adalah : "+difference+" ns");
                waktu = waktu + difference;
            }
            System.out.println("Total waktu Dekripsi dari 100 percobaan : "+waktu+" ns");
            System.out.println("Rata-rata waktu Dekripsi dari 100 percobaan : "+waktu/100+" ns");
            System.out.println("==================================");
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException | IOException | IllegalBlockSizeException | BadPaddingException e) {
        }
        return decryptedText;
    }
    private static String bytes2String(byte[] bytes) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append((char) bytes[i]);
        }
        return stringBuffer.toString();
    }
//    long lStartTime = System.currentTimeMillis();
//    //some tasks
//    long lEndTime = System.currentTimeMillis();
//
//    long difference = lEndTime - lStartTime;
//
//    System.out.println("Elapsed milliseconds: " + difference);
    public void addPasien(Pasien pasien) throws Exception{
        String Kunci = generateRandomString(32,Mode.ALPHANUMERIC);
        String private_data;
        try {
            String insertQuery="insert into master_pasien(id_mr, nama_pasien, jenis_kelamin, ttl, status_perkawinan, alamat_pasien, telepon) values(?,?,?,?,?,?,?)";
            PreparedStatement prSt = conn.prepareStatement(insertQuery);
            prSt.setInt(1, pasien.getId_mr());
            prSt.setString(2, pasien.getNama_pasien());
            prSt.setString(3, encrypt(pasien.getJenis_kelamin(),Kunci));
            prSt.setString(4, encrypt(pasien.getTtl(),Kunci));
            prSt.setString(5, encrypt(pasien.getStatus_perkawinan(),Kunci));
            prSt.setString(6, encrypt(pasien.getAlamat_pasien(),Kunci));
            prSt.setString(7, encrypt(pasien.getTelepon(),Kunci));
            prSt.executeUpdate();
            private_data = pasien.getId_mr()+","+pasien.getNama_pasien()+","+Kunci;
            FilesUtil.writeToTextFile(FD()+":/privasi.dat", private_data);
        }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletePasienById(int pasienID){
        try {
            String deleteQuery="delete from master_pasien where id_mr=?";            
            PreparedStatement prSt = conn.prepareStatement(deleteQuery);
            prSt.setInt(1, pasienID);            
            prSt.executeUpdate();            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Pasien findPasienById(int pasienID) throws IOException{
         String data;
         data = FilesUtil.readTextFile(FD()+":/privasi.dat");
         String[] kunci = data.split(",");
         PasienDao dd = new PasienDao();
         Pasien pasien = new Pasien();
         try {
            String deleteQuery="select * from master_pasien where id_mr=?";            
            PreparedStatement prSt = conn.prepareStatement(deleteQuery);
            prSt.setInt(1, pasienID);            
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                 pasien.setId_mr(pasienID);
                 pasien.setNama_pasien(rs.getString(2));
                 pasien.setJenis_kelamin(decrypt(rs.getString(3),kunci[2]));
                 pasien.setTtl(decrypt(rs.getString(4),kunci[2]));
                 pasien.setStatus_perkawinan(decrypt(rs.getString(5),kunci[2]));
                 pasien.setAlamat_pasien(decrypt(rs.getString(6),kunci[2]));
                 pasien.setTelepon(decrypt(rs.getString(7),kunci[2]));                 
            }            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pasien;
    }
    
    public void editPasien(Pasien pasien) throws IOException{
        String data;
        data = FilesUtil.readTextFile(FD()+":/privasi.dat");
        String[] kunci = data.split(",");
        try {
            String editQuery="update master_pasien set nama_pasien=?, jenis_kelamin=?, ttl=?, status_perkawinan=?, alamat_pasien=?, telepon=? where id_mr=?";            
            PreparedStatement prSt = conn.prepareStatement(editQuery);
            System.out.println(pasien.getNama_pasien()+pasien.getJenis_kelamin());
            prSt.setString(1, pasien.getNama_pasien());
            prSt.setString(2, encrypt(pasien.getJenis_kelamin(),kunci[2]));
            prSt.setString(3, encrypt(pasien.getTtl(),kunci[2]));
            prSt.setString(4, encrypt(pasien.getStatus_perkawinan(),kunci[2]));
            prSt.setString(5, encrypt(pasien.getAlamat_pasien(),kunci[2]));
            prSt.setString(6, encrypt(pasien.getTelepon(),kunci[2]));
            prSt.setInt(7, pasien.getId_mr());   
            System.out.println(prSt);
            prSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List retrievePasien() throws IOException{
        String data;
        data = FilesUtil.readTextFile(FD()+":/privasi.dat");
        String[] kunci = data.split(",");
        List spasien = new ArrayList();
        PasienDao dd = new PasienDao();        
        try {
            String retrieveQuery = "select * from master_pasien";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(retrieveQuery);
            while(rs.next()){
                 Pasien pasien = new Pasien();
                 pasien.setId_mr(rs.getInt(1));
                 pasien.setNama_pasien(rs.getString(2));
                 pasien.setJenis_kelamin(decrypt(rs.getString(3),kunci[2]));
                 pasien.setTtl(decrypt(rs.getString(4),kunci[2]));
                 pasien.setStatus_perkawinan(decrypt(rs.getString(5),kunci[2]));
                 pasien.setAlamat_pasien(decrypt(rs.getString(6),kunci[2]));
                 pasien.setTelepon(decrypt(rs.getString(7),kunci[2]));
                 spasien.add(pasien);                 
            }           
        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return spasien;
    }
}