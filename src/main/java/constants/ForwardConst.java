package constants;

//リクエストパラメーターの変数名、変数値、jspファイルの名前等画面遷移に関わる値を定義するEnumクラス

public enum ForwardConst {

    //action
    ACT("action"),
    ACT_TOP("Top"),
    ACT_USER("User"),
    ACT_GOODS("Goods"),
    ACT_AUTH("Auth"),

    //command
    CMD("command"),
    CMD_NONE(""),
    CMD_INDEX("index"),
    CMD_SHOW("show"),
    CMD_SHOW_LOGIN("showLogin"),
    CMD_LOGIN("login"),
    CMD_LOGOUT("logout"),
    CMD_NEW("entryNew"),
    CMD_CREATE("create"),
    CMD_EDIT("edit"),
    CMD_UPDATE("update"),
    CMD_DESTROY("destroy"),

    //jsp
    FW_ERR_UNKNOWN("error/unknown"),
    FW_TOP_INDEX("topPage/index"),
    FW_LOGIN("login/login"),
    FW_US_INDEX("users/index"),
    FW_US_SHOW("users/show"),
    FW_US_NEW("users/new"),
    FW_US_EDIT("users/edit"),
    FW_REP_INDEX("reports/index"),
    FW_REP_SHOW("reports/show"),
    FW_REP_NEW("reports/new"),
    FW_REP_EDIT("reports/edit");

    //文字列
    private final String text;

    //コンストラクタ
    private ForwardConst(final String text) {
        this.text=text;
    }

    //値の取得
    public String getValue() {
        return this.text;
    }

}
