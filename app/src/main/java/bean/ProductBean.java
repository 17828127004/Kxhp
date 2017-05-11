package bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */

public class ProductBean {


    /**
     * goods : [{"id":"4","name":"111","detail":"风口浪尖；了开始就结束了估计死了；国内发生类似看法第六空间烦死掉了","price":"111","img":"http://www.cdjiayibai.com/upload/mall/1494214340.png","num":"211","create_time":"1494214351","url":"http://www.cdjiayibai.com/home/index/goods_detail?id=4"},{"id":"3","name":"测试","detail":"啊发发发的撒范德萨发生大幅度沙发沙发斯蒂芬","price":"112","img":"http://www.cdjiayibai.com/upload/mall/1494214300.png","num":"222","create_time":"1494214312","url":"http://www.cdjiayibai.com/home/index/goods_detail?id=3"}]
     * code : 123456
     */

    private int code;
    private List<GoodsBean> goods;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * id : 4
         * name : 111
         * detail : 风口浪尖；了开始就结束了估计死了；国内发生类似看法第六空间烦死掉了
         * price : 111
         * img : http://www.cdjiayibai.com/upload/mall/1494214340.png
         * num : 211
         * create_time : 1494214351
         * url : http://www.cdjiayibai.com/home/index/goods_detail?id=4
         */

        private String id;
        private String name;
        private String detail;
        private String price;
        private String img;
        private String num;
        private String create_time;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
