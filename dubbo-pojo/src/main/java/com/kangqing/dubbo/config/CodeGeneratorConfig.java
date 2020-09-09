package com.kangqing.dubbo.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * mp代码生成配置
 * **********************注意更改下面的数据源配置********************
 * **********************注意生成代码的路径及父包名配置***************
 * @author yunqing
 * @since 2020/5/12 6:30
 */
public class CodeGeneratorConfig {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + "表名，多个英文逗号分割" + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StrUtil.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + "表名，多个英文逗号分割" + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // set freemarker engine
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/dubbo-pojo" + "/src/main/java"); //生成文件的输出目录
        gc.setAuthor("yunqing");
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setActiveRecord(true); //是否支持AR模式
        gc.setFileOverride(true); //文件覆盖
        gc.setIdType(IdType.AUTO); // 主键策略
        gc.setServiceName("%sService"); // 设置Service接口首字母是否为I
        //gc.setBaseResultMap(true);//设置xml中的基本结果集
        //gc.setBaseColumnList(true);//设置基本的查询列sql
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);//数据库类型
        dsc.setUrl("jdbc:mysql://localhost:3306/mall?userSSL=true&useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("5678");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName("模块名");
        pc.setParent("com.kangqing.dubbo");//父包名。// 自定义包路径  如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setEntity("pojo");
        pc.setService("service");
        //pc.setServiceImpl("service.impl");
        //pc.setController("controller");//设置控制器包名
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/dubbo-pojo" + "/src/main/resources/mapper/" + tableInfo.getEntityName()
                        + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建,这里调用默认的方法
                checkDir(filePath);
                //对于已存在的文件，只需重复生成 entity 和 mapper.xml
                File file = new File(filePath);
                //只生成entity和mapper,service
                if (filePath.endsWith("Mapper.xml") || FileType.ENTITY==fileType || FileType.MAPPER==fileType ||
                    FileType.SERVICE == fileType) {
                    //重复生成的时候只覆盖更新entity
                    boolean exist = file.exists();
                    if(exist){
                        return FileType.ENTITY == fileType;
                    }
                    return true;
                }else {
                    return false;
                }
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        //strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        //这句注释掉则生成所有的表
        strategy.setInclude(scanner().split(","));
        //strategy.setInclude("t_user","t_expressman","t_university_info","t_order");
        strategy.setControllerMappingHyphenStyle(true); //驼峰
        strategy.setTablePrefix("mmall_");//识别表前缀
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
