package com.example.todayhistory.bean;

import java.util.List;

/**
 * @PackageName: com.example.todayhistory.bean
 * @ClassName: HistoryDetailBean
 * @Author: winwa
 * @Date: 2023/1/11 8:32
 * @Description:
 **/
public class HistoryDetailBean {

    /**
     * reason : success
     * result : [{"e_id":"358","title":"蒋介石东山再起，复任总司令","content":"\n    在93年前的今天，1928年1月9日(农历1927年12月17日)，蒋介石东山再起，复任总司令。蒋介石摄于1928年1928年1月9日，蒋介石下野3个月后再次上台，去年8月，蒋介石下野，同年11月10日，蒋由日本返抵上海。为反对桂系据有国民党中央特别委员会实权，决定联汪制桂。蒋、汪达成协议：蒋复任总司令，汪复任国民政府主席。11月17日，粤、桂战争爆发。12月11日，中国共产党发动广州起义。两次事件都被反汪各派作为攻击汪精卫的借口。汪受各方指责，秘密离沪出国，蒋介石成了国民党的中心人物，各派纷纷电促他复职。今年1月4日，蒋回南京\u201c主持大计\u201d，9日通电宣告复职。","picNo":"1","picUrl":[{"pic_title":"蒋介石摄于1928年","suffix":"jpeg","id":1,"url":"https://aimgs.oss-cn-shenzhen.aliyuncs.com/history_2021/358_1.jpeg"}]}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * e_id : 358
         * title : 蒋介石东山再起，复任总司令
         * content :
         * 在93年前的今天，1928年1月9日(农历1927年12月17日)，蒋介石东山再起，复任总司令。蒋介石摄于1928年1928年1月9日，蒋介石下野3个月后再次上台，去年8月，蒋介石下野，同年11月10日，蒋由日本返抵上海。为反对桂系据有国民党中央特别委员会实权，决定联汪制桂。蒋、汪达成协议：蒋复任总司令，汪复任国民政府主席。11月17日，粤、桂战争爆发。12月11日，中国共产党发动广州起义。两次事件都被反汪各派作为攻击汪精卫的借口。汪受各方指责，秘密离沪出国，蒋介石成了国民党的中心人物，各派纷纷电促他复职。今年1月4日，蒋回南京“主持大计”，9日通电宣告复职。
         * picNo : 1
         * picUrl : [{"pic_title":"蒋介石摄于1928年","suffix":"jpeg","id":1,"url":"https://aimgs.oss-cn-shenzhen.aliyuncs.com/history_2021/358_1.jpeg"}]
         */

        private String e_id;
        private String title;
        private String content;
        private String picNo;
        private List<PicUrlBean> picUrl;

        public String getE_id() {
            return e_id;
        }

        public void setE_id(String e_id) {
            this.e_id = e_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPicNo() {
            return picNo;
        }

        public void setPicNo(String picNo) {
            this.picNo = picNo;
        }

        public List<PicUrlBean> getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(List<PicUrlBean> picUrl) {
            this.picUrl = picUrl;
        }

        public static class PicUrlBean {
            /**
             * pic_title : 蒋介石摄于1928年
             * suffix : jpeg
             * id : 1
             * url : https://aimgs.oss-cn-shenzhen.aliyuncs.com/history_2021/358_1.jpeg
             */

            private String pic_title;
            private String suffix;
            private int id;
            private String url;

            public String getPic_title() {
                return pic_title;
            }

            public void setPic_title(String pic_title) {
                this.pic_title = pic_title;
            }

            public String getSuffix() {
                return suffix;
            }

            public void setSuffix(String suffix) {
                this.suffix = suffix;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
