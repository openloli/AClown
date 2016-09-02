package pf.pf.rxjava.data.modle;


import java.util.List;

/**
 * Created by Bingo on 2016/6/13.
 */
public class Major {
    /**
     * code : ok
     * info : [{"mj_name":"新能源","mj_url":"http://180.212.82.145:18080/learning/","mj_inurl":""},{"mj_name":"半导体照明技术与应用","mj_url":"http://led.nbpt.edu.cn/","mj_inurl":""},{"mj_name":"焊接技术及自动化","mj_url":"http://101.71.249.92/hz_lms/","mj_inurl":""},{"mj_name":"服装设计","mj_url":"http://58.58.65.137:8080/learning/","mj_inurl":""},{"mj_name":"制冷与冷藏技术","mj_url":"http://218.13.33.159:8000/lms/","mj_inurl":""},{"mj_name":"汽车营销与服务","mj_url":"http://101.71.249.92/hn_lms/","mj_inurl":""},{"mj_name":"房地产","mj_url":"http://112.25.221.19:8000/xxpt/","mj_inurl":""},{"mj_name":"微电子","mj_url":"http://113.204.144.130/xxpt/","mj_inurl":""},{"mj_name":"电工与电子信息系","mj_url":"http://218.13.33.159:8000/lms/","mj_inurl":""},{"mj_name":"药品经营与管理","mj_url":"http://101.230.6.135/xxpt/","mj_inurl":""},{"mj_name":"机械产品检测检验技术","mj_url":"http://101.71.249.92/jj_lms/","mj_inurl":""},{"mj_name":"信息安全与管理","mj_url":"http://58.193.0.100/xxpt/","mj_inurl":""},{"mj_name":"工业分析技术","mj_url":"http://gyfxjszyk.ypi.edu.cn/xxpt/","mj_inurl":"http://172.16.1.32/xxpt/"},{"mj_name":"机械制造及自动化","mj_url":"http://112.25.221.19:8000/xxpt/","mj_inurl":""},{"mj_name":"建筑材料工程技术","mj_url":"http://211.83.136.126/xxpt/","mj_inurl":""},{"mj_name":"商务英语","mj_url":"http://58.62.144.172:8080/xxpt/","mj_inurl":""},{"mj_name":"动物检疫检验技术","mj_url":"http://222.43.71.131:8091/xxpt/","mj_inurl":""},{"mj_name":"计算机信息管理","mj_url":"http://221.234.230.10/xxpt/","mj_inurl":""},{"mj_name":"社会工作","mj_url":"http://218.13.33.159:8000/ys_lms/","mj_inurl":""},{"mj_name":"工商企业管理","mj_url":"http://218.13.33.159:8000/ys_lms/","mj_inurl":""},{"mj_name":"康复治疗技术","mj_url":"http://218.13.33.159:8000/ys_lms/","mj_inurl":""},{"mj_name":"家具设计与制造","mj_url":"http://218.13.33.159:8000/ys_lms/","mj_inurl":""},{"mj_name":"电子信息工程技术","mj_url":"http://218.13.33.159:8000/ys_lms/","mj_inurl":""},{"mj_name":"应用英语","mj_url":"http://218.13.33.159:8000/ys_lms/","mj_inurl":""},{"mj_name":"新能源汽车","mj_url":"http://101.71.249.92/hy_lms/","mj_inurl":""},{"mj_name":"\u201c国培计划\u201d培训班","mj_url":"http://101.71.249.92/xn_lms/","mj_inurl":""},{"mj_name":"公共网络","mj_url":"http://101.71.249.92/learning_test/","mj_inurl":""},{"mj_name":"本地网络","mj_url":"http://192.168.2.100/learning/","mj_inurl":""}]
     */

    public String code;
    public List<InfoBean> info;
    /**
     * mj_name : 新能源
     * mj_url : http://180.212.82.145:18080/learning/
     * mj_inurl :
     */


    public static class InfoBean {
        public String mj_name;
        public String mj_url;
        public String mj_inurl;
    }
}
