package io.streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamEtcMain {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/data.dat");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("회원A");
        dos.writeInt(20);
        dos.writeDouble(10.5);
        dos.writeBoolean(true);
        dos.close();

        FileInputStream fis = new FileInputStream("temp/data.dat");
        DataInputStream dis = new DataInputStream(fis);
        // 저장한 순서대로 읽어야 한다.
        System.out.println("dis.readUTF() = " + dis.readUTF());
        System.out.println("dis.readInt() = " + dis.readInt());
        System.out.println("dis.readDouble() = " + dis.readDouble());
        System.out.println("dis.readBoolean() = " + dis.readBoolean());
    }
}
