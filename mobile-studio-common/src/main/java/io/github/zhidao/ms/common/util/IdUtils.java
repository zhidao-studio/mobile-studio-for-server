package io.github.zhidao.ms.common.util;

import cn.hutool.core.util.IdUtil;

/**
 * - ID工具
 *
 * @author zhanls 2023/2/20 23:06
 **/
public class IdUtils {

   public static String uuid(){
       String fastSimpleUUID = IdUtil.fastSimpleUUID().substring(0,32);
       return fastSimpleUUID;
   }

    public static void main(String[] args) {
        System.out.println(uuid());
    }


}
