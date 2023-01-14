package com.example.todayhistory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @PackageName: com.example.todayhistory.bean
 * @ClassName: HistoryBean
 * @Author: winwa
 * @Date: 2023/1/10 8:46
 * @Description:
 **/
public class HistoryBean implements Serializable {

    /**
     * reason : success
     * result : [{"day":"1/10","date":"9年1月10日","title":"西汉皇帝刘婴被废，王莽登基，新朝建立，西汉灭亡","e_id":"385"},{"day":"1/10","date":"947年1月10日","title":"耶律德光进军开封，契丹灭后晋","e_id":"386"},{"day":"1/10","date":"1209年1月10日","title":"蒙古帝国第四位大汗元宪宗蒙哥诞生","e_id":"387"},{"day":"1/10","date":"1294年1月10日","title":"景教教士拉班·扫马去世","e_id":"388"},{"day":"1/10","date":"1356年1月10日","title":"卢森堡家族的查理四世在纽伦堡颁布了黄金诏书","e_id":"389"},{"day":"1/10","date":"1475年1月10日","title":"瓦斯卢伊战役结束","e_id":"390"},{"day":"1/10","date":"1573年1月10日","title":"德国天文学家和医生西门·马里乌斯出生","e_id":"391"},{"day":"1/10","date":"1775年1月10日","title":"俄罗斯农民起义领袖普加乔夫被处决","e_id":"392"},{"day":"1/10","date":"1778年1月10日","title":"瑞典博物学家格奈逝世","e_id":"393"},{"day":"1/10","date":"1814年1月10日","title":"清代诗人、史学家赵翼逝世","e_id":"394"},{"day":"1/10","date":"1840年1月10日","title":"罗兰·希尔改革邮政获得成功","e_id":"395"},{"day":"1/10","date":"1861年1月10日","title":"佛罗里达州宣布退出合众国","e_id":"396"},{"day":"1/10","date":"1863年1月10日","title":"世界上第一条地铁伦敦地铁通车","e_id":"397"},{"day":"1/10","date":"1870年1月10日","title":"洛克菲勒创办标准石油","e_id":"398"},{"day":"1/10","date":"1875年1月10日","title":"民国奇人杨度出生","e_id":"399"},{"day":"1/10","date":"1883年1月10日","title":"苏联作家阿·托尔斯泰出生","e_id":"400"},{"day":"1/10","date":"1908年1月10日","title":"中国果树学家、园艺教育家孙云蔚出生","e_id":"401"},{"day":"1/10","date":"1913年1月10日","title":"西藏宣布独立，但未获中国政府承认","e_id":"402"},{"day":"1/10","date":"1914年1月10日","title":"商务印书馆创办人夏瑞芳遇刺身亡","e_id":"403"},{"day":"1/10","date":"1914年1月10日","title":"袁世凯宣布解散国会","e_id":"404"},{"day":"1/10","date":"1920年1月10日","title":"国际联盟成立","e_id":"405"},{"day":"1/10","date":"1921年1月10日","title":"土耳其涅纽村战役，国民军击溃希腊军队的进攻","e_id":"406"},{"day":"1/10","date":"1923年1月10日","title":"法国、比利时联军占领德国鲁尔地区","e_id":"407"},{"day":"1/10","date":"1925年1月10日","title":"香港恒生指数创办人关士光出生","e_id":"408"},{"day":"1/10","date":"1929年1月10日","title":"漫画《丁丁历险记》首次在报纸上连载","e_id":"409"},{"day":"1/10","date":"1934年1月10日","title":"乌克兰第一任总统列昂尼德·克拉夫丘克出生","e_id":"410"},{"day":"1/10","date":"1938年1月10日","title":"日本军队登陆青岛","e_id":"411"},{"day":"1/10","date":"1938年1月10日","title":"美国计算机科学家高德纳出生","e_id":"412"},{"day":"1/10","date":"1943年1月10日","title":"苏军对斯大林格勒被围德军发起最后总攻","e_id":"413"},{"day":"1/10","date":"1946年1月10日","title":"联合国大会第一届第一次会议在伦敦举行","e_id":"414"},{"day":"1/10","date":"1946年1月10日","title":"\u201c政协会议\u201d否定国民党独裁统治","e_id":"415"},{"day":"1/10","date":"1949年1月10日","title":"淮海战役结束","e_id":"416"},{"day":"1/10","date":"1949年1月10日","title":"蒋介石下令，中央银行将现金移往台湾","e_id":"417"},{"day":"1/10","date":"1955年1月10日","title":"中国京剧院成立","e_id":"418"},{"day":"1/10","date":"1957年1月10日","title":"麦克米伦接替艾登的英国首相职务","e_id":"419"},{"day":"1/10","date":"1959年1月10日","title":"中国第一条输油管线建成并开始输油","e_id":"420"},{"day":"1/10","date":"1962年1月10日","title":"南美秘鲁安卡什省瓦斯卡兰山冰崩","e_id":"421"},{"day":"1/10","date":"1964年1月10日","title":"我国与突尼斯建交","e_id":"422"},{"day":"1/10","date":"1964年1月10日","title":"巴拿马宣布与美国断交，要求归还巴拿马运河的所有权","e_id":"423"},{"day":"1/10","date":"1965年1月10日","title":"留尼汪岛上的居民欢度糖节","e_id":"424"},{"day":"1/10","date":"1966年1月10日","title":"印巴签署 《塔什干宣言》","e_id":"425"},{"day":"1/10","date":"1971年1月10日","title":"著名设计师可可·香奈儿去世","e_id":"426"},{"day":"1/10","date":"1977年1月10日","title":"远东最大规模的香港海洋公园开放","e_id":"427"},{"day":"1/10","date":"1981年1月10日","title":"乌拉圭获\u201c纪念世界杯足球赛50周年\u201d金杯足球赛冠军","e_id":"428"},{"day":"1/10","date":"1981年1月10日","title":"全国最佳运动员评选活动揭晓","e_id":"429"},{"day":"1/10","date":"1984年1月10日","title":"赵紫阳总理开始对美国进行正式访问","e_id":"430"},{"day":"1/10","date":"1985年1月10日","title":"第六届全国人大常委会确定建立教师节","e_id":"431"},{"day":"1/10","date":"1988年1月10日","title":"刘小光获第一届中国围棋名人战冠军","e_id":"432"},{"day":"1/10","date":"1991年1月10日","title":"日本仙台高等法院判决政府阁僚等参拜靖国神社违反宪法","e_id":"433"},{"day":"1/10","date":"1995年1月10日","title":"中国国家气象中心在北京成立","e_id":"434"},{"day":"1/10","date":"2000年1月10日","title":"美国在线联姻时代华纳","e_id":"435"},{"day":"1/10","date":"2001年1月10日","title":"中国神舟二号无人飞船发射成功","e_id":"436"},{"day":"1/10","date":"2002年1月10日","title":"中国\u201c民俗学之父\u201d钟敬文病逝","e_id":"437"},{"day":"1/10","date":"2002年1月10日","title":"首届\u201c中华环境奖\u201d颁奖典礼在北京举行","e_id":"438"},{"day":"1/10","date":"2003年1月10日","title":"朝鲜宣布退出《核不扩散条约》","e_id":"439"},{"day":"1/10","date":"2008年1月10日","title":"雪灾在南方爆发","e_id":"440"},{"day":"1/10","date":"2013年1月10日","title":"中国食人魔案件始末","e_id":"441"},{"day":"1/10","date":"2014年1月10日","title":"张存浩和程开甲获国家最高科技奖","e_id":"442"},{"day":"1/10","date":"2019年1月10日","title":"国医大师邓铁涛逝世","e_id":"443"},{"day":"1/10","date":"2020年1月10日","title":"澳大利亚山火持续肆虐","e_id":"444"}]
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

    public static class ResultBean implements Serializable {
        /**
         * day : 1/10
         * date : 9年1月10日
         * title : 西汉皇帝刘婴被废，王莽登基，新朝建立，西汉灭亡
         * e_id : 385
         */

        private String day;
        private String date;
        private String title;
        private String e_id;
        private String first_url;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getE_id() {
            return e_id;
        }

        public void setE_id(String e_id) {
            this.e_id = e_id;
        }

        public String getFirst_url() {
            return first_url;
        }

        public void setFirst_url(String first_url) {
            this.first_url = first_url;
        }
    }
}
