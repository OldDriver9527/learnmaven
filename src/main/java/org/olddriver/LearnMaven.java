package org.olddriver;

public class LearnMaven {
    /*
    1.maven介绍
    maven是java项目管理工具，可以用于构建项目，管理依赖，管理项目信息
    POM是maven的基本工作单元，maven使用POM构建项目，POM在pom.xml中定义
    2.项目构建生命周期
    maven将项目构建总结为三套独立生命周期，clean，default，site，每个生命周期分为多个阶段，靠后的阶段依赖于靠前的阶段
    ----------------------------------------------------------------------------
    clean生命周期负责清理项目，包含pre-clean，clean，post-clean等阶段
    通过clean命令调用clean生命周期中clean阶段，执行clean阶段前的所有阶段，将target目录删除,清理构建数据
    ----------------------------------------------------------------------------
    default生命周期负责项目部署，包含validate，compile，test，package，verify，install，deploy等重要阶段（不完整）
    通过compile命令调用default生命周期中compile阶段，依次执行compile阶段前的所有阶段，编译主代码，字节码文件输出到target中
    通过test-compile命令调用default生命周期中test-compile阶段，执行test-compile阶段前的所有阶段
    通过test命令调用default生命周期中test阶段，执行test阶段前的所有阶段，编译主代码，测试代码，并运行单元测试，字节码文件输出到target中
    通过package命令调用default生命周期中package阶段，将构件打包
    通过install命令调用default生命周期中install阶段，将构件包安装进本地仓库
    ----------------------------------------------------------------------------
    site生命周期负责？？？
    ----------------------------------------------------------------------------
    maven通过插件完成具体构建任务，一个插件可以具有多个功能，每个功能称为一个插件目标
    生命周期阶段与插件目标绑定
    通常不通过命令调用具有连字符的阶段
    3.POM
    POM指项目对象模型，是maven的基本工作单元，定义在pom.xml中
    父POM
    maven中存在默认父POM，所有POM默认继承父POM
    POM继承
    在子POM中声明其父POM，子POM会继承父POM的部分配置，如依赖列表
    POM继承目的在于消除重复配置，父POM打包方式必须是pom
    POM聚合
    在父POM中声明作为其模块的子POM，对父POM的命令同时也会应用于子POM，父POM打包方式必须是pom
    4.依赖机制
    maven坐标
    maven通过坐标定位构件，maven坐标由groupId，artifactId，version，packaging，classifier构成
    ----------------------------------------------------------------------------
    使用外部依赖
    dependencies元素中声明所有外部依赖，外部依赖至少指明groupId，artifactId，version，scope，
    还可以定义type，optional，exclusions
    type指明依赖类型，默认值为jar
    optional标记依赖是否可选？？？
    exclusions用于排除传递性依赖
    maven优先在本地仓库寻找依赖，若本地仓库中不存在，maven从远程仓库下载依赖存储在本地仓库中
    ----------------------------------------------------------------------------
    依赖范围
    maven在编译，测试，运行项目时使用三套独立的classpath，依赖范围用于控制依赖与三套classpath的关系
    存在6种依赖范围，compile，provided，runtime，test，system，import
    compile
    compile范围依赖在所有classpath中均可用，默认值
    provided
    provided范围依赖仅在编译，测试classpath中可用,该范围依赖期望jdk或容器在运行时提供
    test
    test范围依赖仅在测试classpath中可用
    runtime
    runtime范围依赖在测试，运行classpath中可用
    system
    system范围依赖在编译，测试classpath中可用
    import
    import范围依赖不对三种classpath产生影响
    ----------------------------------------------------------------------------
    传递依赖
    当POM中引入一个依赖，maven会解析依赖POM，将POM中包含的必要依赖也引入到当前POM中
    传递依赖的范围由第一直接依赖范围，第二直接依赖范围决定
    第二直接依赖范围    compile       test      provided    runtime
    第一直接依赖范围
    compile            compile      不传递     不传递       runtime
    test               test         不传递     不传递       test
    provided           provided     不传递     provided    provided
    runtime            runtime      不传递     不传递       runtime
    ----------------------------------------------------------------------------
    可选依赖
    optional元素定义是否为可选依赖，可选依赖仅在所在POM中有效，不会作为传递依赖进行传递
    排除依赖
    exclusions元素用于排除指定依赖中的依赖，不作为传递依赖引入
    ----------------------------------------------------------------------------
    依赖管理
    依赖管理用于集中依赖信息
    使用场景之一在父POM中使用dependencyManagement元素定义依赖完整信息（在dependencyManagement中声明的依赖不会引入项目）
    在子POM中使用dependencies元素简单引用依赖，通过groupId, artifactId, type, classifier与dependencyManagement中依赖进行匹配
    type默认值为jar，classifier默认值为null
    导入依赖
    由于子POM只能有一个父POM，具有单继承局限性，将所有依赖信息定义在父POM的dependencyManagement中，会导致pom.xml过长
    可以在dependencyManagement中使用import范围依赖，将指定POM中的dependencyManagement配置导入并合并到当前POM中
    ----------------------------------------------------------------------------
    BOM bill of materials
    BOM是特殊的POM，专门用于被其他POM导入dependencyManagement配置
    5.maven仓库
    maven仓库分为本地仓库，远程仓库
    远程仓库分为中央仓库，私服，其他公共库
    中央仓库指maven核心远程仓库
    6.pom.xml
    <project>
    pom.xml中根元素
    <project><modelVersion>
    定义POM使用的对象模型版本
    <project><groupId>
    定义创建项目的组织或组的id
    <project><artifactId>
    定义项目生成构件的唯一标识，构件通常是jar文件
    <project><packaging>
    定义构件的打包方式
    <project><version>
    定义项目生成构件的版本
    <project><name>
    定义项目名称
    <project><properties>
    定义maven属性，在POM中任意位置通过${propertyName}获取属性值

    过滤属性文件
    从pom.xml，settings.xml，自定义属性文件中获取属性值动态生成属性文件
    从pom.xml中获取属性值，需将filtering配置为true
    从自定义属性文件中获取属性值，需将filter配置为属性文件路径
     */
}
