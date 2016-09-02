package pf.pf.rxjava.data.api;

/**
 * Created by Bingo on 2016/6/13.
 */
public class api {


    /**
     * @author apple
     */


        /* 可复用 */
    public static final String URL_Token = "&token=";
    public static final String USERNAME = "&username=";
    public static final String TOKEN = "&token=";
    public static final String CourseID = "&course_id=";
    public static final String URL_Index = "http://182.92.129.16/xiaomi/index.php/";

    /****/


    /**
     * 个人信息修改接口，必要参数：username,token，修改参数，注，无修改不添加
     */
    //http://182.92.129.16/xiaomi/index.php/user/edit?username=13800138000
    public static final String edit_info = URL_Index + "/user/edit";
    /**
     * 找回密码
     */
    public static final String forgetPWD_01 = "http://182.92.129.16/xiaomi/index.php/forgetpwd/send?username=";
    public static final String forgetPWD_02 = "http://182.92.129.16/xiaomi/index.php/forgetpwd/verify?";
    /**
     * 获取更新版本
     */
    public static final String updateURL = "http://182.92.129.16/xiaomi/index.php/wangjian/pengfei";
    /**
     * 获取专业
     */
    public static final String defaultRUL = "http://182.92.129.16/xiaomi/index.php/wangjian/url";
    // http://182.92.129.16/xiaomi/index.php/UserDevice/AddUserDevice?device_type=0&token_id=8e7e6c0c844c4e4595dd28d698e22ab5
    /**
     * 注册，登录，时，psot 设备号 device_type=0 表示android系统 1=ios token_id 表示xmpp号
     * 注册时，以上参数即可，登录时，追加用户名
     */
    public static final String XMPP = URL_Index
            + "UserDevice/AddUserDevice?device_type=0&token_id=";
    /**
     * Login page *登录页面
     */
    public static final String URL_Login_01 = URL_Index
            + "user/login?device_type=0&username=";
    public static final String URL_Login_02 = "&password=";
    // http://182.92.129.16/xiaomi/index.php/user/logout?username=18513175036
    // 注销
    public static final String Logout = URL_Index + "user/logout?username=";
    // http://182.92.129.16/xiaomi/index.php/user/gettoken?username=18513175036
    // 获取token
    public static final String getToken = URL_Index + "user/gettoken?username=";

    /**
     * Register page *登录页面
     */
    /* 获取学校院系 */
	/* 获取 院系 */
	/* 获取 专业 */
    public static final String URL_getSchool_01 = URL_Index
            + "school/getschool";
    public static final String URL_getSchool_02 = URL_Index
            + "school/getdep?school_id=";
    public static final String URL_getSchool_03 = URL_Index
            + "school/Getmajor/school_uuid/";

    /**
     * PersonInfoCenter 个人中心-界面 获取个人详细信息
     */
    public static final String URL_CenterInfo = URL_Index
            + "user/getprofile?username=";

    /**
     * 根据用户名获取 token
     */
    public static final String URL_GetToken = URL_Index
            + "user/gettoken?username=";

    // http://182.92.129.16/xiaomi/index.php/school/Getmajor/school_uuid/005d4f69-3ef8-4e83-a591-2e18e49967db
	/* 短信验证 */
	/*
	 * "http://smsapi.c123.cn/OpenPlatform/OpenApi?action=sendOnce&ac=1001@501111770001&authkey=FBA899DB53749D0FFF3D305476EC9229&cgid=52&csid=101&c="
	 * + 内容 + "&m=" + 号码;
	 */
    public static final String URL_checkSMS_00 = "http://smsapi.c123.cn/OpenPlatform/OpenApi?";
    public static final String URL_checkSMS_01 = "http://smsapi.c123.cn/OpenPlatform/OpenApi?action=sendOnce&ac=1001@501111770001&authkey=FBA899DB53749D0FFF3D305476EC9229&cgid=52&csid=101&c=";
    public static final String URL_checkSMS_02 = "&m=";
	/* 注册 */

    public static final String URL_Register = URL_Index + "user/register?";
    public static final String URL_Register_01 = URL_Index + "user/register?username=";
    public static final String URL_Register_02 = "&password=";
    public static final String URL_Register_03 = "&email=";
    public static final String URL_Register_04 = "&school=";
    public static final String URL_Register_05 = "&department=";
    public static final String URL_Register_06 = "&xueli=";
    public static final String URL_Register_07 = "&is_graduate=";
    public static final String URL_Register_08 = "&type=";
    public static final String URL_Register_09 = "&tel=";

