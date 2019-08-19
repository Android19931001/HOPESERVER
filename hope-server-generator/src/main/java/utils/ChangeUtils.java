package utils;

/**
 * @author wangning
 */
public class ChangeUtils {

    private static final String DIVIDER_CHAR = "_";

    /**
     * 修改表名为实体类名称（例如app_name->AppName）
     *
     * @param tableName
     * @return
     */
    public static String toJavaName(String tableName) {
        if (tableName.contains(DIVIDER_CHAR)) {
            String[] strNames = tableName.split(DIVIDER_CHAR);
            StringBuilder sb = new StringBuilder();
            for (String str : strNames) {
                appendStr(str, sb);
            }
            return sb.toString();
        } else {
            return tableName.substring(0, 1).toUpperCase() + tableName.substring(1, tableName.length());
        }
    }


    /**
     * 修改表名为文件夹名称（例如：app_name->appName）
     *
     * @return
     */
    public static String toFileDirName(String tableName) {
        if (tableName.contains(DIVIDER_CHAR)) {
            String[] strNames = tableName.split(DIVIDER_CHAR);
            StringBuilder sb = new StringBuilder();
            sb.append(strNames[0]);
            for (int i = 1; i < strNames.length; i++) {
                String str = strNames[i];
                appendStr(str, sb);
            }
            return sb.toString();
        } else {
            return tableName;
        }
    }

    /**
     * 拼接字符串
     *
     * @param str
     * @param sb
     */
    private static void appendStr(String str, StringBuilder sb) {
        if (str.length() > 1) {
            String firstChar = str.substring(0, 1);
            String otherChars = str.substring(1, str.length());
            sb.append(firstChar.toUpperCase() + otherChars);
        } else {
            sb.append(str.toUpperCase());
        }
    }
}
