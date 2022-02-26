package dubbo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hdgaadd
 * Created on 2022/02/12
 */
public class Channel {
    private static String filePath;

    private static FileChannel fc;

    public static void main(String[] args) throws IOException {
        // 获取文件对象
        File directory = new File("");
        filePath = directory.getCanonicalPath() + "\\src\\Channel.txt";

        // 生成双向的Channel对象
        RandomAccessFile ra=new RandomAccessFile(filePath, "rw");
        fc = ra.getChannel();

        write();
        read();
    }

    public static void write() throws IOException {
        // FileOutStream形式
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        fileOutputStream.write("hallo FileOutputStream\n".getBytes());

        // Channel形式
        ByteBuffer buffer = ByteBuffer.wrap("hello Channel\n".getBytes()); // 通过Buffer指定写入数据
        fc.write(buffer);
        fc.close();
    }

    public static void read() throws IOException {
        // FileInputStream形式
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        int result = -1;
        while((result = fileInputStream.read()) != -1) {
            System.out.print((char)result);
        }

        // Channel形式
        ByteBuffer buffer = ByteBuffer.allocate(30); // 通过Buffer指定要读取的数据长度
        fc.read(buffer);
        System.out.println(new String(buffer.array()));
    }
}
