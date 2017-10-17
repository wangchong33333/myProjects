package com.turboes.ht.util;

/**
 * 作者：mrwang
 * 时间：2017/9/28:17:36
 * 邮箱：2384359843@qq.com
 * 说明：
 */

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesCmac {
    private static final byte CONSTANT = (byte) 0x87;
    private static final int BLOCK_SIZE = 16;
    private static final IvParameterSpec ZERO_IV = new IvParameterSpec(new byte[16]);

    private int macLength;
    private Cipher aesCipher;

    private byte[] buffer;
    private int bufferCount;

    private byte[] k1;
    private byte[] k2;

    public AesCmac() throws NoSuchAlgorithmException {
        this(BLOCK_SIZE);
    }

    public AesCmac(int length) throws NoSuchAlgorithmException {
        if (length > BLOCK_SIZE) {
            throw new NoSuchAlgorithmException("AES CMAC maximum length is " + BLOCK_SIZE);
        }

        try {
            macLength = length;
            aesCipher = Cipher.getInstance("AES/CBC/NOPADDING");
            buffer = new byte[BLOCK_SIZE];
        } catch (NoSuchPaddingException nspe) {
            nspe.printStackTrace();
        }
    }

    private byte[] doubleSubKey(byte[] k) {
        byte[] ret = new byte[k.length];

        boolean firstBitSet = ((k[0] & 0x80) != 0);
        for (int i = 0; i < k.length; i++) {
            ret[i] = (byte) (k[i] << 1);
            if (i + 1 < k.length && ((k[i + 1] & 0x80) != 0)) {
                ret[i] |= 0x01;
            }
        }
        if (firstBitSet) {
            ret[ret.length - 1] ^= CONSTANT;
        }
        return ret;
    }

    public final void init(Key key) throws InvalidKeyException {
        if (!(key instanceof SecretKeySpec)) {
            throw new InvalidKeyException("Key is not of required type SecretKey.");
        }
        if (!((SecretKeySpec) key).getAlgorithm().equals("AES")) {
            throw new InvalidKeyException("Key is not an AES key.");
        }
        try {
            aesCipher.init(Cipher.ENCRYPT_MODE, key, ZERO_IV);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

        // First calculate k0 from zero bytes
        byte[] k0 = new byte[BLOCK_SIZE];
        try {
            aesCipher.update(k0, 0, k0.length, k0, 0);
        } catch (ShortBufferException sbe) {
        }

        // Calculate values for k1 and k2
        k1 = doubleSubKey(k0);
        k2 = doubleSubKey(k1);

        try {
            aesCipher.init(Cipher.ENCRYPT_MODE, key, ZERO_IV);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        bufferCount = 0;
    }

    public final void updateByte(byte b) {
        updateBlock(new byte[]{b});
    }

    public final void updateBlock(byte[] data) {
        int currentOffset = 0;

        if (data.length < BLOCK_SIZE - bufferCount) {
            System.arraycopy(data, 0, buffer, bufferCount, data.length);
            bufferCount += data.length;
            return;
        } else if (bufferCount > 0) {
            System.arraycopy(data, 0, buffer, bufferCount, BLOCK_SIZE - bufferCount);
            try {
                aesCipher.update(buffer, 0, BLOCK_SIZE, buffer, 0);
            } catch (ShortBufferException sbe) {
            }
            currentOffset += BLOCK_SIZE - bufferCount;
            bufferCount = 0;
        }

        // Transform all the full blocks in data
        while (currentOffset + BLOCK_SIZE < data.length) {
            try {
                aesCipher.update(data, currentOffset, BLOCK_SIZE, buffer, 0);
            } catch (ShortBufferException sbe) {
            }
            currentOffset += BLOCK_SIZE;
        }

        // Save the leftover bytes to buffer
        if (currentOffset != data.length) {
            System.arraycopy(data, currentOffset, buffer, 0, data.length - currentOffset);
            bufferCount = data.length - currentOffset;
        }
    }

    public final byte[] doFinal() {
        byte[] subKey = k1;
        if (bufferCount < BLOCK_SIZE) {
            // Add padding and XOR with k2 instead
            buffer[bufferCount] = (byte) 0x80;
            for (int i = bufferCount + 1; i < BLOCK_SIZE; i++)
                buffer[i] = (byte) 0x00;
            subKey = k2;
        }
        for (int i = 0; i < BLOCK_SIZE; i++) {
            buffer[i] ^= subKey[i];
        }

        // Calculate the final CMAC calue
        try {
            aesCipher.doFinal(buffer, 0, BLOCK_SIZE, buffer, 0);
        }
        // These should never happen because we pad manually
        catch (ShortBufferException sbe) {
        } catch (IllegalBlockSizeException ibse) {
        } catch (BadPaddingException ibse) {
        }
        bufferCount = 0;

        byte[] mac = new byte[macLength];
        System.arraycopy(buffer, 0, mac, 0, macLength);
        return mac;
    }

    public final byte[] calculateHash(byte[] data) {
        updateBlock(data);
        return doFinal();
    }

    public static byte[] calculateDiverseKey(byte[] input) throws InvalidKeyException, NoSuchAlgorithmException {
        AesCmac mac = null;
        mac = new AesCmac();
//        SecretKey key = new SecretKeySpec(Hex.hexStringToBytes("000102030405060708090a0b0c0d0e0f"), "AES");
        SecretKey key = new SecretKeySpec(Hex.hexStringToBytes("2b7e151628aed2a6abf7158809cf4f3c"), "AES");
//        SecretKey key = new SecretKeySpec(SYNC_KEY.getBytes(), "AES");
        mac.init(key);  //set master key
        mac.updateBlock(input); //given input
//        for (byte b : input) System.out.print(" " + b);

        return mac.doFinal();
    }

    public static void main(String[] args) {
        try {
//            980ae87b5f4c9c5214f5b6a8455e4c2d
//            System.out.println(Hex.bytesToHexString(calculateDiverseKey(Hex.hexStringToBytes("000102030405060708090a0b0c0d0e0f10111213"))));

//            070a16b46b4d4144f79bdd9dd04a287c
            System.out.println(Hex.bytesToHexString(calculateDiverseKey(Hex.hexStringToBytes("6bc1bee22e409f96e93d7e117393172a"))));
//            dfa66747de9ae63030ca32611497c827
            System.out.println(Hex.bytesToHexString(calculateDiverseKey(Hex.hexStringToBytes("6bc1bee22e409f96e93d7e117393172a" +
                    "ae2d8a571e03ac9c9eb76fac45af8e5130c81c46a35ce411"))));
//            51f0bebf7e3b9d92fc49741779363cfe
            System.out.println(Hex.bytesToHexString(calculateDiverseKey(Hex.hexStringToBytes("6bc1bee22e409f96e93d7e117393172a" +
                    "ae2d8a571e03ac9c9eb76fac45af8e51" +
                    "30c81c46a35ce411e5fbc1191a0a52ef" +
                    "f69f2445df4f9b17ad2b417be66c3710"))));

//            System.out.println(Hex.bytesToHexString(calculateDiverseKey(Hex.hexStringToBytes("2017101300000003"))));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
