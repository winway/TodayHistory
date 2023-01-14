package com.example.todayhistory.bean;

/**
 * @PackageName: com.example.todayhistory.bean
 * @ClassName: LaoHuangLiBean
 * @Author: winwa
 * @Date: 2023/1/11 8:11
 * @Description:
 **/
public class LaoHuangLiBean {

    /**
     * reason : successed
     * result : {"id":"4611","yangli":"2023-01-11","yinli":"壬寅(虎)年十二月二十","wuxing":"大林木 定执位","chongsha":"冲猪(癸亥)煞东","baiji":"己不破券二比并亡 已不远行财物伏藏","jishen":"时阴 三合 六仪 玉堂","yi":"会亲友 纳采 进人口 修造 动土 竖柱 上梁 祭祀 开光 塑绘 祈福 斋醮 嫁娶 安床 移徙 入宅 安香 纳畜","xiongshen":"九坎 招摇 厌对 九焦 复日 重日","ji":"出行 治病 安葬 开市"}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * id : 4611
         * yangli : 2023-01-11
         * yinli : 壬寅(虎)年十二月二十
         * wuxing : 大林木 定执位
         * chongsha : 冲猪(癸亥)煞东
         * baiji : 己不破券二比并亡 已不远行财物伏藏
         * jishen : 时阴 三合 六仪 玉堂
         * yi : 会亲友 纳采 进人口 修造 动土 竖柱 上梁 祭祀 开光 塑绘 祈福 斋醮 嫁娶 安床 移徙 入宅 安香 纳畜
         * xiongshen : 九坎 招摇 厌对 九焦 复日 重日
         * ji : 出行 治病 安葬 开市
         */

        private String id;
        private String yangli;
        private String yinli;
        private String wuxing;
        private String chongsha;
        private String baiji;
        private String jishen;
        private String yi;
        private String xiongshen;
        private String ji;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getYangli() {
            return yangli;
        }

        public void setYangli(String yangli) {
            this.yangli = yangli;
        }

        public String getYinli() {
            return yinli;
        }

        public void setYinli(String yinli) {
            this.yinli = yinli;
        }

        public String getWuxing() {
            return wuxing;
        }

        public void setWuxing(String wuxing) {
            this.wuxing = wuxing;
        }

        public String getChongsha() {
            return chongsha;
        }

        public void setChongsha(String chongsha) {
            this.chongsha = chongsha;
        }

        public String getBaiji() {
            return baiji;
        }

        public void setBaiji(String baiji) {
            this.baiji = baiji;
        }

        public String getJishen() {
            return jishen;
        }

        public void setJishen(String jishen) {
            this.jishen = jishen;
        }

        public String getYi() {
            return yi;
        }

        public void setYi(String yi) {
            this.yi = yi;
        }

        public String getXiongshen() {
            return xiongshen;
        }

        public void setXiongshen(String xiongshen) {
            this.xiongshen = xiongshen;
        }

        public String getJi() {
            return ji;
        }

        public void setJi(String ji) {
            this.ji = ji;
        }
    }
}
