package com.example.mepositry.bean;

import java.io.Serializable;
import java.util.List;

public class StudyBean {
    /**
     * msg : 请求成功
     * code : 1
     * data : [{"number":"yygdz","parent":396,"children":[{"name":"法制专栏","number":"legal","banner":"http://znzb.test/uploads/1/image/public/201912/20191203122639_t5rag0ten5.png","id":"292"},{"name":"党史教育","number":"ykr5e1","banner":"http://znzb.test/uploads/1/image/public/202105/20210516112833_hbxrguq44p.png","id":"387"},{"name":"法制教育","number":"k4g607","banner":"http://znzb.test/uploads/1/image/public/202105/20210516112842_w71ny62lrf.png","id":"388"},{"name":"热点专题","number":"sfaeoq","banner":"http://znzb.test/uploads/1/image/public/202105/20210516112919_4sgpigclfv.png","id":"390"},{"name":"抗疫专题","number":"1eh9og","banner":"http://znzb.test/uploads/1/image/public/202105/20210516112855_sf94utnhv5.png","id":"389"}],"name":"永远跟党走","icon":"","banner":"","id":386}]
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
         * number : yygdz
         * parent : 396
         * children : [{"name":"法制专栏","number":"legal","banner":"http://znzb.test/uploads/1/image/public/201912/20191203122639_t5rag0ten5.png","id":"292"},{"name":"党史教育","number":"ykr5e1","banner":"http://znzb.test/uploads/1/image/public/202105/20210516112833_hbxrguq44p.png","id":"387"},{"name":"法制教育","number":"k4g607","banner":"http://znzb.test/uploads/1/image/public/202105/20210516112842_w71ny62lrf.png","id":"388"},{"name":"热点专题","number":"sfaeoq","banner":"http://znzb.test/uploads/1/image/public/202105/20210516112919_4sgpigclfv.png","id":"390"},{"name":"抗疫专题","number":"1eh9og","banner":"http://znzb.test/uploads/1/image/public/202105/20210516112855_sf94utnhv5.png","id":"389"}]
         * name : 永远跟党走
         * icon :
         * banner :
         * id : 386
         */

        private String number;
        private int parent;
        private String name;
        private String icon;
        private String banner;
        private int id;
        private List<ChildrenBean> children;

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

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean implements Serializable {
            /**
             * name : 法制专栏
             * number : legal
             * banner : http://znzb.test/uploads/1/image/public/201912/20191203122639_t5rag0ten5.png
             * id : 292
             */

            private String name;
            private String number;
            private String banner;
            private String id;

            public ChildrenBean(String name, String number, String banner, String id) {
                this.name = name;
                this.number = number;
                this.banner = banner;
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getBanner() {
                return banner;
            }

            public void setBanner(String banner) {
                this.banner = banner;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
