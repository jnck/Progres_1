package DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import Bean.Umum;
import static DAO.FD.FD;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Date;
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
public class UmumDao {
    private final Connection conn;    
    public UmumDao(){
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

    public static String encrypt(String unencryptedString,String myEncryptionKey) {
        String encryptedString = null;      
        try {            
            long waktu = 0;  
            for (int i = 1; i <= 20; i++) {
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
            System.out.println("Total waktu Enkripsi dari 20 percobaan : "+waktu+" ns");
            System.out.println("Rata-rata waktu Enkripsi dari 20 percobaan : "+waktu/20+" ns");
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
            for (int i = 1; i <= 20; i++) {
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
            System.out.println("Total waktu Dekripsi dari 20 percobaan : "+waktu+" ns");
            System.out.println("Rata-rata waktu Dekripsi dari 20 percobaan : "+waktu/20+" ns");
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
    
    public static Umum readSmart() throws IOException{
        String data;
        data = FilesUtil.readTextFile(FD()+":/privasi.dat");
        String[] kunci = data.split(",");
        UmumDao dd = new UmumDao();
        Umum umum = new Umum();
        int id = Integer.parseInt(kunci[0]);
        umum.setId_mr(id);
        umum.setNama_pasien(kunci[1]);               
        return umum;
    }
    
    public void addUmum(Umum umum) throws Exception{
        String data;
        data = FilesUtil.readTextFile(FD()+":/privasi.dat");
        String[] kunci = data.split(",");
        String private_data;
        try {
            String insertQuery="insert into master_umum(id_mr, nama_pasien, tinggi_badan, berat_badan, tekanan_darah, pernafasan, keadaan_umum, status_gizi, kesadaran, nadi, anamnesa) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prSt = conn.prepareStatement(insertQuery);
            prSt.setInt(1, umum.getId_mr());
            prSt.setString(2, umum.getNama_pasien());
            prSt.setString(3, encrypt(umum.getTinggi_badan(),kunci[2]));
            prSt.setString(4, encrypt(umum.getBerat_badan(),kunci[2]));
            prSt.setString(5, encrypt(umum.getTekanan_darah(),kunci[2]));
            prSt.setString(6, encrypt(umum.getPernafasan(),kunci[2]));
            prSt.setString(7, encrypt(umum.getKeadaan_umum(),kunci[2]));
            prSt.setString(8, encrypt(umum.getStatus_gizi(),kunci[2]));
            prSt.setString(9, encrypt(umum.getKesadaran(),kunci[2]));
            prSt.setString(10, encrypt(umum.getNadi(),kunci[2]));
            prSt.setString(11, encrypt(umum.getAnamnesa(),kunci[2]));
            prSt.executeUpdate();
        }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deleteUmumById(int umumID){
        try {
            String deleteQuery="delete from master_umum where id_mr=?";            
            PreparedStatement prSt = conn.prepareStatement(deleteQuery);
            prSt.setInt(1, umumID);            
            prSt.executeUpdate();            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Umum findUmumById(int umumID) throws IOException{
         String data;
         data = FilesUtil.readTextFile(FD()+":/privasi.dat");
         String[] kunci = data.split(",");
         UmumDao dd = new UmumDao();
         Umum umum = new Umum();
         try {
            String deleteQuery="select * from master_umum where id_mr=?";            
            PreparedStatement prSt = conn.prepareStatement(deleteQuery);
            prSt.setInt(1, umumID);            
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                umum.setId_mr(umumID);
                umum.setNama_pasien(rs.getString(2));
                umum.setTinggi_badan(decrypt(rs.getString(3),kunci[2]));
                umum.setBerat_badan(decrypt(rs.getString(4),kunci[2]));
                umum.setTekanan_darah(decrypt(rs.getString(5),kunci[2]));
                umum.setPernafasan(decrypt(rs.getString(6),kunci[2]));
                umum.setKeadaan_umum(decrypt(rs.getString(7),kunci[2])); 
                umum.setStatus_gizi(decrypt(rs.getString(8),kunci[2]));
                umum.setKesadaran(decrypt(rs.getString(9),kunci[2]));
                umum.setNadi(decrypt(rs.getString(10),kunci[2]));
                umum.setAnamnesa(decrypt(rs.getString(11),kunci[2]));
            }            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return umum;
    }
    
    public void editUmum(Umum umum) throws IOException{
        String data;
        data = FilesUtil.readTextFile(FD()+":/privasi.dat");
        String[] kunci = data.split(",");
        try {
            String editQuery="update master_umum set nama_pasien=?, tinggi_badan=?, berat_badan=?, tekanan_darah=?, pernafasan=?, keadaan_umum=?, status_gizi=?, kesadaran=?, nadi=?, anamnesa=? where id_mr=?";            
            PreparedStatement prSt = conn.prepareStatement(editQuery);
            prSt.setString(1, umum.getNama_pasien());
            prSt.setString(2, encrypt(umum.getTinggi_badan(),kunci[2]));
            prSt.setString(3, encrypt(umum.getBerat_badan(),kunci[2]));
            prSt.setString(4, encrypt(umum.getTekanan_darah(),kunci[2]));
            prSt.setString(5, encrypt(umum.getPernafasan(),kunci[2]));
            prSt.setString(6, encrypt(umum.getKeadaan_umum(),kunci[2]));            
            prSt.setString(7, encrypt(umum.getStatus_gizi(),kunci[2]));
            prSt.setString(8, encrypt(umum.getKesadaran(),kunci[2]));
            prSt.setString(9, encrypt(umum.getNadi(),kunci[2]));
            prSt.setString(10,encrypt(umum.getAnamnesa(),kunci[2]));
            prSt.setInt(11, umum.getId_mr());   
            System.out.println(prSt);
            prSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List retrieveUmum() throws IOException{
        String data;
        data = FilesUtil.readTextFile(FD()+":/privasi.dat");
        String[] kunci = data.split(",");
        List sumum = new ArrayList();
        UmumDao dd = new UmumDao();        
        try {
            String retrieveQuery = "select * from master_umum";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(retrieveQuery);
            while(rs.next()){
                Umum umum = new Umum();
                umum.setId_mr(rs.getInt(1));
                umum.setNama_pasien(rs.getString(2));
                umum.setTinggi_badan(decrypt(rs.getString(3),kunci[2]));
                umum.setBerat_badan(decrypt(rs.getString(4),kunci[2]));
                umum.setTekanan_darah(decrypt(rs.getString(5),kunci[2]));
                umum.setPernafasan(decrypt(rs.getString(6),kunci[2]));
                umum.setKeadaan_umum(decrypt(rs.getString(7),kunci[2]));
                umum.setStatus_gizi(decrypt(rs.getString(8),kunci[2]));
                umum.setKesadaran(decrypt(rs.getString(9),kunci[2]));
                umum.setNadi(decrypt(rs.getString(10),kunci[2]));
                umum.setAnamnesa(decrypt(rs.getString(11),kunci[2]));
                sumum.add(umum);                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(UmumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return sumum;
    }
}