package com.redis.demo.util;

import org.apache.commons.io.IOUtils;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {


    /**
     * 默认的密码字符串组合，
     * 用来将字节转换成 16 进制表示的字符,apache校验下载的文件的
     * 正确性用的就是默认的这个组合
     */
    protected static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 生成文件的md5校验值
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String getFileMD5String(File file) throws IOException, NoSuchAlgorithmException {
        InputStream fis;
        fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int numRead = 0;
        while ((numRead = fis.read(buffer)) > 0) {
            MessageDigest.getInstance("MD5").update(buffer, 0, numRead);
        }
        fis.close();
        return bufferToHex(MessageDigest.getInstance("MD5").digest());
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        // 取字节中高 4 位的数字转换, >>> 为逻辑右移，
        // 将符号位一起右移,此处未发现两种符号有何不同
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        // 取字节中低 4 位的数字转换
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    public static String fileMd5(String filePath) throws IOException {
        FileInputStream fis= new FileInputStream(filePath);
        String md5 = DigestUtils.md5DigestAsHex(IOUtils.toByteArray(fis));
        IOUtils.closeQuietly(fis);
        return md5;
    }

    public static String md5(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = DigestUtils.md5Digest(inputStream);
        String md5 = new String(bytes,"UTF-8");
        return md5;
    }

    public static void main(String[] args) {

        String filePath = "G:\\download\\chrome.zip";

        try {
            String md5_1 = fileMd5(filePath);
            System.out.println(md5_1);
            System.out.println("--------------");

            String md5_2 = md5(filePath);
            System.out.println(md5_2);

            System.out.println("equal");

            System.out.println(md5_1.equals(md5_2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
