package com.gut.waniusza.semestr_5.sieciTelekom.helper;

/**
 *
 * @author student
 */
public class BinaryHelper {

    public static String toBinary(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for (int i = 0; i < Byte.SIZE * bytes.length; i++) {
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        }
        return sb.toString();
    }

    public static String toBinary(byte byt) {

        StringBuilder sb = new StringBuilder(Byte.SIZE);
        for (int i = 0; i < Byte.SIZE; i++) {
            sb.append((byt << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        }
        return sb.toString();
    }

    public static int unsignedToBytes(byte b) {
        return b & 0xFF;
    }

}
