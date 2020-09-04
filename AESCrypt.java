import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
// import org.apache.commons.codec.binary.Base64;

import java.util.Base64;

public class AESCrypt {

    private static String CIPHER_NAME = "AES/CBC/PKCS5PADDING";
    private static int CIPHER_KEY_LEN = 16; //128 bits

    /**
     * Encrypt data using AES Cipher (CBC) with 128 bit key
     * 
     * 
     * @param key  - key to use should be 16 bytes long (128 bits)
     * @param iv - initialization vector
     * @param data - data to encrypt
     * @return encryptedData data in base64 encoding with iv attached at end after a :
     */

    public static void main(String []args){
         System.out.println("Encrypt " + encrypt("b8f9uN(+ZbB8Qh"<", "WORDING_ENCRYPT"));
         System.out.println("Decrypt " + decrypt("b8f9uN(+ZbB8Qh"<", encrypt("b8f9uN(+ZbB8Qh", "WORDING_ENCRYPT")));
    }

    public static String encrypt(String key, String value) 
    {
        try {
            IvParameterSpec iv = new IvParameterSpec(key.substring(0, 16).getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes("UTF-8"));

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(key.substring(0, 16).getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            // byte[] decrypted = cipher.doFinal(value.getBytes("UTF-8"));
            byte[] decrypted = Base64.getDecoder().decode(value);
            byte[] original = cipher.doFinal(decrypted);
            // return Base64.getDecoder().decode(decrypted);
            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
