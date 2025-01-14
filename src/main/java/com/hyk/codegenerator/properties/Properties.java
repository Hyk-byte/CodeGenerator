package com.hyk.codegenerator.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName Properties
 * @Description TODO
 * @Author 明云根
 * @Date 2025/1/14 下午8:34
 * @Version 1.0
 */
@Component
public class Properties {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${spring.datasource.username}")
    private String dataUserName;
    @Value("${spring.datasource.password}")
    private String dataPassword;
    @Value("${spring.datasource.url}")
    private String dataUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String dataDriverClassName;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getDataUserName() {
        return dataUserName;
    }

    public void setDataUserName(String dataUserName) {
        this.dataUserName = dataUserName;
    }

    public String getDataPassword() {
        return dataPassword;
    }

    public void setDataPassword(String dataPassword) {
        this.dataPassword = dataPassword;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }


    public String getDataDriverClassName() {
        return dataDriverClassName;
    }

    public void setDataDriverClassName(String dataDriverClassName) {
        this.dataDriverClassName = dataDriverClassName;
    }
}
