package com.jamie.im.common.response;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
public enum  ResponseCode {

    /**
     * 请求成功
     */
    SUCCESS(200,"成功"),

    /**
     * 请求失败
     */
    FAILURE(500,"失败"),

    /**
     * 未知错误
     */
    UNKNOWN(-1,"未知错误"),
    // ----------------------------------------参数错误:10001-19999 Start

    PARAM_IS_INVALID(10001,"参数无效"),
    PARAM_IS_BLANK(10002,"参数为空"),
    PARAM_TYPE_BIND_ERROR(10003,"参数类型错误"),

    // ----------------------------------------参数错误:10001-19999 End

    // ----------------------------------------用户错误:20001-29999 Start

    USER_NOT_LOGGED_IN(20001,"用户未登陆"),
    USER_LOGIN_ERROR(20002,"账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003,"账号已被禁用"),
    USER_NOT_EXIST(20004,"用户不存在"),
    USER_HAS_EXISTED(20005,"用户已存在"),
    USER_NICE_HAS_EXISTED(20006,"昵称已存在"),
    USER_EMAIL_HAS_EXISTED(20007,"邮箱已存在"),
    USER_EMAIL_ACTIVATION_FAILURE(20008,"邮箱激活失败"),
    USER_EMAIL_FORBIDDEN(20009,"邮箱尚未激活"),
    USER_EMAIL_NOT_EXIST(20010,"邮箱不存在"),
    USER_EMAIL_ERROR(20011,"邮箱地址错误"),
    USER_RESET_ERROR(20012,"用户不存在或验证码错误"),

    // ----------------------------------------用户错误:20001-29999 End

    // ----------------------------------------业务错误:30001-39999 Start

    SPECIFIED_QUESTION_USER_NOT_EXIST(30001,"业务系统中用户不存在"),

    // ----------------------------------------业务错误:30001-39999 End

    // ----------------------------------------系统错误:40001-49999 Start
    SYSTEM_INNER_ERROR(40001,"系统繁忙，请稍后重试"),
    // ----------------------------------------系统错误:40001-49999 End

    // ----------------------------------------数据错误:50001-59999 Start
    RESULT_DATA_NONE(50001,"数据未找到"),
    DATA_IS_WRONG(50002,"数据有误"),
    DATA_ALREADY_EXISTED(50004,"数据已存在"),
    IMAGE_DATA_ISWRONG(50005,"仅支持 png jpg gif bmp webp 类型的图片"),
    DATA_IS_LARGE(50006,"数据过大"),

    // ----------------------------------------数据错误:50001-59999 End
    INTERFACE_ADDRESS_INVALID(50001,"接口地址无效"),
    // ----------------------------------------错误:60001-69999 Start

    // ----------------------------------------错误:60001-69999 End

    // ----------------------------------------权限错误:70001-79999 Start
    PERMISSION_NO_ACCESS(70001,"无访问权限");
    // ----------------------------------------权限错误:70001-79999 End

    private Integer code;

    private String message;

    ResponseCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }

    public static String getMessage(String name){

        for (ResponseCode item : ResponseCode.values()) {
            if(item.name().equals(name)){
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name){

        for (ResponseCode item: ResponseCode.values()) {
            if(item.name().equals(name)){
                return item.code;
            }
        }
        return null;
    }


}
