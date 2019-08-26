package com.redis.demo.util;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;

public class ZipUtils {

  private static  Logger logger = LoggerFactory.getLogger(ZipUtils.class);

    /**
     * @param zipFilePath 压缩文件路径
     * @param addFile1 压缩文件中添加的文件1
     * @param addFile2 压缩文件中添加的文件2
     * @param password 压缩密码
     * @return
     */
    public static boolean zipFile(String zipFilePath, String addFile1,
                                  String addFile2, String password) {

        ZipFile zipFile;
        try {
            zipFile = new ZipFile(zipFilePath);
            ArrayList<File> list = new ArrayList<File>();
            list.add(new File(addFile1));
            list.add(new File(addFile2));

            //设置压缩文件参数
            ZipParameters parameters = new ZipParameters();
            //设置压缩方法
            parameters.setCompressionMethod(Zip4jConstants.COMP_STORE);

            //设置压缩级别
            //DEFLATE_LEVEL_FASTEST     - Lowest compression level but higher speed of compression
            //DEFLATE_LEVEL_FAST        - Low compression level but higher speed of compression
            //DEFLATE_LEVEL_NORMAL      - Optimal balance between compression level/speed
            //DEFLATE_LEVEL_MAXIMUM     - High compression level with a compromise of speed
            //DEFLATE_LEVEL_ULTRA       - Highest compression level but low speed
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

            //设置压缩文件加密
            parameters.setEncryptFiles(true);

            //设置加密方法
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);

            //设置aes加密强度
            parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);

            //设置密码
            parameters.setPassword(password);

            zipFile.addFiles(list, parameters);

        } catch (ZipException e) {
            logger.error("压缩文件失败:",e);
            return false;
        }
        return true;
    }

    /**
     *  解压文件
     * @param source 源文件路径
     * @param dist 输入文件路径
     * @param passwrod 解压密码
     * @return
     */
    public static  boolean unZip(String source, String dist, String passwrod) {

        try {
            ZipFile file = new ZipFile(source);
            file.setPassword(passwrod);
            file.extractAll(dist);

            File unzipFile = new File(dist);
            File[] files = unzipFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
            }
        } catch (ZipException e) {
           logger.error("解压文件失败:",e);
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        ZipUtils.zipFile("test.zip", "1.txt", "2.txt", "123");

        ZipFile file = new ZipFile("D://test.zip");
        file.setPassword("123");
        file.extractAll("D://test2");

        File unzipFile = new File("D://test2");
        File[] files = unzipFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
    }
}
