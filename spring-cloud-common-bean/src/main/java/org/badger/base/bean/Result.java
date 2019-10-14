package org.badger.base.bean;

import org.badger.base.enums.ResultEnum;

import java.io.Serializable;

/**
 * 通用返回result封装
 * Result对象包含协议属性：
 * re:业务正常返回的消息体,每个服务使用专用Re对象，不可复用。属性命名规则同数据库命名。支持数据结构包装，例如：List<Re>，Set<Re>。
 * status:服务状态码，为int类型， 1 为成功，-1为业务异常（手机号格式不对，会员不存在等），-2为服务异常（sql语句异常等）。
 * msg:描述信息。用于返回业务异常信息和服务异常信息，不可用于设置日志堆栈信息，和code取其一设值即可。举例：业务信息： msg = "附近暂无司机" ，服务异常信息：msg="订单创建失败".
 *
 * @author wubc
 * @version 1.0
 * @date 2019/2/28 15:43
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 6684332782749471673L;
    /**
     * 状态
     */
    private int status;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 消息
     */
    private String msg;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 数据
     */
    private T data;

    public Result(int status, boolean success, int code, String msg) {
        this.status = status;
        this.success = success;
        this.code = code;
        this.msg = msg;

    }

    public Result(int status, boolean success, int code, String msg, T data) {
        this.status = status;
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 请求成功
     *
     * @param
     * @return
     */
    public static Result success() {
        return new Result(ResultEnum.OPERATE_SUCCESS.getStatus(), Boolean.TRUE, ResultEnum.OPERATE_SUCCESS.getCode(), ResultEnum.OPERATE_SUCCESS.getName());
    }

    /**
     * 请求成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result(ResultEnum.OPERATE_SUCCESS.getStatus(), Boolean.TRUE, ResultEnum.OPERATE_SUCCESS.getCode(), ResultEnum.OPERATE_SUCCESS.getName(), data);
    }

    /**
     * 请求成功
     *
     * @param msg
     * @param data
     * @return
     */
    public static <T> Result<T> success(String msg, T data) {
        return new Result(ResultEnum.OPERATE_SUCCESS.getStatus(), Boolean.TRUE, ResultEnum.OPERATE_SUCCESS.getCode(), msg, data);
    }

    /**
     * 失败
     *
     * @param
     * @return
     */
    public static Result failure() {
        return new Result(ResultEnum.OPERATE_FAILURE.getStatus(), Boolean.FALSE, ResultEnum.OPERATE_FAILURE.getCode(), ResultEnum.OPERATE_FAILURE.getName());
    }

    /**
     * 失败，带消息
     *
     * @param msg
     * @param
     * @return
     */
    public static Result failure(String msg) {
        return new Result(ResultEnum.OPERATE_FAILURE.getStatus(), Boolean.FALSE, ResultEnum.OPERATE_FAILURE.getCode(), msg);
    }

    /**
     * 失败，code带消息
     *
     * @param code
     * @param msg
     * @param
     * @return
     */
    public static Result failure(int code, String msg) {
        return new Result(ResultEnum.OPERATE_FAILURE.getStatus(), Boolean.FALSE, code, msg);
    }

    /**
     * 失败，带消息，带数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(String msg, T data) {
        return new Result(ResultEnum.OPERATE_FAILURE.getStatus(), Boolean.FALSE, ResultEnum.OPERATE_FAILURE.getCode(), msg, data);
    }

    /**
     * 失败，code带消息
     *
     * @param code
     * @param msg
     * @param data
     * @param
     * @return
     */
    public static <T> Result<T> failure(int code, String msg, T data) {
        return new Result(ResultEnum.OPERATE_FAILURE.getStatus(), Boolean.FALSE, code, msg, data);
    }

    /**
     * 错误
     *
     * @param
     * @return
     */
    public static Result error() {
        return new Result(ResultEnum.OPERATE_ERROR.getStatus(), Boolean.FALSE, ResultEnum.OPERATE_ERROR.getCode(), ResultEnum.OPERATE_ERROR.getName());
    }

    /**
     * 错误，带消息
     *
     * @param msg
     * @return
     */
    public static Result error(String msg) {
        return new Result(ResultEnum.OPERATE_ERROR.getStatus(), Boolean.FALSE, ResultEnum.OPERATE_ERROR.getCode(), msg);
    }

    /**
     * 错误，带消息
     *
     * @param msg
     * @return
     */
    public static Result error(int code, String msg) {
        return new Result(code, Boolean.FALSE, ResultEnum.OPERATE_ERROR.getCode(), msg);
    }

    /**
     * 错误，带消息，带数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msg, T data) {
        return new Result(ResultEnum.OPERATE_ERROR.getStatus(), Boolean.FALSE, ResultEnum.OPERATE_ERROR.getCode(), msg, data);
    }

    /**
     * 错误，带消息，带数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(int code, String msg, T data) {
        return new Result(ResultEnum.OPERATE_ERROR.getStatus(), Boolean.FALSE, code, msg, data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
