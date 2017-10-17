package com.turboes.ht.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import static com.turboes.ht.util.Constant.SYNC_KEY;

/**
 * 作者：mrwang
 * 时间：2017/10/13:18:17
 * 邮箱：2384359843@qq.com
 * 说明：RFC 4615
 */
public class AesCmacPrf128 {
    public static byte[] encryptAesCmacPrf128(byte[] message, byte[] key) {
        AesCmac aesCmac = null;
        try {
            aesCmac = new AesCmac();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] trueKey;
        System.out.println("keylen" + key.length + "," + Arrays.toString(key));
        if (key.length == 16) {
            trueKey = key;
        } else {
            SecretKey convertKey = new SecretKeySpec(Hex.hexStringToBytes("00000000000000000000000000000000"), "AES");
            try {
                aesCmac.init(convertKey);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
            trueKey = aesCmac.calculateHash(key);
            System.out.println("trueKey" + Arrays.toString(trueKey));
        }

        try {
            aesCmac = new AesCmac();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        SecretKey initKey = new SecretKeySpec(trueKey, "AES");
        try {
            aesCmac.init(initKey);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return aesCmac.calculateHash(message);
    }

    public static byte[] toAesCmacPrf128() {
        return encryptAesCmacPrf128(Hex.hexStringToBytes("20171013000000031000000000000000"), SYNC_KEY.getBytes());
    }

    public static void main(String[] args) {
//        System.out.println(Hex.bytesToHexString(toAesCmacPrf128()));
//        980ae87b5f4c9c5214f5b6a8455e4c2d
        System.out.println(Hex.bytesToHexString(encryptAesCmacPrf128(Hex.hexStringToBytes("000102030405060708090a0b0c0d0e0f10111213"), Hex.hexStringToBytes("000102030405060708090a0b0c0d0e0f"))));
//        84a348a4a45d235babfffc0d2b4da09a
        System.out.println(Hex.bytesToHexString(encryptAesCmacPrf128(Hex.hexStringToBytes("000102030405060708090a0b0c0d0e0f10111213"), Hex.hexStringToBytes("000102030405060708090a0b0c0d0e0fedcb"))));
//        290d9e112edb09ee141fcf64c0b72f3d
        System.out.println(Hex.bytesToHexString(encryptAesCmacPrf128(Hex.hexStringToBytes("000102030405060708090a0b0c0d0e0f10111213"), Hex.hexStringToBytes("00010203040506070809"))));
    }
}
