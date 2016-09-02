package com.lanou3g.mostbeauty.Bean;

import java.util.List;

/**
 * Created by dllo on 16/9/2.
 */
public class StylistFragmentBean {

    /**
     * has_next : 1
     * designers : [{"city":"爱尔兰","concept":"山川在呼唤我，我必须过去","name":"Khrystyna Marriott","label":"Ruby Robin 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/31/ca3d6fdf-5ffe-4c70-aa78-ae61449eb820.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/31/e5bd2d42-4082-4d72-a727-f93f1ae27101_1000x625.jpeg"],"id":113},{"city":"马德里","concept":"自由才是最大的奢侈","name":"Manolo Blahnik","label":"Manolo Blahnik 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/a74a4ea2-a67e-4329-bc6b-ccd9447e02a8.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/29/f11e4d6c-25a8-455f-b728-90edb43e1e68_1000x625.jpeg"],"id":112},{"city":"伦敦","concept":"我的设计必须是你能穿在脚上的东西，并且要让你感觉自信、性感与舒适","name":"Paul Andrew","label":"Paul Andrew 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/6e343bb0-6c77-455d-bddf-f76fa434f3d3.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/27/f9766a79-9c9b-4ff7-a9e7-790456c33c4b_1000x625.jpeg"],"id":111},{"city":"伦敦","concept":"我最需要的就是不知疲倦的工作精神，加上骨子里渴望创造的强烈欲望","name":"Tom Ford ","label":"Tom Ford 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/40dc05c6-d86c-4e26-a55b-7360528860ad.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/27/2cc130d1-6cf4-4618-b0ca-64eeaa384177_1000x625.jpeg"],"id":110},{"city":"罗马","concept":"每季你都可以讲不同的故事，但只能是由同一语言讲出","name":"Maria Grazia Chiuri & Pierpaolo Piccioli","label":"Valentino 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/70986e1d-c00b-460b-8b6b-39ca5162be81.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/27/9044ed94-788b-40e2-a709-d8b50b82de88_1000x625.jpeg"],"id":109},{"city":"马德里","concept":"女人就像艺术品一样，没有年龄之分","name":"Josep Font","label":"Delpozo 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/0ad4c457-8223-4f60-b1d9-53894d62277e.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/29/dfbb26a5-df4c-4acd-a989-d0e89867576e_1000x625.jpeg"],"id":108},{"city":"斯德哥尔摩","concept":"激进有时也是一种牺牲","name":"Jonny Johansson","label":"Acne Studios 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/d89e4d31-2098-475a-84c7-dfc94eddb2c5.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/29/70071b5c-9986-4fc4-ab3f-c6c081e20f2a_1000x625.jpeg"],"id":106},{"city":"米兰","concept":"鞋子不该成为装饰的焦点","name":"Gianvito Rossi","label":"Gianvito Rossi 设计总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/0d8b88b1-19bf-40b3-8d49-a0b677899857.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/29/d43f68a0-b3b8-4057-b376-1e756ecd4169_1000x625.jpeg"],"id":104},{"city":"圣加仑州","concept":"时尚应该简单些，这个时代已经够复杂了","name":"Albert Kriemler","label":"Akris 设计总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/76ca8ba0-8dd8-49e6-9b92-83396001b1ff.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/29/d11e6af0-cef1-47a7-84ee-c9f25af8aefb_1000x625.jpeg"],"id":103},{"city":"纽约","concept":"时尚是有趣味性的，不要拘泥于陈旧。","name":"Jeremy Scott","label":"Moschino 技术总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/013ec08f-e6c8-406e-a178-36718ada9211.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/28/7cb468cf-a97c-4129-a92a-dcb44faa67e1_1000x625.jpeg"],"id":102},{"city":"波特兰","concept":"我喜欢把材料用在出其不意的地方","name":"Matt Pierce","label":"Wood & Faulk 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/18/882c923a-25f8-4dd7-b4ed-c6f53690382c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/19/792f4c47-907d-4ae9-ad13-525aa1220b8e_1000x625.jpeg"],"id":100},{"city":"佛罗伦萨","concept":"如果这双鞋子合脚，就穿各种颜色的这双鞋子吧","name":"Edgardo Osorio","label":"Aquazzura 设计总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/25/3f8460e7-0b16-4078-80f1-524673508b26.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/26/8ad96675-0ef5-4866-bf84-ad99cbeab684_1000x625.jpeg"],"id":98},{"city":"米兰","concept":"我希望人们记住Dolce & Gabbana 是因为感官的享受，地中海气质以及我们对生活的诚意","name":"Domenico Dolce & Stefano Gabbana","label":"Dolce & Gabbana 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/25/935baeae-2daa-435c-8b49-c7d18c2f37a1.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/27/d8a75820-2ecd-427c-b925-4645f00814cb_1000x625.jpeg"],"id":97},{"city":"伦敦","concept":"20岁是用来玩的，30岁要开始做事儿，40岁你就要站在正确的队列上了","name":"Dean & Dan Caten","label":"Dsquared2 设计总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/fbe58fc4-b9eb-4f96-b8eb-de362017aecf.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/25/a45bb8cc-a390-483d-8586-fea5e18b0a74_1000x625.jpeg"],"id":96},{"city":"米兰","concept":"时尚就是做梦以及让其他人也一起做梦","name":"Donatella Versace","label":"Versace 首席设计师，董事会副主席","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/33bdb955-87cf-4744-9c72-5e0fb099a2d9.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/25/50b2a3c3-9970-444f-80f3-f268c16b9978_1000x625.jpeg"],"id":95},{"city":"巴黎","concept":"我的字典里没有厌倦二字","name":"Christian Louboutin","label":"Christian Louboutin 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/dd5abf79-77bd-40da-9d14-80117a1d1a9c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/25/a60bda5d-3939-4690-9bfb-43b43f2efa65_1000x625.jpeg"],"id":94},{"city":"纽约","concept":"高品质是无法复制的。好的声望需要很久才能建立。","name":"Jenna Lyons","label":"J. Crew 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/4a45ba58-6d4f-469d-beba-92fea5e3536d.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/25/2c36e784-dce1-4dca-8c3f-5b0855cd087b_1000x625.jpeg"],"id":93},{"city":"纽约","concept":"请和衣服愉快的玩耍，Kenzo就应该有趣好玩。","name":"Carol Lim & Humberto Leon","label":"Kenzo 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/22/3a68f9a2-5299-4041-8d08-9c1666df7477.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/23/736d93df-8ac3-457a-8780-7e6063581376_1000x625.jpeg"],"id":92},{"city":"纽约","concept":"珠宝设计就是把我的信仰和价值观变为有形的实体","name":"Lena Skadegard ","label":"Lena Skadegard 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/15a6f4f6-0263-4f9f-a1e1-91fd38d0dd9c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/23/5b485e09-9079-479f-9618-49bf5f77d501_1000x625.jpeg"],"id":91},{"city":"罗利","concept":"把故事，心情和颜色融合在自己的作品里","name":"Ann Howell Bullard ","label":"Ann Howell Bullard 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/001bb8f3-60e1-4725-9aaf-c064495ab0ae.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/23/ce7cf696-31e4-4d0e-b019-ca0d27df3f38_1000x625.jpeg"],"id":90},{"city":"休斯顿","concept":"不要对未知感到害怕，持续提问并不惧失败是唯一一条通往未知的路","name":"Kathrine Zeren ","label":"Kathrine Zeren 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/d4620916-ae43-44de-aa6b-f43dbca0a590.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/23/60b21bc9-749e-40e8-9b93-8e53c78e43c4_1000x625.jpeg"],"id":89},{"city":"剑桥","concept":"好的设计应该是兼收并蓄而不是独断专有的","name":"Nick Koo","label":"Eone Time 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/18/5fa98293-555d-4d87-b30e-70d64639de69.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/18/a13a26a4-f03d-4f33-af0b-8953e163181d_1000x625.jpeg"],"id":87},{"city":"马修斯","concept":"记住你来自哪里，尊崇传统，从老一辈那里学习","name":"Xan Hood ","label":"Buffalo Jackson 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/19/c633dab3-f1c2-43b8-8d9c-3803d3c45c26.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/19/38da3cb1-1441-41f4-98cd-d1bd690bee4a_1000x625.jpeg"],"id":86},{"city":"克利夫兰","concept":"拖延是时间的小偷","name":"Todd Pownell","label":"Tap 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/18/5c54dab6-fe59-4d6d-bcd2-816ce4f7bba8.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/18/98324fa2-a7b6-4967-a3a7-0f1fec677a0e_1000x625.jpeg"],"id":85},{"city":"亚特兰大","concept":"简单和实用才真正经得起时间的考验","name":"Sarah Green","label":"Cord 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/18/e91d56eb-03f8-4941-818d-527dc82eca48.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/18/4bfc44bd-da04-4dab-8066-b5ad3d337275_1000x625.jpeg"],"id":84},{"city":"洛杉矶","concept":"不管你想怎样开始自己的人生，请一定要做你最爱的事情","name":"Kagan Taylor & Linda Hsiao","label":"Knotwork LA 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/18/8d0f03c2-05e6-40cb-8101-731b9f8fe093.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/18/370c0919-6df4-49d7-b595-017d99d83864_1000x625.jpeg"],"id":83},{"city":"伦敦","concept":"当你的品牌能够被他人预测的时候，你就遇上大麻烦了","name":"Jonathan Anderson","label":"J.W.Anderson 创始人，Loewe 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/12/1c550e7b-56cf-44a2-af40-7bfe07f0827b.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/12/89aec0a9-48a7-4858-95d4-dac3b752b94d_1000x625.jpeg"],"id":82},{"city":"普洛佛","concept":"我爱开始的过程，并发展成一个想法使它变成一种我可以持有的有形的产品。","name":"Quinn Peterson","label":"QPCollection 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/19/a276e37d-f4eb-4c28-af89-5ab4e2cab069.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/19/c2b0c56e-7019-4960-9e8d-063de6f0b655_1000x625.jpeg"],"id":80},{"city":"旧金山","concept":"没有必要在道义和美感之间妥协","name":"Rachel Gant & Andrew Deming","label":"Yield 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/cc971222-1f6e-4610-a141-36aeedcf1667.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/cffcc0a5-f548-4868-9460-3261b390e458_1000x625.jpeg"],"id":79},{"city":"纽约","concept":"唯有打开眼界和内心，灵感才会涌来","name":"Virginie Millefiori","label":"Virginie Millefiori 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/740ef4d2-bb4d-4b19-b7ce-576d57d896ff.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/fc9a35f9-9c77-4f0e-b759-3ebebbfbca02_1000x625.jpeg"],"id":78}]
     */

