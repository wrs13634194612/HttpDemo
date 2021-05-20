package com.example.mepositry.bean;


import java.io.Serializable;
import java.util.List;

public class SubDataBean {
    @Override
    public String toString() {
        return "ColumnBean{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"number":"","parent":292,"name":"新闻动态","icon":"","banner":"","id":293},{"number":"","parent":292,"name":"法治在线","icon":"","banner":"","id":294},{"number":"","parent":292,"name":"律所前沿","icon":"","banner":"","id":295}]
     */


    private String msg;
    private int code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * number :
         * parent : 292
         * name : 新闻动态
         * icon :
         * banner :
         * id : 293
         */

        private String number;
        private int parent;
        private String name;
        private String icon;
        private String banner;
        private int id;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}

