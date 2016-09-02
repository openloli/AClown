package pf.pf.rxjava.data.modle;


/**
 * Created by AXTing on 2016/6/2.
 */
public class BUser {

    /**
     * code : 1
     * message : 登录成功
     * data : {"uid":"5747843d-21f2-4170-f4a5-32929e69858e","learn_id":"208","usertype":"1","talent":"2ce1d27d-e2ba-4246-9328-5afb2e1932c9","name":"姜宏","image":"files/personPhoto/15053217560/7e00c4780d5ca8f16dff80c90e0b88d9.jpg"}
     */

    private String code;
    private String message;
    /**
     * uid : 5747843d-21f2-4170-f4a5-32929e69858e
     * learn_id : 208
     * usertype : 1
     * talent : 2ce1d27d-e2ba-4246-9328-5afb2e1932c9
     * name : 姜宏
     * image : files/personPhoto/15053217560/7e00c4780d5ca8f16dff80c90e0b88d9.jpg
     */

    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String uid;
        private String learn_id;
        private String usertype;
        private String talent;
        private String name;
        private String image;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getLearn_id() {
            return learn_id;
        }

        public void setLearn_id(String learn_id) {
            this.learn_id = learn_id;
        }

        public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }

        public String getTalent() {
            return talent;
        }

        public void setTalent(String talent) {
            this.talent = talent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