    private DataBean data;
    /**
     * data : {"has_next":1,"designers":[{"city":"爱尔兰","concept":"山川在呼唤我，我必须过去","name":"Khrystyna Marriott","label":"Ruby Robin 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/31/ca3d6fdf-5ffe-4c70-aa78-ae61449eb820.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/31/e5bd2d42-4082-4d72-a727-f93f1ae27101_1000x625.jpeg"],"id":113},{"city":"马德里","concept":"自由才是最大的奢侈","name":"Manolo Blahnik","label":"Manolo Blahnik 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/a74a4ea2-a67e-4329-bc6b-ccd9447e02a8.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/29/f11e4d6c-25a8-455f-b728-90edb43e1e68_1000x625.jpeg"],"id":112},{"city":"伦敦","concept":"我的设计必须是你能穿在脚上的东西，并且要让你感觉自信、性感与舒适","name":"Paul Andrew","label":"Paul Andrew 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/6e343bb0-6c77-455d-bddf-f76fa434f3d3.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/27/f9766a79-9c9b-4ff7-a9e7-790456c33c4b_1000x625.jpeg"],"id":111},{"city":"伦敦","concept":"我最需要的就是不知疲倦的工作精神，加上骨子里渴望创造的强烈欲望","name":"Tom Ford ","label":"Tom Ford 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/40dc05c6-d86c-4e26-a55b-7360528860ad.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/27/2cc130d1-6cf4-4618-b0ca-64eeaa384177_1000x625.jpeg"],"id":110},{"city":"罗马","concept":"每季你都可以讲不同的故事，但只能是由同一语言讲出","name":"Maria Grazia Chiuri & Pierpaolo Piccioli","label":"Valentino 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/70986e1d-c00b-460b-8b6b-39ca5162be81.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/27/9044ed94-788b-40e2-a709-d8b50b82de88_1000x625.jpeg"],"id":109},{"city":"马德里","concept":"女人就像艺术品一样，没有年龄之分","name":"Josep Font","label":"Delpozo 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/0ad4c457-8223-4f60-b1d9-53894d62277e.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/29/dfbb26a5-df4c-4acd-a989-d0e89867576e_1000x625.jpeg"],"id":108},{"city":"斯德哥尔摩","concept":"激进有时也是一种牺牲","name":"Jonny Johansson","label":"Acne Studios 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/d89e4d31-2098-475a-84c7-dfc94eddb2c5.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/29/70071b5c-9986-4fc4-ab3f-c6c081e20f2a_1000x625.jpeg"],"id":106},{"city":"米兰","concept":"鞋子不该成为装饰的焦点","name":"Gianvito Rossi","label":"Gianvito Rossi 设计总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/0d8b88b1-19bf-40b3-8d49-a0b677899857.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/29/d43f68a0-b3b8-4057-b376-1e756ecd4169_1000x625.jpeg"],"id":104},{"city":"圣加仑州","concept":"时尚应该简单些，这个时代已经够复杂了","name":"Albert Kriemler","label":"Akris 设计总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/76ca8ba0-8dd8-49e6-9b92-83396001b1ff.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/29/d11e6af0-cef1-47a7-84ee-c9f25af8aefb_1000x625.jpeg"],"id":103},{"city":"纽约","concept":"时尚是有趣味性的，不要拘泥于陈旧。","name":"Jeremy Scott","label":"Moschino 技术总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/27/013ec08f-e6c8-406e-a178-36718ada9211.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/28/7cb468cf-a97c-4129-a92a-dcb44faa67e1_1000x625.jpeg"],"id":102},{"city":"波特兰","concept":"我喜欢把材料用在出其不意的地方","name":"Matt Pierce","label":"Wood & Faulk 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/18/882c923a-25f8-4dd7-b4ed-c6f53690382c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/19/792f4c47-907d-4ae9-ad13-525aa1220b8e_1000x625.jpeg"],"id":100},{"city":"佛罗伦萨","concept":"如果这双鞋子合脚，就穿各种颜色的这双鞋子吧","name":"Edgardo Osorio","label":"Aquazzura 设计总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/25/3f8460e7-0b16-4078-80f1-524673508b26.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/26/8ad96675-0ef5-4866-bf84-ad99cbeab684_1000x625.jpeg"],"id":98},{"city":"米兰","concept":"我希望人们记住Dolce & Gabbana 是因为感官的享受，地中海气质以及我们对生活的诚意","name":"Domenico Dolce & Stefano Gabbana","label":"Dolce & Gabbana 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/25/935baeae-2daa-435c-8b49-c7d18c2f37a1.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/27/d8a75820-2ecd-427c-b925-4645f00814cb_1000x625.jpeg"],"id":97},{"city":"伦敦","concept":"20岁是用来玩的，30岁要开始做事儿，40岁你就要站在正确的队列上了","name":"Dean & Dan Caten","label":"Dsquared2 设计总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/fbe58fc4-b9eb-4f96-b8eb-de362017aecf.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/25/a45bb8cc-a390-483d-8586-fea5e18b0a74_1000x625.jpeg"],"id":96},{"city":"米兰","concept":"时尚就是做梦以及让其他人也一起做梦","name":"Donatella Versace","label":"Versace 首席设计师，董事会副主席","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/33bdb955-87cf-4744-9c72-5e0fb099a2d9.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/25/50b2a3c3-9970-444f-80f3-f268c16b9978_1000x625.jpeg"],"id":95},{"city":"巴黎","concept":"我的字典里没有厌倦二字","name":"Christian Louboutin","label":"Christian Louboutin 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/dd5abf79-77bd-40da-9d14-80117a1d1a9c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/25/a60bda5d-3939-4690-9bfb-43b43f2efa65_1000x625.jpeg"],"id":94},{"city":"纽约","concept":"高品质是无法复制的。好的声望需要很久才能建立。","name":"Jenna Lyons","label":"J. Crew 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/4a45ba58-6d4f-469d-beba-92fea5e3536d.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/25/2c36e784-dce1-4dca-8c3f-5b0855cd087b_1000x625.jpeg"],"id":93},{"city":"纽约","concept":"请和衣服愉快的玩耍，Kenzo就应该有趣好玩。","name":"Carol Lim & Humberto Leon","label":"Kenzo 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/22/3a68f9a2-5299-4041-8d08-9c1666df7477.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/23/736d93df-8ac3-457a-8780-7e6063581376_1000x625.jpeg"],"id":92},{"city":"纽约","concept":"珠宝设计就是把我的信仰和价值观变为有形的实体","name":"Lena Skadegard ","label":"Lena Skadegard 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/15a6f4f6-0263-4f9f-a1e1-91fd38d0dd9c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/23/5b485e09-9079-479f-9618-49bf5f77d501_1000x625.jpeg"],"id":91},{"city":"罗利","concept":"把故事，心情和颜色融合在自己的作品里","name":"Ann Howell Bullard ","label":"Ann Howell Bullard 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/001bb8f3-60e1-4725-9aaf-c064495ab0ae.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/23/ce7cf696-31e4-4d0e-b019-ca0d27df3f38_1000x625.jpeg"],"id":90},{"city":"休斯顿","concept":"不要对未知感到害怕，持续提问并不惧失败是唯一一条通往未知的路","name":"Kathrine Zeren ","label":"Kathrine Zeren 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/23/d4620916-ae43-44de-aa6b-f43dbca0a590.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/23/60b21bc9-749e-40e8-9b93-8e53c78e43c4_1000x625.jpeg"],"id":89},{"city":"剑桥","concept":"好的设计应该是兼收并蓄而不是独断专有的","name":"Nick Koo","label":"Eone Time 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/18/5fa98293-555d-4d87-b30e-70d64639de69.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/18/a13a26a4-f03d-4f33-af0b-8953e163181d_1000x625.jpeg"],"id":87},{"city":"马修斯","concept":"记住你来自哪里，尊崇传统，从老一辈那里学习","name":"Xan Hood ","label":"Buffalo Jackson 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/19/c633dab3-f1c2-43b8-8d9c-3803d3c45c26.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/19/38da3cb1-1441-41f4-98cd-d1bd690bee4a_1000x625.jpeg"],"id":86},{"city":"克利夫兰","concept":"拖延是时间的小偷","name":"Todd Pownell","label":"Tap 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/18/5c54dab6-fe59-4d6d-bcd2-816ce4f7bba8.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/18/98324fa2-a7b6-4967-a3a7-0f1fec677a0e_1000x625.jpeg"],"id":85},{"city":"亚特兰大","concept":"简单和实用才真正经得起时间的考验","name":"Sarah Green","label":"Cord 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/18/e91d56eb-03f8-4941-818d-527dc82eca48.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/18/4bfc44bd-da04-4dab-8066-b5ad3d337275_1000x625.jpeg"],"id":84},{"city":"洛杉矶","concept":"不管你想怎样开始自己的人生，请一定要做你最爱的事情","name":"Kagan Taylor & Linda Hsiao","label":"Knotwork LA 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/18/8d0f03c2-05e6-40cb-8101-731b9f8fe093.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/18/370c0919-6df4-49d7-b595-017d99d83864_1000x625.jpeg"],"id":83},{"city":"伦敦","concept":"当你的品牌能够被他人预测的时候，你就遇上大麻烦了","name":"Jonathan Anderson","label":"J.W.Anderson 创始人，Loewe 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/12/1c550e7b-56cf-44a2-af40-7bfe07f0827b.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/12/89aec0a9-48a7-4858-95d4-dac3b752b94d_1000x625.jpeg"],"id":82},{"city":"普洛佛","concept":"我爱开始的过程，并发展成一个想法使它变成一种我可以持有的有形的产品。","name":"Quinn Peterson","label":"QPCollection 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/19/a276e37d-f4eb-4c28-af89-5ab4e2cab069.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/19/c2b0c56e-7019-4960-9e8d-063de6f0b655_1000x625.jpeg"],"id":80},{"city":"旧金山","concept":"没有必要在道义和美感之间妥协","name":"Rachel Gant & Andrew Deming","label":"Yield 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/cc971222-1f6e-4610-a141-36aeedcf1667.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/cffcc0a5-f548-4868-9460-3261b390e458_1000x625.jpeg"],"id":79},{"city":"纽约","concept":"唯有打开眼界和内心，灵感才会涌来","name":"Virginie Millefiori","label":"Virginie Millefiori 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/740ef4d2-bb4d-4b19-b7ce-576d57d896ff.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/fc9a35f9-9c77-4f0e-b759-3ebebbfbca02_1000x625.jpeg"],"id":78}]}
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
         * city : 爱尔兰
         * concept : 山川在呼唤我，我必须过去
         * name : Khrystyna Marriott
         * label : Ruby Robin 创始人
         * avatar_url : http://dstatic.zuimeia.com/designer/avatar/2016/8/31/ca3d6fdf-5ffe-4c70-aa78-ae61449eb820.jpg
         * recommend_images : ["http://dstatic.zuimeia.com/common/image/2016/8/31/e5bd2d42-4082-4d72-a727-f93f1ae27101_1000x625.jpeg"]
         * id : 113
         */

        private List<DesignersBean> designers;

        public int getHas_next() {
            return has_next;
        }

        public void setHas_next(int has_next) {
            this.has_next = has_next;
        }

        public List<DesignersBean> getDesigners() {
            return designers;
        }

        public void setDesigners(List<DesignersBean> designers) {
            this.designers = designers;
        }

        public static class DesignersBean {
            private String city;
            private String concept;
            private String name;
            private String label;
            private String avatar_url;
            private int id;
            private List<String> recommend_images;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public List<String> getRecommend_images() {
                return recommend_images;
            }

            public void setRecommend_images(List<String> recommend_images) {
                this.recommend_images = recommend_images;
            }
        }
    }
}
