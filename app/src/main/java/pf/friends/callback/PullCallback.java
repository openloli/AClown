package pf.friends.callback;

/**
 * @author mabeijianxi
 */
public interface PullCallback {

    void onLoadMore();

    void onRefresh();

    boolean isLoading();

    boolean hasLoadedAllItems();

}
