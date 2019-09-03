package com.redis.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class Base64Tools {

    private static Logger logger = LoggerFactory.getLogger(Base64Tools.class);

    /**
     * 将文件转成base64 字符串
     *
     * @param path 文件路径
     * @return
     */
    public static String encodeBase64File(String path) {
        try {
            //将文件 转换为字符串
            File file = new File(path);
            FileInputStream inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
            System.err.println("加密");
            //字符串加密
            return new BASE64Encoder().encode(buffer);
        } catch (Exception e) {
            logger.error("加密失败:",e);
        }
        return "ok";
    }

    /**
     * 将base64字符解码保存文件
     * @param base64Code 加密的base64
     * @param targetPath 保存的文件夹路径名
     */
    public static void decoderBase64File(String base64Code, String targetPath) {
        try {
            byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
            FileOutputStream out = new FileOutputStream(targetPath);
            out.write(buffer);
            out.close();
            System.err.println("解码");
        } catch (Exception e) {
             logger.error("解密失败:",e);
        }
    }

    public static void main(String[] args) {
        String filePath = "G:\\download\\flashplayerpp_install_cn.zip";

        String base64String = encodeBase64File(filePath);
        System.out.println(base64String);
        System.out.println(base64String.length());
    }
}