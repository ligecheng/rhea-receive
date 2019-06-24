package com.admin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 十六 十互相转换工具
 */
public class TenTohexDutils {
    private static final Logger logger=LoggerFactory.getLogger(TenTohexDutils.class);

    /**
     * 16转10
     * @param hex
     * @return
     */
    public static Long ten(String hex){
//        String  ten=String.format("%08x",hex);

       Long ten= Long.parseLong(hex,16);
        logger.info("转换十进制"+ten);
        return ten;
    }

    /**
     * 十转十六进制
     * @param ten
     * @return
     */
    public static String hex(Long ten){
        String hex=Long.toHexString(ten);
//        String hex=Integer.toHexString(ten);
        logger.info("转换16进制"+hex);
        return hex;
    }
    public static void main(String[] args) {


        String hex1=hex(123456L);
        logger.info("黎格成的16转换"+hex1);
        Long l=ten(hex1);
        logger.info("黎格成的10转换"+l);
    }

}
