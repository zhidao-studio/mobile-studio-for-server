package io.github.zhidao.ms.common.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息（系统内部传输使用）
 * 包含Token和Profile等
 *
 * @author zhanls 2023/1/24 15:09
 **/
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -6224636379661108972L;

    private String token;

    private Profile profile;

    /**
     * 个人信息
     *
     **/
    @Data
    class Profile{

        private String id;

        private String name;

        private String mobile;


    }


}
