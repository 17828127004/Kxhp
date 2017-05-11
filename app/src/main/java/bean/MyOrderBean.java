package bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */

public class MyOrderBean {

    /**
     * order : [{"create_time":"1494382155","name":"儿童益智木制积木100粒","img":"http://www.cdjiayibai.com/upload/mall/1494300747.png","price":"368"},{"create_time":"1494381986","name":"婴幼儿童手敲琴","img":"http://www.cdjiayibai.com/upload/mall/1494301117.png","price":"369"},{"create_time":"1494381828","name":"儿童益智木制积木100粒","img":"http://www.cdjiayibai.com/upload/mall/1494300747.png","price":"368"},{"create_time":"1494381813","name":"儿童益智木制积木100粒","img":"http://www.cdjiayibai.com/upload/mall/1494300747.png","price":"368"},{"create_time":"1494381806","name":"儿童益智木制积木100粒","img":"http://www.cdjiayibai.com/upload/mall/1494300747.png","price":"368"},{"create_time":"1494381788","name":"儿童益智木制积木100粒","img":"http://www.cdjiayibai.com/upload/mall/1494300747.png","price":"368"}]
     * code : 123456
     */

    private int code;
    private List<OrderBean> order;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<OrderBean> getOrder() {
        return order;
    }

    public void setOrder(List<OrderBean> order) {
        this.order = order;
    }

    public static class OrderBean {
        /**
         * create_time : 1494382155
         * name : 儿童益智木制积木100粒
         * img : http://www.cdjiayibai.com/upload/mall/1494300747.png
         * price : 368
         */

        private String create_time;
        private String name;
        private String img;
        private String price;

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
