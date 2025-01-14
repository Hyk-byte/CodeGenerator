package com.hyk.codegenerator.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName TableInfo
 * @Description TODO
 * @Author 明云根
 * @Date 2025/1/14 下午8:52
 * @Version 1.0
 */
@Component
public class TableInfo {
    private String tableName;
    private String authorName;
    private String packageName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
