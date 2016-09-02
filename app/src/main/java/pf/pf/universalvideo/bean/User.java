package pf.pf.universalvideo.bean;

/**
 * Created by AXTing on 2016/4/8.
 */
public class User {
    private String name;
    private String des;
    private String des1;
    private String des2;
    private String des3;

    public User(String name, String des, String des1, String des2, String des3) {
        this.name = name;
        this.des = des;
        this.des1 = des1;
        this.des2 = des2;
        this.des3 = des3;
    }
    public User(String name, String des, String des1, String des2) {
        this.name = name;
        this.des = des;
        this.des1 = des1;
        this.des2 = des2;
        this.des3 = null;
    }

    public User(String name, String des, String des1) {
        this.name = name;
        this.des = des;
        this.des1 = des1;
        this.des2 = null;
        this.des3 = null;
    }

    public User(String name, String des) {
        this.name = name;
        this.des = des;
        this.des1 = null;
        this.des2 = null;
        this.des3 = null;
    }
    public User( String des) {
        this.name = null;
        this.des = des;
        this.des1 = null;
        this.des2 = null;
        this.des3 = null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDes1() {
        return des1;
    }

    public void setDes1(String des1) {
        this.des1 = des1;
    }

    public String getDes2() {
        return des2;
    }

    public void setDes2(String des2) {
        this.des2 = des2;
    }

    public String getDes3() {
        return des3;
    }

    public void setDes3(String des3) {
        this.des3 = des3;
    }




/**
    <android.support.v7.widget.RecyclerView
    android:visibility="gone"
    android:id="@+id/id_recyclerview"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:divider="#ffff0000"
    android:dividerHeight="10dp" />
*/

}

