package com.lanou3g.mostbeauty.Bean;

import java.util.List;

/**
 * Created by dllo on 16/9/3.
 */
public class PictorialAuthorActivityViewPagerTopBean {

    /**
     * introduce_images : ["http://dstatic.zuimeia.com/common/image/2016/6/28/aa6eb65d-05ab-4829-8b52-4a0d92dd508b_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/6/18/449b8444-2717-45a0-be30-6ee0f52c0674_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/6/18/7319cdd6-2365-4c21-bd98-90db57e2b5ea_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/6/18/a16c7b33-857f-410a-8c64-d8b64f022ba2_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/6/18/6ddc2c3e-7ea2-4ce5-a2df-9493401c88b4_1000x1000.jpeg"]
     * city : 西雅图
     * concept : 维持内在身体的平衡是一件充满智慧的事
     * article_num : 1
     * name : Kate Poole
     * product_num : 4
     * label : Essential Apothecary Alchemist 创始人
     * avatar_url : http://dstatic.zuimeia.com/designer/avatar/2016/6/18/4b003d3c-1f3e-4593-833b-0e20f72d527c.jpg
     * is_followed : 0
     * id : 30
     * description : Kate 在热爱野外大自然的家庭长大，从小就喜欢到处逛游和搜集野外的自然草药。在高中的时候，Kate 研究了 Jethro Klass and Dr. Christoper 的作品，开始自己制作和烧制药膏，甚至会尝试为朋友和家人“医治” 小病。后来，Kate 爱上了精油，因为其健康的特效和美好的香薰味道。Kate 创办了自己的精油品牌: Essential Apothecary Alchemist。
     */

    private DataBean data;
    /**
     * data : {"introduce_images":["http://dstatic.zuimeia.com/common/image/2016/6/28/aa6eb65d-05ab-4829-8b52-4a0d92dd508b_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/6/18/449b8444-2717-45a0-be30-6ee0f52c0674_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/6/18/7319cdd6-2365-4c21-bd98-90db57e2b5ea_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/6/18/a16c7b33-857f-410a-8c64-d8b64f022ba2_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/6/18/6ddc2c3e-7ea2-4ce5-a2df-9493401c88b4_1000x1000.jpeg"],"city":"西雅图","concept":"维持内在身体的平衡是一件充满智慧的事","article_num":1,"name":"Kate Poole","product_num":4,"label":"Essential Apothecary Alchemist 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/6/18/4b003d3c-1f3e-4593-833b-0e20f72d527c.jpg","is_followed":0,"id":30,"description":"Kate 在热爱野外大自然的家庭长大，从小就喜欢到处逛游和搜集野外的自然草药。在高中的时候，Kate 研究了 Jethro Klass and Dr. Christoper 的作品，开始自己制作和烧制药膏，甚至会尝试为朋友和家人\u201c医治\u201d 小病。后来，Kate 爱上了精油，因为其健康的特效和美好的香薰味道。Kate 创办了自己的精油品牌: Essential Apothecary Alchemist。"}
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
        private String city;
        private String concept;
        private int article_num;
        private String name;
        private int product_num;
        private String label;
        private String avatar_url;
        private int is_followed;
        private int id;
        private String description;
        private List<String> introduce_images;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getConcept() {
            return concept;
        }

        public void setConcept(String concept) {
            this.concept = concept;
        }

        public int getArticle_num() {
            return article_num;
        }

        public void setArticle_num(int article_num) {
            this.article_num = article_num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProduct_num() {
            return product_num;
        }

        public void setProduct_num(int product_num) {
            this.product_num = product_num;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public int getIs_followed() {
            return is_followed;
        }

        public void setIs_followed(int is_followed) {
            this.is_followed = is_followed;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getIntroduce_images() {
            return introduce_images;
        }

        public void setIntroduce_images(List<String> introduce_images) {
            this.introduce_images = introduce_images;
        }
    }
}
