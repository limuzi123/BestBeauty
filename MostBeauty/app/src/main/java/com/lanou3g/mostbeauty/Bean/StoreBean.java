package com.lanou3g.mostbeauty.Bean;

import java.util.List;

/**
 * Created by dllo on 16/9/3.
 */
public class StoreBean {

    /**
     * shop_image : http://dstatic.zuimeia.com/brand/shop/2016/6/18/db998c4c-f6d8-4ec3-8185-cf9b66901a4c.jpg
     * shops : [{"city":"纽约","address":"185 Roebling St. (Between Grand St & S. 1st St)\r\nBrooklyn, NY 11211","id":111,"name":"Commune"}]
     * online_shop_image : http://dstatic.zuimeia.com/brand/shop/2016/6/18/aff32861-aa27-4bed-a69e-ef171df14740.jpg
     * online_shops : [{"link_url":"http://www.essentialapothecaryshop.com/","image_url":"http://dstatic.zuimeia.com/shop/logo_official_550x200.png","id":73,"name":"Essential Apothecary Alchemist 官方网店"}]
     */

    private  DataBean data;
    /**
     * data : {"shop_image":"http://dstatic.zuimeia.com/brand/shop/2016/6/18/db998c4c-f6d8-4ec3-8185-cf9b66901a4c.jpg","shops":[{"city":"纽约","address":"185 Roebling St. (Between Grand St & S. 1st St)\r\nBrooklyn, NY 11211","id":111,"name":"Commune"}],"online_shop_image":"http://dstatic.zuimeia.com/brand/shop/2016/6/18/aff32861-aa27-4bed-a69e-ef171df14740.jpg","online_shops":[{"link_url":"http://www.essentialapothecaryshop.com/","image_url":"http://dstatic.zuimeia.com/shop/logo_official_550x200.png","id":73,"name":"Essential Apothecary Alchemist 官方网店"}]}
     * result : 1
     */

    private int result;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static class DataBean {
        private String shop_image;
        private String online_shop_image;
        /**
         * city : 纽约
         * address : 185 Roebling St. (Between Grand St & S. 1st St)
         Brooklyn, NY 11211
         * id : 111
         * name : Commune
         */

        private List<ShopsBean> shops;
        /**
         * link_url : http://www.essentialapothecaryshop.com/
         * image_url : http://dstatic.zuimeia.com/shop/logo_official_550x200.png
         * id : 73
         * name : Essential Apothecary Alchemist 官方网店
         */

        private List<OnlineShopsBean> online_shops;

        public String getShop_image() {
            return shop_image;
        }

        public void setShop_image(String shop_image) {
            this.shop_image = shop_image;
        }

        public String getOnline_shop_image() {
            return online_shop_image;
        }

        public void setOnline_shop_image(String online_shop_image) {
            this.online_shop_image = online_shop_image;
        }

        public List<ShopsBean> getShops() {
            return shops;
        }

        public void setShops(List<ShopsBean> shops) {
            this.shops = shops;
        }

        public List<OnlineShopsBean> getOnline_shops() {
            return online_shops;
        }

        public void setOnline_shops(List<OnlineShopsBean> online_shops) {
            this.online_shops = online_shops;
        }

        public static class ShopsBean {
            private String city;
            private String address;
            private int id;
            private String name;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class OnlineShopsBean {
            private String link_url;
            private String image_url;
            private int id;
            private String name;

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
