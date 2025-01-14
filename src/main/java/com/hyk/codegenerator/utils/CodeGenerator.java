package com.hyk.codegenerator.utils;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.hyk.codegenerator.entity.TableInfo;
import com.hyk.codegenerator.properties.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @ClassName CodeGenerator
 * @Description 代码生成器
 * @Author 明云根
 * @Date 2025/1/14 下午7:44
 * @Version 1.0
 */
@RestController
public class CodeGenerator {
    @Autowired
    Properties properties;
    @PutMapping("/table")
    public void generator(@RequestParam String tableName) {
        FastAutoGenerator.create(properties.getDataUrl(),properties.getDataUserName(),properties.getDataPassword())
                .globalConfig(builder -> {
//                    作者
                    builder.author("KK")
//                            开启swagger模式
                            .enableSwagger()
//                            指定输出目录
                            .outputDir(System.getProperty("user.dir")+"/src/main/java");
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) ->
                        {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if(typeCode== Types.SMALLINT){
//                                自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
//                    父包名
                    builder.parent("com.hyk.generatorRes")
//                           父包模块名
//                            .moduleName("KK")
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.xml,System.getProperty("user.dir") + "/src/main/resources/mapper"))
                            .entity(tableName+".entity")
                            .mapper(tableName+".mapper")
                            .service(tableName+".service")
                            .serviceImpl(tableName+".service.impl")
                            .controller(tableName+".controller")
                ).strategyConfig(builder ->
                    builder.addInclude(tableName)
//                            .addTablePrefix("t_","c_")
                )
                .templateEngine(new VelocityTemplateEngine())
                .execute();
    }
    @GetMapping("/hello")
    public void testWeb(){
        System.out.println("helloWeb");
    }
}
