package com.hope.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hope.server.utils.ChangeUtils;
import com.hope.server.utils.FileGenerator;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author wangning
 */
public class CodeGenerator {
    /**
     * 数据库连接地址
     */
    private static final String DATA_BASE_URL = "jdbc:mysql://121.36.66.235:3306/chatcloud?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false";

    /**
     * 数据登录用户名
     */
    private static final String DATA_BASE_USER = "root";

    /**
     * 数据登录密码
     */
    private static final String DATA_BASE_PWD = "feilong@1993";

    /**
     * 数据库链接驱动
     */
    private static final String dbDriver = "com.mysql.cj.jdbc.Driver";

    /**
     * java文件生成路径
     */
    public static String JAVA_FILE_PATH = System.getProperty("user.dir") + "/%s/src/main/java/%s/";

    private static Logger logger = LoggerFactory.getLogger(CodeGenerator.class);

//    om_cust_cash_base

    public static void main(String[] args) throws Exception {

//        System.out.println("请输入购买的啤酒个数：");
//        Scanner scanner = new Scanner(System.in);
//        int beerAccount = scanner.nextInt();
//        int totalDrinkBeer = beerAccount;
//        //瓶盖起始数量
//        int caps = beerAccount;
//        int glsses = beerAccount;
//        while (true) {
//            int beerCap = caps / 4;
//            int beerGlass = beerAccount / 2;
//            //兑换之后的瓶盖数量
//            caps = caps % 4 + beerGlass + beerCap;
//            glsses = glsses - beerGlass + beerCap;
//            if (beerCap == 0 && beerGlass == 0) {
//                break;
//            }
//            //当前可以换的数量
//            totalDrinkBeer = totalDrinkBeer + beerCap + beerGlass;
//            beerAccount = beerAccount - beerGlass + beerCap;
//        }
//        System.out.println("总共可以喝的啤酒个数为：" + totalDrinkBeer + "\n剩余的瓶盖数量：" + caps + "\n剩余的空瓶：" + glsses);


        System.out.println("请输入模块包名：例如（hope-frame-server）");
        Scanner scanner = new Scanner(System.in);
        String moduleName = scanner.next().trim();
        System.out.println("请输入表名称：例如（app_name_check）");
        String tableName = scanner.next().trim();
        System.out.println("请输入包名：例如（com.hope.frame）");
        String packageName = scanner.next().trim();
        String filePath = String.format(JAVA_FILE_PATH, moduleName, packageName.replace(".", "/")) + ChangeUtils.toFileDirName(tableName) + "/";
        System.out.println("文件输入路径：=========== " + filePath);
        Connection connection = getConnection();
        if (null != connection) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, "%", tableName, "%");
            FileGenerator.instance(packageName, tableName, filePath).generatorFile(resultSet);
            logger.error("=================={}==================", "All files were created successfully");
        }
    }

    /**
     * 获取数据库连接器
     *
     * @return
     * @throws Exception
     */
    private static Connection getConnection() throws Exception {
        Class.forName(dbDriver);
        return DriverManager.getConnection(DATA_BASE_URL, DATA_BASE_USER, DATA_BASE_PWD);
    }
}
