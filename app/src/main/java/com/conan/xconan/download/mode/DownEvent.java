package com.conan.xconan.download.mode;

/**
 * @Description: 下载事件，包含下载进度、状态及错误信息
 * @author: Conan
 * @date: 17/1/16 21:50.
 */
public class DownEvent {
    private int status = DownStatus.NORMAL.getStatus();
    private DownProgress downProgress = new DownProgress();
    private Throwable error;

    public int getStatus() {
        return status;
    }

    public DownEvent setStatus(int status) {
        this.status = status;
        return this;
    }

    public DownProgress getDownProgress() {
        return downProgress;
    }

    public DownEvent setDownProgress(DownProgress downProgress) {
        this.downProgress = downProgress;
        return this;
    }

    public Throwable getError() {
        return error;
    }

    public DownEvent setError(Throwable error) {
        this.error = error;
        return this;
    }

    @Override
    public String toString() {
        return "DownEvent{" +
                "status=" + status +
                ", downProgress=" + downProgress +
                ", error=" + error +
                '}';
    }
}