    /** 登出 */
    // http://192.168.1.104/web/xiaomi/index.php/user/logout
    // public static final String URL_UNLogin = "&m=";
    // TODO
    // TODO
    // TODO 非公共网络
    // TODO
    // TODO

    /**
     * nxgs--国培 TJQG2--新能源 NZ--半导体照明 HZ-焊接及自动化 SK--服装--山科
     */
//	public static String NXGS = xxx("国培");//aCache.getAsString("deURL");// "http://101.71.249.92/xn_lms/?";//
//	public static String TJQG2 = xxx("新能源");//aCache.getAsString("url_xny");// "http://180.212.82.145:18080/learning/?";//
//	public static String NZ = xxx("半导体照明");//aCache.getAsString("url_bdttm");// "http://101.71.249.92/nz_lms/?";//
//	public static String HZ = xxx("焊接及自动化");//aCache.getAsString("url_hjzdh");// "http://101.71.249.92/hz_lms/?";//
//	public static String SK = xxx("服装设计");//aCache.getAsString("url_fzsj");// "http://58.58.65.137:8080/learning/?";//
//	public static String ZL = xxx("制冷与冷藏技术");//aCache.getAsString("url_zllcjs");// "http://218.13.33.159:8000/lms/?";//// 制冷与冷藏技术专业
//	public static String P = xxx("公共网络");//aCache.getAsString("url_gw");// "http://182.92.129.16/learning2/?";//// 公网
//	public static String L = xxx("本地网络");//aCache.getAsString("url_bd");// "http://192.168.2.100/learning/?";//// 本地

    // public static String TJQG =
    // aCache.getAsString("url_gw");//"http://211.81.40.115/learning/?";//


    /**
     * xxx page *xx页面
     */
    // 根据course_id 获取课程列表
    // public static final String getCourseList =
    // "http://101.71.249.92/learning_test/??q=get_course_module_items2/";
    public static final String getCourseList = "?q=get_course_module_items2/";

    /**
     * 在线学习--首页-页面
     */
    // http://192.168.2.101/learning/??q=get_courses_list&username=18513175036&token=23221f42da2e4e1ff56e3f023d5bc1d9&student_status=5
	/* ReadingCourses page 在学课程 */
    public static final String URL_Reading_01 = "?q=get_courses_list&student_status=5&username=";
    /* OldCourses page 已学课程 */
    public static final String URL_OldCourses_01 = "?q=get_courses_list&username=";
    public static final String URL_OldCourses_02 = "&end=1&token=";
	/* AllCourses page 所有课程 */
    /**
     * 推荐？？？
     */
//	q=get_courses_list&recommand=1&page_no=%ld&page_size=%d&username=%@&token=%@"
    //http://101.71.249.92/xn_lms/?q=get_courses_list&recommand=1&page_no=1d&page_size=999d&username=13800138002&token=f28bbef1e4912f3ba71acf8d8ea74ac1
    public static final String URL_TJ = "?q=get_courses_list&recommand=1&page_no=1&page_size=999";

    /**
     * 更多 课程列表
     */
    public static final String TOPS = "?q=get_courses_list&top_view=5&day=30";
    public static final String NEWS = "?q=get_courses_list&quantity=5";
    public static final String COMMS = "?q=get_courses_list&recommand=1";

    /* 审核课程 */
    public static String URL_checking = "?q=get_courses_list&student_status=6&username="; // +
    // URL_Token
    // 1
    public static final String URL_allCourses = "?q=get_courses_list_new_hot_recommand";
    // 2 有用户名时：使用说明： URL_allCourses_useTokne+xxx+ URL_Token+xxx
    public static final String URL_allCourses_haveName = "?q=get_courses_list_new_hot_recommand&username=";

    /* 课程报名 */
    public static final String URL_CourseDes_01 = "?q=service_apply_course&username=";
    public static final String URL_CourseDes_02 = "&course_id=";
    public static final String URL_CourseDes_03 = "&course_visibility=";
	/* SearchClassify 分类查找页面 */

    public static final String URL_Search_01 = "?q=get_term_list"; // 获取分类列表
    public static final String URL_Search_02 = "?q=get_courses_list&tid=";// 根据tid的查询课程类型
    public static final String URL_Search_03 = "?q=get_courses_list&keywords=";// 根据
    // 关键字
    // 搜索课程

    /**
     * TODO ScanCharactersActivity 扫码签到的界面
     */
    public static final String SGIN_Pager = "?q=course_class_signin/4";

    /**
     * ShowVideo 学习内容界面
     */
    public static final String URL_ShowVideo_01 = "?q=get_file_url/";
    public static final String URL_ShowVideo_02 = "&resource=0";// 来源于学习平台
    public static final String URL_ShowVideo_03 = "&resource=1";// 来源于资源库


