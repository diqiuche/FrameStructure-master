package com.constants.level;

/**
 * 网络请求状态
 *
 * @author tanlifei
 * @date 2015年8月13日 上午11:30:51
 */
public enum TaskRequestLevel {
    /**
     * 开始请求
     */
    START(0x0001),
    /**
     * 正在请求
     */
    PROGRESS(0x0002),
    /**
     * 请求成功
     */
    SUCCESS(0x0003),
    /**
     * 请求失败
     */
    FAILURE(0x0004),
    /**
     * 请求完成
     */
    FINISH(0x0005),
    /**
     * 取消请求
     */
    CANCEL(0x0006),
    /**
     * 暂无数据
     */
    EMPTY_DATA(0x0007),
    /**
     * 服务器错误
     */
    SERVICE_ERROR(0x0008),
    /**
     * 没有网络
     */
    NETWORK_ERROR(0x0009),
    /**
     * 请求超时
     */
    TIMEOUT_ERROR(0x0010),
    /**
     * 其它异常
     */
    EXCEPTION(0x0011);

    private int value = 0x0000;

    private TaskRequestLevel(int value) {    //    必须是private的，否则编译错误
        this.value = value;
    }

    public static TaskRequestLevel HttpTaskStatus(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0x0001:
                return START;
            case 0x0002:
                return PROGRESS;
            case 0x0003:
                return SUCCESS;
            case 0x0004:
                return FAILURE;
            case 0x0005:
                return FINISH;
            case 0x0006:
                return CANCEL;
            case 0x0007:
                return EMPTY_DATA;
            case 0x0008:
                return SERVICE_ERROR;
            case 0x0009:
                return NETWORK_ERROR;
            case 0x00010:
                return TIMEOUT_ERROR;
            case 0x00011:
                return EXCEPTION;

            default:
                return null;
        }
    }

    public int value() {
        return this.value;
    }
}