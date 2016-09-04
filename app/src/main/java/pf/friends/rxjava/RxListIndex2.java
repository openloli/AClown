package pf.friends.rxjava;


import android.util.Log;

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
public class RxListIndex2 {
    private String URL;
    List<ListsBean> beans = new ArrayList<ListsBean>();

    public RxListIndex2(String url) {
        this.URL = url;
    }

    public List<ListsBean> getGist() throws IOException {

        try {
            Connection conn = Jsoup.connect(URL);
            Document doc = conn.timeout(5000).get();

            Element contentEle = doc.getElementById("NewsContentLabel");
                        String strs = contentEle.getElementById("NewsContentLabel").text();//这样会丢失标签
//            String strs = contentEle.getElementById("NewsContentLabel").toString();//保留标签
            Log.e("QT", "新闻主体内容文字--->" + strs);


            Elements images = contentEle.getElementsByTag("img");
            String[] imageUrls = new String[images.size()];
            for (int i = 0; i < imageUrls.length; i++) {
                imageUrls[i] = images.get(i).attr("src");
            }

            for (String str : imageUrls) {
                Log.e("QT", "图片地址--->" + str);
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