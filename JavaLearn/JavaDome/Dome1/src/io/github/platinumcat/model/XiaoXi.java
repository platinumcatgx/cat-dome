package io.github.platinumcat.model;

import io.github.platinumcat.tool.xxType;

public class XiaoXi {
    private String fs;//发送方
    private String js;//接受方
    private xxType type;//消息类型
    private String Data;//消息内容

    public XiaoXi(String fs, String js, xxType type, String data) {
        this.fs = fs;
        this.js = js;
        this.type = type;
        Data = data;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public xxType getType() {
        return type;
    }

    public void setType(xxType type) {
        this.type = type;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

}
