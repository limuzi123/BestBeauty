package com.lanou3g.mostbeauty.Bean;

import java.util.List;

/**
 * Created by dllo on 16/9/2.
 */
public class PictorialCommentActivityBean {

    /**
     * has_next : 0
     * comments : [{"content":"不错","created_at":1472784654000,"id":3480,"author":{"username":"   nothing｀","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/5DE9C00A6145714A6A103D95FC770B89/100","id":11,"sign":"遇见最美的自己"}},{"content":"精油是好东西，如果皮肤烂了不能用怎么办？","created_at":1472735708000,"id":3474,"author":{"username":"hoogestudio","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/B3DC48BDCBF7EA620C65718D2D00D978/100","id":37101,"sign":"遇见最美的自己"}},{"content":"非常喜欢这一类的东西","created_at":1472728810000,"id":3473,"author":{"username":"Freesia","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/686945AED8F1FE3A193F157949810A62/100","id":41858,"sign":"遇见最美的自己"}},{"content":"一直就很喜欢这类东西呢 不知道味道能不能长久","created_at":1472728641000,"id":3471,"author":{"username":"Qaomi","avatar_url":"http://tva2.sinaimg.cn/crop.0.0.996.996.180/005QcIxCjw8f6azopeih5j30ro0rpwgm.jpg","id":23493,"sign":"遇见最美的自己"}},{"content":"炼金师","created_at":1472718017000,"id":3461,"author":{"username":"no----thing","avatar_url":"http://tva2.sinaimg.cn/crop.133.152.456.456.180/005PxahLgw1f5y5lh0y8cj30k40l4jsf.jpg","id":20305,"sign":"遇见最美的自己"}},{"content":"自带自然气息的炼金师^_^  迫不及待想试试这精油和香蜡咯","created_at":1472701855000,"id":3458,"author":{"username":"局簇荒岛","avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/09/01/2036e0453bb39c633da695fdffb1aa3d_251x250.jpg","id":4832,"sign":"遇见最美的自己"}},{"content":"哈哈哈～钢炼一生推哇！","created_at":1472700700000,"id":3457,"author":{"username":"Jony","avatar_url":"","id":37,"sign":"遇见最美的自己"}}]
     */

    private DataBean data;
    /**
     * data : {"has_next":0,"comments":[{"content":"不错","created_at":1472784654000,"id":3480,"author":{"username":"   nothing｀","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/5DE9C00A6145714A6A103D95FC770B89/100","id":11,"sign":"遇见最美的自己"}},{"content":"精油是好东西，如果皮肤烂了不能用怎么办？","created_at":1472735708000,"id":3474,"author":{"username":"hoogestudio","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/B3DC48BDCBF7EA620C65718D2D00D978/100","id":37101,"sign":"遇见最美的自己"}},{"content":"非常喜欢这一类的东西","created_at":1472728810000,"id":3473,"author":{"username":"Freesia","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/686945AED8F1FE3A193F157949810A62/100","id":41858,"sign":"遇见最美的自己"}},{"content":"一直就很喜欢这类东西呢 不知道味道能不能长久","created_at":1472728641000,"id":3471,"author":{"username":"Qaomi","avatar_url":"http://tva2.sinaimg.cn/crop.0.0.996.996.180/005QcIxCjw8f6azopeih5j30ro0rpwgm.jpg","id":23493,"sign":"遇见最美的自己"}},{"content":"炼金师","created_at":1472718017000,"id":3461,"author":{"username":"no----thing","avatar_url":"http://tva2.sinaimg.cn/crop.133.152.456.456.180/005PxahLgw1f5y5lh0y8cj30k40l4jsf.jpg","id":20305,"sign":"遇见最美的自己"}},{"content":"自带自然气息的炼金师^_^  迫不及待想试试这精油和香蜡咯","created_at":1472701855000,"id":3458,"author":{"username":"局簇荒岛","avatar_url":"http://dstatic.zuimeia.com/user/avatar/2016/09/01/2036e0453bb39c633da695fdffb1aa3d_251x250.jpg","id":4832,"sign":"遇见最美的自己"}},{"content":"哈哈哈～钢炼一生推哇！","created_at":1472700700000,"id":3457,"author":{"username":"Jony","avatar_url":"","id":37,"sign":"遇见最美的自己"}}]}
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
        private int has_next;
        /**
         * content : 不错
         * created_at : 1472784654000
         * id : 3480
         * author : {"username":"   nothing｀","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/5DE9C00A6145714A6A103D95FC770B89/100","id":11,"sign":"遇见最美的自己"}
         */

        private List<CommentsBean> comments;

        public int getHas_next() {
            return has_next;
        }

        public void setHas_next(int has_next) {
            this.has_next = has_next;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class CommentsBean {
            private String content;
            private long created_at;
            private int id;
            /**
             * username :    nothing｀
             * avatar_url : http://q.qlogo.cn/qqapp/1105321739/5DE9C00A6145714A6A103D95FC770B89/100
             * id : 11
             * sign : 遇见最美的自己
             */

            private AuthorBean author;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getCreated_at() {
                return created_at;
            }

            public void setCreated_at(long created_at) {
                this.created_at = created_at;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public static class AuthorBean {
                private String username;
                private String avatar_url;
                private int id;
                private String sign;

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getSign() {
                    return sign;
                }

                public void setSign(String sign) {
                    this.sign = sign;
                }
            }
        }
    }
}
