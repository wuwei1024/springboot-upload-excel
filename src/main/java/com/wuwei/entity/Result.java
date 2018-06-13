package com.wuwei.entity;

public class Result {
    private static final int SUCCESS = 0;
    private static final int FAILURE = 1;

    private int status;
    private Object data;

    private Result(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result getSuccessResult(Object data) {
        return new Result(SUCCESS, data);
    }

    public static Result getFailedResult(Object data) {
        return new Result(FAILURE, data);
    }
}
