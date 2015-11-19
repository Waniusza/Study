package com.gut.waniusza.semestr_5.sieciTelekom.ex_2;

import com.gut.waniusza.semestr_5.sieciTelekom.helper.BinaryHelper;

/**
 *
 * @author student
 */
public class Pack {

    private byte[] paczka;

    public Pack(int packNumber, byte[] data, int packagesCount) {
        paczka = new byte[2 + Config.MAX_PACKAGES_COUNT + Config.MAX_PACKAGES_SIZE];
        paczka[0] = (byte) (packagesCount / 255);
        paczka[1] = (byte) (packagesCount % 255);
        paczka[2] = (byte) (packNumber / 255);
        paczka[3] = (byte) (packNumber % 255);
        for (int i = 0; i < data.length; i++) {
            paczka[i + 4] = data[i];
        }
    }

    public Pack(int packNumber, byte[] data, int packagesCount, int lastPackageSize) {
        paczka = new byte[2 + Config.MAX_PACKAGES_COUNT + lastPackageSize];
        paczka[0] = (byte) (packagesCount / 255);
        paczka[1] = (byte) (packagesCount % 255);
        paczka[2] = (byte) (packNumber / 255);
        paczka[3] = (byte) (packNumber % 255);
        for (int i = 0; i < data.length; i++) {
            paczka[i + 4] = data[i];
        }
    }

    @Override
    public String toString() {
        String result = "";
        result += "numer paczki ";
        result += (BinaryHelper.unsignedToBytes(paczka[2]) * 255 + BinaryHelper.unsignedToBytes(paczka[3])) + " :: ";
        result += "lacznie paczek: ";
        result += (BinaryHelper.unsignedToBytes(paczka[0]) * 255 + BinaryHelper.unsignedToBytes(paczka[1])) + " :: ";
        result += " dane paczki:  ";
        for (int i = 0; i < paczka.length - 4; i++) {
            result += BinaryHelper.toBinary(paczka[i + 4]);
        }
        return result;
    }

}
