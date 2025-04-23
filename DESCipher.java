import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class DESCipher {

    private SecretKey key;

    public DESCipher(String keyString) {
        // A chave deve ter exatamente 8 bytes para DES
        byte[] keyBytes = keyString.getBytes(StandardCharsets.UTF_8);
        byte[] keyBytes8 = new byte[8];
        System.arraycopy(keyBytes, 0, keyBytes8, 0, Math.min(keyBytes.length, 8));
        this.key = new SecretKeySpec(keyBytes8, "DES");
    }

    public String encrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedText) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        try {
            String key = "password";  // Deve ter 8 caracteres
            DESCipher desCipher = new DESCipher(key);

            String plaintext = "Hello, World!";
            String encrypted = desCipher.encrypt(plaintext);
            System.out.println("Texto criptografado: " + encrypted);

            String decrypted = desCipher.decrypt(encrypted);
            System.out.println("Texto descriptografado: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
