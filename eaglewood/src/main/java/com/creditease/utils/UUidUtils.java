package com.creditease.utils;

import java.util.UUID;

/**
 * @description
 * @Author
 * @Date 2019-06-10 11:04
 **/

public class UUidUtils {
    public final static String uuid(){
        return UUID.randomUUID().toString();
    }

    public static String formatUuid(){
        return UUidUtils.uuid().replaceAll("-","").substring(2,32);
    }


}
