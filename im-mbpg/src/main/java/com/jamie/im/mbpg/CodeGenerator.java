package com.jamie.im.mbpg;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
public class CodeGenerator {

    //全局
    /** 作者 */
    private static String AUTHOR = "jamie";
    private static String PROJECT_PATH = System.getProperty("user.dir");
    private static String OUT_PUT_DIR = "/src/main/java";

    // 数据库
    private static String username = "root";
    private static String password = "123456";
    private static String url = "jdbc:mysql://localhost:3306/im?serverTimezone=GMT%2B8&characterEncoding=UTF-8&allowMultiQueries=true";
    private static DbType DB_TYPE = DbType.MYSQL;
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";

    // 策略
    /** 表名 */
    private static String[] TABLES = {
//            "upms_administrator","upms_administrator_role_relation",
//            "upms_menu","upms_permission","upms_resource","upms_resource_category","upms_role",
//            "upms_role_menu_relation","upms_role_permission_relation",
//            "upms_role_resource_category_relation","upms_role_resource_relation",
            "upms_resource_category_resource_relation"
    };
    /** 生成的实体类忽略表前缀: 不需要则置空 */
    private static String ENTITY_IGNORE_PREFIX = "upms_";

    // 包
    /** 父包名路径(文件输出路径,也是导包的路径) */
    private static String PARENT_PACKAGE_PATH = "com.jamie.im.admin";
    private static String MODULE_NAME = "";
    // 各层包名
    private static String ENTITY_PATH = "domain";
    private static String MAPPER_PATH = "mapper";
    private static String SERVICE_PATH = "service";
    private static String SERVICE_IMPL_PATH = "service.impl";
    private static String CONTROLLER_PATH = "controller";

    //模板
    private static String ENTITY_TEMPLATE = "templates/entity.java";
    /** mapper.java输出模板 */
    private static String MAPPER_TEMPLATE = "templates/mapper.java";
    /** mapper.xml输出模板 */
    private static String XML_TEMPLATE = "templates/mapper.xml";
    /** service输出模板 */
    private static String SERVICE_TEMPLATE = "templates/service.java";
    /** serviceImpl输出模板 */
    private static String SERVICE_IMPL_TEMPLATE = "templates/serviceImpl.java";
    /** controller输出模板 */
    private static String CONTROLLER_TEMPLATE = "templates/controller.java";

    //自定义
    private static String MAPPER_TEMPLATE_PATH = "templates/mapper.xml.ftl";
    private static String MAPPER_OUTPUT_PATH = "/src/main/resources/mapper/";
    private static String MAPPER_SUFFIX = "Mapper";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//               if (StringUtils.isNotEmpty(ipt)) {
//                    return ipt;
//                }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }


    /**
     * 全局配置
     */
    private static GlobalConfig globalConfig() {
        return new GlobalConfig()
                // 打开文件
                .setOpen(false)
                //文件输出位置
                .setOutputDir(PROJECT_PATH+OUT_PUT_DIR)
                // 文件覆盖
                .setFileOverride(true)
                // 开启activeRecord模式
                .setActiveRecord(true)
                // XML ResultMap: mapper.xml生成查询映射结果
                .setBaseResultMap(true)
                // XML ColumnList: mapper.xml生成查询结果列
                .setBaseColumnList(true)
                // swagger注解; 须添加swagger依赖
//                .setSwagger2(true)
                // 作者
                .setAuthor(AUTHOR)
                //设置自增类型
                .setIdType(IdType.ASSIGN_ID);
                // 设置实体类名称
                //.setEntityName("");
    }

    /**
     * 数据源配置
     */
    private static DataSourceConfig dataSourceConfig() {
        return new DataSourceConfig()
                // 数据库类型
                .setDbType(DB_TYPE)
                // 连接驱动
                .setDriverName(driverClassName)
                // 地址
                .setUrl(url)
                // 用户名
                .setUsername(username)
                // 密码
                .setPassword(password);
    }

