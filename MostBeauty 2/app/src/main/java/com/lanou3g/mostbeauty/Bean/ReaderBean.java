package com.lanou3g.mostbeauty.Bean;

/**
 * Created by dllo on 16/9/7.
 */
public class ReaderBean {

    /**
     * username : Sarah橙
     * favor_article_num : 0
     * gender : F
     * birthday : 728323200000
     * email :
     * phone :
     * avatar_url : http://tva3.sinaimg.cn/crop.0.0.640.640.180/c229aea7jw8eyoxux5jcyj20hs0hs0tk.jpg
     * mark_product_num : 0
     * sign : 遇见最美的自己
     * id : 21742
     * like_article_num : 7
     * follow_designer_num : 0
     */

    private DataBean data;
    /**
     * data : {"username":"Sarah橙","favor_article_num":0,"gender":"F","birthday":728323200000,"email":"","phone":"","avatar_url":"http://tva3.sinaimg.cn/crop.0.0.640.640.180/c229aea7jw8eyoxux5jcyj20hs0hs0tk.jpg","mark_product_num":0,"sign":"遇见最美的自己","id":21742,"like_article_num":7,"follow_designer_num":0}
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
        private String username;
        private int favor_article_num;
        private String gender;
        private long birthday;
        private String email;
        private String phone;
        private String avatar_url;
        private int mark_product_num;
        private String sign;
        private int id;
        private int like_article_num;
        private int follow_designer_num;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getFavor_article_num() {
            return favor_article_num;
        }

        public void setFavor_article_num(int favor_article_num) {
            this.favor_article_num = favor_article_num;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public int getMark_product_num() {
            return mark_product_num;
        }

        public void setMark_product_num(int mark_product_num) {
            this.mark_product_num = mark_product_num;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLike_article_num() {
            return like_article_num;
        }

        public void setLike_article_num(int like_article_num) {
            this.like_article_num = like_article_num;
        }

        public int getFollow_designer_num() {
            return follow_designer_num;
        }

        public void setFollow_designer_num(int follow_designer_num) {
            this.follow_designer_num = follow_designer_num;
        }
    }
}
