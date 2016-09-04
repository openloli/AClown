package pf.friends.bean;

/**
 * Created by Bingo on 2016/9/2.
 */
public class ListsBean {
    public String url;
    public String title;
    public String time;

    public ListsBean(String url, String title, String time) {
        this.url = url;
        this.title = title;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