    /**
     * 策略配置
     */
    private static StrategyConfig strategyConfig() {

        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        TableFill deleted = new TableFill("is_deleted", FieldFill.INSERT);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        tableFills.add(deleted);

        return new StrategyConfig()
                // 表名生成策略：下划线连转驼峰
                .setNaming(NamingStrategy.underline_to_camel)
                // 表字段生成策略：下划线连转驼峰
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 需要生成的表
                .setInclude(TABLES)
                // 生成 REST 风格 controller
                .setRestControllerStyle(true)
                // 去除表前缀
                .setTablePrefix(ENTITY_IGNORE_PREFIX)
                // controller映射地址：驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                // 是否为lombok模型; 需要lombok依赖
                .setEntityLombokModel(true)
                // 生成实体类字段注解
                .setEntityTableFieldAnnotationEnable(true)
                //设置自动填充
                .setTableFillList(tableFills)
                //通用 Beas
//                .setSuperEntityColumns("id","create_time","update_time")
                .setSuperEntityColumns("id")
                .setSuperEntityClass("com.jamie.im.common.base.BaseDomain")
                .setSuperServiceClass("com.jamie.im.common.base.IBaseService")
                .setSuperServiceImplClass("com.jamie.im.common.base.BaseServiceImpl")
                .setSuperControllerClass("com.jamie.im.common.base.BaseController");
    }

    /**
     * 包配置
     */
    private static PackageConfig packageConfig(){
        return new PackageConfig()
            .setParent(PARENT_PACKAGE_PATH)
//            .setModuleName(scanner("模块名"));
            .setModuleName(MODULE_NAME)
            .setEntity(ENTITY_PATH)
            .setMapper(MAPPER_PATH)
            .setService(SERVICE_PATH)
            .setServiceImpl(SERVICE_IMPL_PATH)
            .setController(CONTROLLER_PATH);
    }


    /**
     * 代码生成模板配置
     */
    private static TemplateConfig templateConfig(){
        return new TemplateConfig()
            .setEntity(ENTITY_TEMPLATE)
            .setMapper(MAPPER_TEMPLATE)
            .setService(SERVICE_TEMPLATE)
            .setServiceImpl(SERVICE_IMPL_TEMPLATE)
            .setController(CONTROLLER_TEMPLATE)
            // 置空后方便使用自定义输出位置
            .setXml(null);
    }

    /**
     * 自定义配置
     * @return
     */
    private static InjectionConfig injectionConfig(){

        //自定义输出 mapper.xml 到 resources 目录下
        List<FileOutConfig> fileOutConfig = new ArrayList<>();

        //自定义配置会被优先输出
        fileOutConfig.add(new FileOutConfig(MAPPER_TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输出文件名，如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着变化
                return PROJECT_PATH + MAPPER_OUTPUT_PATH + tableInfo.getEntityName()
                        + MAPPER_SUFFIX + StringPool.DOT_XML;
            }
        });

        return new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        }.setFileOutConfigList(fileOutConfig);

    }

    public CodeGenerator(){
        // 代码生成器
        new AutoGenerator()
                // 全局配置
                .setGlobalConfig(globalConfig())
                // 数据源配置
                .setDataSource(dataSourceConfig())
                // 包配置
                .setPackageInfo(packageConfig())
                // 配置模板 （说明：模板参考mybatis-plus-generator-**.jar templates文件下文件模板）
                // 配置自定义输出模板
                // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
                .setTemplate(templateConfig())
                .setTemplateEngine(new FreemarkerTemplateEngine())
                // 自定义配置
                .setCfg(injectionConfig())
                // 策略配置
                .setStrategy(strategyConfig())
                // 执行
                .execute();
    }

    public static void main(String[] args) {

        // 代码生成器
        new AutoGenerator()
            // 全局配置
            .setGlobalConfig(globalConfig())
           // 数据源配置
            .setDataSource(dataSourceConfig())
            // 包配置
            .setPackageInfo(packageConfig())
            // 配置模板 （说明：模板参考mybatis-plus-generator-**.jar templates文件下文件模板）
            // 配置自定义输出模板
            // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
            .setTemplate(templateConfig())
            .setTemplateEngine(new FreemarkerTemplateEngine())
            // 自定义配置
            .setCfg(injectionConfig())
            // 策略配置
            .setStrategy(strategyConfig())
            // 执行
            .execute();
    }

}
