package com.example.todayhistory.common;

/**
 * @PackageName: com.example.todayhistory
 * @ClassName: ContentURL
 * @Author: winwa
 * @Date: 2023/1/11 8:24
 * @Description:
 **/
public class URLHelper {

    public static String getTodayHistoryURL(int month, int day) {
        return "http://v.juhe.cn/todayOnhistory/queryEvent.php?date=" + month + "/" + day + "&key=ae731cac380465dced514a78417967d1";
    }

    public static String getLaoHuangLiURL(String date) {
        return "http://v.juhe.cn/laohuangli/d?date=" + date + "&key=db425f3245a74399980357f2d7510ea0";
    }

    public static String getHistoryDetailURL(String id) {
        return "http://v.juhe.cn/todayOnhistory/queryDetail.php?e_id=" + id + "&key=ae731cac380465dced514a78417967d1";
    }
}
