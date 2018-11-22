package com.turboes.install.device.controller;

import java.math.BigInteger;
import java.util.Stack;

//未完善
public class AryUtil {
    private static String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private static char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    final static char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '+', '/',
    };

    public static void main(String[] args) {

//        9223372036854775807
//		System.out.println("[1001]64-to-十进制:"+_64_to_10("1001")+"---十进制 to 62:"+_10_to_62(_64_to_10("1001"),1)+"---62 to 十进制:"+Long.parseLong(_62_to_10(_10_to_62(_64_to_10("1001"),1)))+"---十进制 to 64:"+_10_to_64(Long.parseLong(_62_to_10(_10_to_62(_64_to_10("1001"),1))),6));
//    	System.out.println("[E0001]64-to-十进制:"+_64_to_10("E0001")+"---十进制 to 62:"+_10_to_62(_64_to_10("E0001"),1)+"---62 to 十进制:"+Long.parseLong(_62_to_10(_10_to_62(_64_to_10("E0001"),1)))+"---十进制 to 64:"+_10_to_64(Long.parseLong(_62_to_10(_10_to_62(_64_to_10("E0001"),1))),6));
//    	System.out.println("[sy]64 to-十-进制:"+_64_to_10("SYPD")+"---十进制 to 62:"+_10_to_62(_64_to_10("SYPD"),1)+"---62 to 十进制:"+Long.parseLong(_62_to_10(_10_to_62(_64_to_10("SYPD"),1)))+"---十进制 to 64:"+_10_to_64(Long.parseLong(_62_to_10(_10_to_62(_64_to_10("SYPD"),1))),6));
//    	System.out.println("[abc]64-to-十进制:"+_64_to_10("abc")+"---十进制 to 62:"+_10_to_62(_64_to_10("abc"),1)+"--- 62 to 十进制:"+Long.parseLong(_62_to_10(_10_to_62(_64_to_10("abc"),1)))+"---十进制 to 64:"+_10_to_64(Long.parseLong(_62_to_10(_10_to_62(_64_to_10("abc"),1))),6));

        System.out.println(_10_to_62_(new BigInteger("9223372036854775807777777"), 0));
    }

    /**
     * 将62进制转换成10进制数
     *
     * @param ident62
     * @return
     */
    public static String _62_to_10(String ident62) {
        int decimal = 0;
        int base = 62;
        int keisu = 0;
        int cnt = 0;

        byte ident[] = ident62.getBytes();
        for (int i = ident.length - 1; i >= 0; i--) {
            int num = 0;
            if (ident[i] > 48 && ident[i] <= 57) {
                num = ident[i] - 48;
            } else if (ident[i] >= 65 && ident[i] <= 90) {
                num = ident[i] - 65 + 10;
            } else if (ident[i] >= 97 && ident[i] <= 122) {
                num = ident[i] - 97 + 10 + 26;
            }
            keisu = (int) java.lang.Math.pow((double) base, (double) cnt);
            decimal += num * keisu;
            cnt++;
        }
        return String.format("%08d", decimal);
    }

    /**
     * 把64进制的字符串转换成10进制
     *
     * @param decompStr
     * @return
     */
    private static long _64_to_10(String decompStr) {
        long result = 0;
        for (int i = decompStr.length() - 1; i >= 0; i--) {
            if (i == decompStr.length() - 1) {
                result += getCharIndexNum(decompStr.charAt(i));
                continue;
            }
            for (int j = 0; j < digits.length; j++) {
                if (decompStr.charAt(i) == digits[j]) {
                    result += ((long) j) << 6 * (decompStr.length() - 1 - i);
                }
            }
        }
        return result;
    }

    /**
     * 把10进制的数字转换成64进制
     *
     * @param number
     * @param shift
     * @return
     */
    private static String _10_to_64(long number, int shift) {
        char[] buf = new char[64];
        int charPos = 64;
        int radix = 1 << shift;
        long mask = radix - 1;
        do {
            buf[--charPos] = digits[(int) (number & mask)];
            number >>>= shift;
        } while (number != 0);
        return new String(buf, charPos, (64 - charPos));
    }

    /**
     * @param ch
     * @return
     */
    private static long getCharIndexNum(char ch) {
        int num = ((int) ch);
        if (num >= 48 && num <= 57) {
            return num - 48;
        } else if (num >= 97 && num <= 122) {
            return num - 87;
        } else if (num >= 65 && num <= 90) {
            return num - 29;
        } else if (num == 43) {
            return 62;
        } else if (num == 47) {
            return 63;
        }
        return 0;
    }

    /**
     * 将10进制转化为62进制
     *
     * @param number
     * @param length 转化成的62进制长度，不足length长度的话高位补0，否则不改变什么
     * @return
     */
    public static String _10_to_62(long number, int length) {
        Long rest = number;
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder(0);
        while (rest != 0) {
            stack.add(charSet[new Long((rest - (rest / 62) * 62)).intValue()]);
            rest = rest / 62;
        }
        for (; !stack.isEmpty(); ) {
            result.append(stack.pop());
        }
        int result_length = result.length();
        StringBuilder temp0 = new StringBuilder();
        for (int i = 0; i < length - result_length; i++) {
            temp0.append('0');
        }

        return temp0.toString() + result.toString();

    }

    public static String _10_to_62_(BigInteger number, int length) {
        BigInteger rest = number;
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder(0);
        while (rest.longValue() != 0) {
            int i = rest.subtract((rest.divide(BigInteger.valueOf(62))).multiply(BigInteger.valueOf(62))).intValue();
            System.out.println(i);
            stack.add(charSet[i]);
            rest = rest.divide(BigInteger.valueOf(62));
        }
        for (; !stack.isEmpty(); ) {
            result.append(stack.pop());
        }
        int result_length = result.length();
        StringBuilder temp0 = new StringBuilder();
        for (int i = 0; i < length - result_length; i++) {
            temp0.append('0');
        }

        return temp0.toString() + result.toString();

    }


//    public static void main(String[] args) {
//        String a = "7fffffffffffffff";
//        Long b = 9223372036854775807L;
//        Long c = 0xffffffffffffffffL;
//        String d="ffffffffffffffff";
//        String s = Long.toHexString(b);
//        String s1 = Long.toBinaryString(c);
//        Long aLong = Long.valueOf(a, 16);
//        System.out.println(s);
//        System.out.println(s1);
//        System.out.println(aLong);
//
//    }
}
