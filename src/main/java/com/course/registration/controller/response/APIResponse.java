package com.course.registration.controller.response;
import java.io.Serializable;

/**
 * API Response wrapper
 */
public class APIResponse<T> implements Serializable {
    private static final long serialVersionUID = 6822621578483316706L;
    /**
     * success status code
     */
    public static final int STATUS_SUCCESS = 0;
    /**
     * unknown status code
     */
    public static final int STATUS_UNKNOWN = -1;

    /**
     * success message
     */
    public static final String MESSAGE_SUCCESS = "success";


    private int status;

    private String message;

    private T data;

    public APIResponse() {
    }

    public APIResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /***
     * check request success or not
     * if success, code is 0
     * @return succeed
     */
    public boolean succeed() {
        return this.status == 0;
    }


    /**
     * create a success response without data
     *
     * @param <T>
     * @return
     */
    public static <T> APIResponse<T> ofSuccess() {
        return new APIResponse<T>(STATUS_SUCCESS, MESSAGE_SUCCESS, null);
    }

    /**
     * create a success response data
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> APIResponse<T> ofSuccess(T data) {
        return new APIResponse<T>(STATUS_SUCCESS, MESSAGE_SUCCESS, data);
    }

    /**
     * create a fail response
     * with response states and error message
     *
     * @param status
     * @param message
     * @return
     */
    public static <T> APIResponse<T> ofError(int status, String message) {
        return new APIResponse<T>(status, message, null);
    }

    /**
     * create a unknown fail response
     * with fixed error code and message
     * with data
     *
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> APIResponse<T> ofError(String message, T data) {
        return new APIResponse<T>(STATUS_UNKNOWN, message, data);
    }

    /**
     * create a unknown fail response
     * with fixed error code and message
     * without data
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> APIResponse<T> ofError(String message) {
        return new APIResponse<T>(STATUS_UNKNOWN, message, null);
    }

    /**
     * create a unknown fail response
     * with given error code, message and data
     *
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> APIResponse<T> of(int code, String message, T data) {
        return new APIResponse<T>(code, message, data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        APIResponse<?> that = (APIResponse<?>) o;

        if (status != that.status) return false;
        if (!message.equals(that.message)) return false;
        return data.equals(that.data);
    }

    @Override
    public int hashCode() {
        int result = status;
        result = 31 * result + message.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("APIResponse{");
        sb.append("status=").append(status);
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}