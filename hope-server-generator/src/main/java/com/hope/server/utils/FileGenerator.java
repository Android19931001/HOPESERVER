package com.hope.server.utils;

import com.hope.server.entity.GenEntity;
import freemarker.template.Template;

import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangning
 */
public class FileGenerator {

    private String packageName;

    private String tableName;

    private String filePath;

    private List<GenEntity> entities = new ArrayList<>();


    public static FileGenerator instance(String packageName, String tableName, String filePath) {
        return new FileGenerator(packageName, tableName, filePath);
    }

    public FileGenerator(String packageName, String tableName, String filePath) {
        this.packageName = packageName;
        this.tableName = tableName;
        this.filePath = filePath;
    }

    /**
     * 生成文件
     */
    public void generatorFile(ResultSet resultSet) {
        getEntities(resultSet);
        toEntityFile();
        toJavaMapperFile();
        toServiceFile();
        toServiceImplFile();
        toXmlMapper();
        toControllerFile();
    }

    /**
     * 生成entity文件
     */
    private void toEntityFile() {
        try {
            String chTableName = ChangeUtils.toJavaName(tableName);
            String entityFilePath = filePath + "dto";
            System.out.println("the com.hope.server.entity of java path is === " + entityFilePath);
            Template template = FreeMarkUtils.getTemplate("entity.flt");
            File parentFile = new File(entityFilePath);
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            createFile(template, new File(entityFilePath + "/" + chTableName + ".java"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成mapper.java文件
     */
    private void toJavaMapperFile() {
        try {
            String chTableName = ChangeUtils.toJavaName(tableName);
            String mapperFilePath = filePath + "mapper";
            System.out.println("the mapper of java path is === " + mapperFilePath);
            Template template = FreeMarkUtils.getTemplate("java_mapper.flt");
            File parentFile = new File(mapperFilePath);
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            createFile(template, new File(mapperFilePath + "/" + chTableName + "Mapper.java"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成service文件
     */
    private void toServiceFile() {
        try {
            String chTableName = ChangeUtils.toJavaName(tableName);
            String serviceFilePath = filePath + "service";
            System.out.println("the server of java path is === " + serviceFilePath);
            Template template = FreeMarkUtils.getTemplate("service.flt");
            File parentFile = new File(serviceFilePath);
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            createFile(template, new File(serviceFilePath + "/" + chTableName + "Service.java"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成serviceImpl文件
     */
    private void toServiceImplFile() {
        try {
            String chTableName = ChangeUtils.toJavaName(tableName);
            String serviceImplFilePath = filePath + "service/impl";
            System.out.println("the serviceImpl of java path is === " + serviceImplFilePath);
            Template template = FreeMarkUtils.getTemplate("serviceimpl.flt");
            File parentFile = new File(serviceImplFilePath);
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            createFile(template, new File(serviceImplFilePath + "/" + chTableName + "ServiceImpl.java"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成mapper的xml文件
     */
    private void toXmlMapper() {
        try {
            String chTableName = ChangeUtils.toJavaName(tableName);
            String xmlMapperPath = filePath.substring(0, filePath.indexOf("java")) + "resources/mapper/api/" + ChangeUtils.toFileDirName(tableName);
            System.out.println("the mapper of xml path is === " + xmlMapperPath);
            Template template = FreeMarkUtils.getTemplate("xml_mapper.flt");
            File parentFile = new File(xmlMapperPath);
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            createFile(template, new File(xmlMapperPath + "/" + chTableName + "Mapper.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成controller文件
     */
    private void toControllerFile() {
        try {
            String chTableName = ChangeUtils.toJavaName(tableName);
            String controllerPath = filePath + "web.webservice";
            System.out.println("the server of java path is === " + controllerPath);
            Template template = FreeMarkUtils.getTemplate("server.flt");
            File parentFile = new File(controllerPath);
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            createFile(template, new File(controllerPath + "/" + chTableName + "Resource.java"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成文件(生成文件的公用方法)
     */
    private void createFile(Template template, File file) {
        try {
            Map<String, Object> dataMap = new LinkedHashMap<>();
            dataMap.put("columns", entities);
            dataMap.put("tableName", tableName);
            dataMap.put("packageName", packageName);
            dataMap.put("author", System.getProperty("user.name"));
            dataMap.put("tableChName", ChangeUtils.toJavaName(tableName));
            dataMap.put("tabChFileName", ChangeUtils.toFileDirName(tableName));
            FileOutputStream fos = new FileOutputStream(file);
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
            template.process(dataMap, out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取表中的字段
     *
     * @param resultSet
     * @return
     */
    private void getEntities(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                String columnName = resultSet.getString("COLUMN_NAME");
                String typeCode = resultSet.getString("TYPE_NAME");
                String remark = resultSet.getString("REMARKS");
                entities.add(new GenEntity(columnName, ChangeUtils.toFileDirName(columnName), typeCode, remark));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
