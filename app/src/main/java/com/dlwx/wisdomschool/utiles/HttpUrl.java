package com.dlwx.wisdomschool.utiles;

/**
 * Created by Administrator on 2018/1/2/002.
 */

public class HttpUrl {
    private static final String BaseUrl = "http://39.107.74.235/school/index.php/Mobile/";
    private static final String BaseUrl1 = "http://39.107.74.235/school/index.php/Mobile/";
    private static final String WebUrl = "http://39.107.74.235/school/";

    public static final String get_teacher_code = BaseUrl + "Register/get_teacher_code";//获取教师邀请码
    public static final String check_teacher_code = BaseUrl + "Register/check_teacher_code";//教师邀请码验证
    public static final String login = BaseUrl + "Login/login";//登录
    public static final String setnewpassword = BaseUrl + "Register/setnewpassword";//忘记密码
    public static final String register = BaseUrl + "Register/addtelephone";//注册
    public static final String UploadFile = BaseUrl + "Mobile/uploadFile";//上传图片
    public static final String UploadAll = BaseUrl + "Mobile/uploadFile_all";//上传图片
    public static final String createclass = BaseUrl + "Classroom/createclass";//创建班级
    public static final String Classroom = BaseUrl + "Classroom/index";//我创建的班级/我加入的班级
    public static final String classdesc = BaseUrl + "Classroom/myclass";//班级详情
    public static final String get_classinfo = BaseUrl + "Classroom/get_classinfo";//班级信息
    public static final String set_classinfo = BaseUrl + "Classroom/set_classinfo";//设置班级信息
    public static final String Classapplylist = BaseUrl + "Classroom/applylist"; //班级申请列表
    public static final String findClass = BaseUrl + "Classroom/findclass";//查找班级
    public static final String batch_adduser = BaseUrl + "Classroom/batch_adduser";//分享成员进目标班级
    public static final String JoinClass = BaseUrl + "Classroom/addclass";//加入班级
    public static final String Edit_Apply = BaseUrl + "Classroom/edit_apply";//同意/忽略入班操作，同意/忽略退班操作
    public static final String set_teach = BaseUrl + "Classroom/set_teacher";//添加任课老师
    public static final String LookMemberMess = BaseUrl + "Classroom/class_one_userinfo";//点击成员头像查看联系人信息
    public static final String changeClassJurisd = BaseUrl + "Classroom/edit_user_power";//班级内成员权限修改
    public static final String getClassFile = BaseUrl + "Classroom/classfile";//班级文件
    public static final String CreateClassFile = BaseUrl + "Classroom/makefolder";//"创建班级文件夹";
    public static final String AddFile = BaseUrl + "Classroom/addfile";//添加文件
    public static final String deleteClass = BaseUrl + "Classroom/delclass";//删除班级
    public static final String setWorkTime = BaseUrl + "User/set_worktime";//设置工作时间
    public static final String Growthrecord = BaseUrl1 + "Growthrecord/grow_list";//成长记录列表数据
    public static final String Signlist = BaseUrl1 + "Sign/Signlist";//成长纪录标签
    public static final String common_sign = BaseUrl1 + "Sign/common_sign";//常用标签
    public static final String Edit_info = BaseUrl + "User/edit_userinfo";//修改个人昵称，头像，所在学校
    public static final String MyMess = BaseUrl + "User/userinfo";//个人资料
    public static final String AddTag = BaseUrl1 + "Sign/addSign";//添加个人标签
    public static final String DelteSign = BaseUrl1 + "Sign/delSign";//删除标签
    public static final String SendgroupUp = BaseUrl1 + "Growthrecord/add_record";//发布成长记录
    public static final String CheckSign = BaseUrl1 + "Sign/owed_sign";//添加记录时，检查用户已完成的综合素质
    public static final String getBookBag = BaseUrl + "Bookbag/classfile";//智慧书包全部文件列表
    public static final String CreateBookbag = BaseUrl + "Bookbag/makefolder";//创建智慧书包文件夹
    public static final String BookBagAddFile = BaseUrl + "Bookbag/addfile";//智慧书包添加文件
    public static final String GetScore_record = BaseUrl + "Score/score_record";//年份下考试列表
    public static final String get_xueke = BaseUrl + "Score/get_xueke";//获取该考试下所有学科
    public static final String user_score_sort = BaseUrl + "Score/user_score_sort";//各科成绩排名
    public static final String RecordComment = BaseUrl1 + "Praisecomment/add_view";//成长纪录评论
    public static final String Recordreply = BaseUrl1 + "Praisecomment/reply_view";//成长纪录回复
    public static final String RecordPrise = BaseUrl1 + "Praisecomment/praise_record";//成长记录，用户点赞/取消点赞
    public static final String DeleteRecord = BaseUrl1 + "Growthrecord/del_record";//删除一条成长记录，记录分享页面数据
    public static final String EightSign = BaseUrl1 + "sign/number_of_labels";//8个综合素质标签完成的数量
    public static final String Add_group = BaseUrl + "Easemob/add_group";//创建环信群时保存群信息
    public static final String Grouplist = BaseUrl + "Easemob/get_grouplist";//获取群列表
    public static final String ActionTitle = BaseUrl + "Public/themelist";//活动主题
    public static final String Publish_inves = BaseUrl + "Investigation/publish_inves";//发布调查
    public static final String WorkList = BaseUrl + "Investigation/Investigation_list";//作业列表
    public static final String ActionDesc = BaseUrl + "Investigation/activity_info";//老师发表的活动详情
    public static final String JoinAction = BaseUrl + "Investigation/add_activity_pinglun";//参与活动
    public static final String ActionDianzan = BaseUrl + "Investigation/zan_cancelzan";//给参与活动的记录点赞/取消点赞
    public static final String ActionPinglun = BaseUrl + "Investigation/pingjia_activity";//去评价参与活动的记录
    public static final String Situation = BaseUrl + "Investigation/situation";//查看阅读情况1查看数据 2点击阅读）
    public static final String AgeWeek = BaseUrl1 + "Magazine/age_magazine";//年龄周刊列表
    public static final String VoideUrl = WebUrl + "web/video_strategy.html";//视频wenb
    public static final String AgeWeekWeb = WebUrl + "web/weekly_classify.html";
    public static final String UpExcle = BaseUrl + "Score/addscore";//上传成绩单excel
    public static final String HomeList = BaseUrl + "Magazine/age_magazine";//首页周刊列表 + 首页文章列表
    public static final String Examagelist = BaseUrl + "Exam/agelist";//阶段考试列表
    public static final String Examexamlist = BaseUrl + "Exam/examlist";//家长考试试题列表
    public static final String ExamSubmit = BaseUrl + "Exam/show_zhengshu";//答题结束显示证书
    public static final String Zhengshu = BaseUrl + "Exam/allzhengshu";//我的证书
    public static final String DownExcMoban = "http://39.107.74.235/school/static/ScoreImport.xlsx ";//成绩模版
    public static final String All_Xueke = BaseUrl + "Score/all_xueke";//成绩分析-获取该年份下所有学科
    public static final String GetScore_Tab = BaseUrl + "Score/all_score_table";//成绩分析-显示某年某人某科成绩走势图
    public static final String Verify = BaseUrl + "Mobile/verify";//发短信页面图形验证码
    public static final String SmsAuth = BaseUrl + "Register/sms";//发验证码接口
    public static final String FeedBack = BaseUrl + "Public/view";//反馈建议
    public static final String MyHisId = BaseUrl + "Classroom/myrole";//我使用过的角色
    public static final String DeleteMember = BaseUrl + "Classroom/deluser";//请出班级
    public static final String ChangeClassId = BaseUrl + "Classroom/edit_myrole";//修改我这班级中的身份
    public static final String GroupMemberList = BaseUrl + "Easemob/show_alluser";//群成员列表
    public static final String GroupDeleteMember = BaseUrl + "Easemob/del_user";//删除群内成员
    public static final String DeleteGroup = BaseUrl + "Easemob/del_group";//解散群聊
    public static final String Group_addUser = BaseUrl + "Easemob/add_user";//群添加成员
    public static final String getAllClassMember = BaseUrl + "Classroom/get_all_class_user";//班级以及所有成员显示
    public static final String TuiClass = BaseUrl + "User/tuiclass";//家长申请退出班级
    public static final String SysMess = BaseUrl + "message/message_list";//系统消息
    public static final String Push_message = BaseUrl + "message/push_message";//作业推送消息
}
