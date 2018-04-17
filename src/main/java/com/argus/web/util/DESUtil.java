package com.argus.web.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by xingding on 18/4/14.
 */
public class DESUtil {
    //算法名称
    public static final String DES = "DES";
    /*
    工作模式：ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
    填充方式：NoPadding:不填充、ZerosPadding: 0填充、PKCS5Padding
    DES、AES 或者 3DES 属于块加密算法，一般来说原文必须是 8 的整数倍，所以块加密算法除子加密模式之外，还涉及到一个填充模式。
    如果用 NoPadding 的话，那么必须保证原文字节是 8 的倍数，否则的话需要使用其他的填充模式。
     */
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    //密钥字符串,自定义,长度=8,如果长度<8,会抛出异常"Wrong key size"
//    public static final String KEY = "1qazxsw2";
    public static final String KEY_STR = "adab9197924a4c85"; //用initKey()方法产生一个密钥

    public static SecretKey KEY;

    static{
        try {
            DESKeySpec desKeySpec = new DESKeySpec(KEY_STR.getBytes());
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(DES);
            KEY = secretKeyFactory.generateSecret(desKeySpec);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    /**
     * 生成密钥key字符串(16进制表示)
     * @return
     */
    public static String initKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(DES);
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] secretKeyBytes = secretKey.getEncoded();
            String key = Hex.encodeHexString(secretKeyBytes);
            System.out.println("key: " + key);
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 加密数据
     * @param data
     * @return
     * @throws Exception
     */
    public static String encrypt(String data){
        try {
            //实例化Cipher对象,用于完成实际的加密操作
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            SecureRandom secureRandom = new SecureRandom();
            cipher.init(Cipher.ENCRYPT_MODE, KEY, secureRandom);
            byte[] results = cipher.doFinal(data.getBytes());
            //加密后的结果用base64字符串传输
            return Base64.encodeBase64String(results);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密数据
     * @param data
     * @return
     * @throws Exception
     */
    public static String decrypt(String data){
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE,KEY);
            byte[] results = cipher.doFinal(Base64.decodeBase64(data));
            return new String(results);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String source = "root";
        System.out.println("加密前: " + source);
        String encryptData = encrypt(source);
        System.out.println("加密后: " + encryptData);
        String decryptData = decrypt(encryptData);
        System.out.println("解密后: " + decryptData);
    }
}
