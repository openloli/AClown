package pf.pf.rxjava.data.modle;

/**
 * Created by Bingo on 2016/6/7.
 */
public class ApkInfo {

    /**
     * code : 1
     * message : 操作成功
     * data : {"code":"2","name":"2.0版本","url":"http://qingtuo.36ve.com/files/qt2.0.apk","des":"修复了若干的BUG"}
     */

    public String code;
    public String message;
    /**
     * code : 2
     * name : 2.0版本
     * url : http://qingtuo.36ve.com/files/qt2.0.apk
     * des : 修复了若干的BUG
     */

    public DataBean data;



    public   class DataBean {
        public String code;
        public String name;
        public String url;
        public String des;


    }
}