    //http://192.168.2.100/learning?q=save_user_course_evaluate&username=even&token=***&course_id=52270&star_num=4
    public static final String URL_Score = "?q=save_user_course_evaluate&username=";
    public static final String URL_Score_01 = "&star_num=";
    // http://192.168.2.100/learning/??q=get_course_notes&course_id=42677&username=18513175036&token=2f09ee645b9e659e720bbb9fe5abbbde
    // 获取某课程下所有笔记列表
    public static final String URL_ShowVideo_courses_01 = "?q=get_course_notes&course_id=";// +课程id
    public static final String URL_ShowVideo_courses_02 = "&username=";// 账号
    public static final String URL_ShowVideo_courses_03 = "&token=";// token
    /* WriteNote 写笔记-界面 */
    public static final String URL_WriteNote_up_01 = "?q=save_remote_file"; // 获取
    // 、、http://192.168.2.100/learning?
    /**
     * 保存笔记
     */
    public static final String URL_savaNote = "?q=save_note&title="; // 保存笔记
    public static final String URL_savaNote02 = "?q=save_note"; // 保存笔记
    /**
     * 保存任务
     */
    public static final String URL_savaTask = "?q=task/report/save&task_id=";

    /* NotesListFullScreen 全屏笔记-界面 */
    public static final String URL_NotesFull = "?q=get_note_content/";// +/[note_id]获取指定的笔记内容

    // http://192.168.2.100/learning/??q=mobile_quiz_take/52638&username=18513175036&token=null
    // ShowVideoTabText 测验界面
    public static final String URL_getQuiz = "?q=get_course_quiz&course_id=";// +/[course_id]根据课程id获得所有的测验
    public static final String URL_getQuizItem = "?q=mobile_quiz_take/";// +/[qid]+usename+tonek进入具体的测验界面

    // 、、http://192.168.2.100/learning/??q=mobile_quiz_task_info/[task_id]
    // http://192.168.2.100/learning/??q=mobile_quiz_task_info/52765
    // ShowVideoTabTask 任务界面
    // public static final String URL_getTask = Index +
    // "?q=get_course_task&course_id=";// +/[course_id]根据课程id获得所有的任务
    public static final String URL_getTask1 = "?q=node/";// +/[course_id]根据课程id获得所有的任务
    public static final String URL_getTask2 = "/task/list";// 1+2为最新接口

    public static final String URL_getTaskDes = "?q=mobile_quiz_task_info/"; // +task_id+usename+tonek进入具体的任务界面
    // 根据任务id查看该任务的状态
    public static final String URL_getTaskType = "?q=task/report/info/";// +task_id+usename
    // 根据任务id查看该任务的状态
    /**
     * 下载
     */
    public static final String URL_down = "?q=get_course_download_list&course_id=";
    /**
     * web 本地页面
     */
    public static final String Web_Local = "file:///android_asset/index.html";
    /**
     * 测验 web 页面
     */
    public static final String Web_quiz_01 = "?q=mobile/bbs/item/";// +course_id
    // 局部页面时+username
    public static final String Web_quiz_02 = "?q=mobile/discuss/";// +course_id
    // 全屏页面页面时+username
    public static final String Web_quiz_03 = "?q=mobile/discuss/publish/";// +course_id
    // 发帖时+username

    /**
     * 获取SMS
     */
    //注册
    public static final String getSMS_01 = "http://182.92.129.16/xiaomi/index.php/sendsms/send?username=";
    //忘记密码、修改密码 获取短信的接口       forgetpwd/send?username=%@，忘记密码
    public static final String getSMS_02 = "http://182.92.129.16/xiaomi/index.php/forgetpwd/send?username=";
    // 修改密码提交接口，code是验证码，"forgetpwd/verify?username=%@&code=%@&password=%@"
//	public static final String getSMS_03 = "http://182.92.129.16/xiaomi/index.php/forgetpwd/verify?username=%@&code=%@&password=%@"

    //踢人推送。  你的设备在另一个手机登录,若非本人操作,请及时修改密码!" urlEncodeString],[@"下线通知
    //http://182.92.129.16/xiaomi/index.php/AutoRun/newscenter?from_person=1&contents=您的设备在另一台手机登录,若非本人操作,请及时修改密码!&title=下线通知&uri=1&broadcast=N&username=13051759757
    public static final String get2Login = URL_Index + "AutoRun/newscenter?from_person=18513198597&contents=您的设备在另一台手机登录,若非本人操作,请及时修改密码!&title=下线通知&uri=1&broadcast=N&username=";

}
