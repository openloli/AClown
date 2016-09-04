package pf.friends.rxjava;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pf.friends.bean.ListsBean;
import rx.Observable;
import rx.functions.Func0;


/**
 * 单个子任务详情+指标项列表
 */
public class RxListIndex1 {
    private String urlStr="http://news.yule.com.cn/hanguo/";
    List<ListsBean> beans = new ArrayList<ListsBean>();

    public RxListIndex1(String url) {
        this.urlStr = urlStr+url;
    }

    public List<ListsBean> getGist() throws IOException {

        try {
            Connection conn = Jsoup.connect(urlStr);
            Document doc = conn.timeout(5000).get();

            Element contentEle = doc.getElementById("theContent");
            Elements images = contentEle.getElementsByTag("a");
            String[] imageUrls = new String[images.size()];
            String[] titleStr = new String[images.size()];
            for (int i = 0; i < imageUrls.length; i++) {
                imageUrls[i] = images.get(i).attr("href");
                titleStr[i] = images.get(i).attr("title");
            }
            Elements newDate = contentEle.getElementsByClass("newDate");
            for (int i = 0; i < newDate.size(); i++) {
                beans.add(new ListsBean(imageUrls[i], titleStr[i], newDate.get(i).text()));
            }
            return beans;
        } catch (Exception e) {
        }

        return null;
    }

    public Observable<List<ListsBean>> getGistObservable() {
        return Observable.defer(new Func0<Observable<List<ListsBean>>>() {
            @Override
            public Observable<List<ListsBean>> call() {
                try {
                    return Observable.just(getGist());
                } catch (IOException e) {
                    return Observable.error(e);
                }
            }
        });

    }
}