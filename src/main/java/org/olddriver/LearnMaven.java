package org.olddriver;

public class LearnMaven {
    /*
    1.maven介绍
    maven是java项目管理工具，可以用于构建项目，管理依赖，管理项目信息
    maven使用POM构建项目，POM在pom.xml中定义，POM是maven的基本工作单元
    2.项目构建生命周期
    maven将项目构建的生命周期总结为三套，clean，default，site，每个生命周期分为多个阶段，靠后的阶段依赖于靠前的阶段
    ----------------------------------------------------------------------------
    clean生命周期负责清理项目，包含pre-clean，clean，post-clean等阶段
    通过clean命令调用clean生命周期中clean阶段，执行clean阶段前的所有阶段，将target目录删除,清理构建数据
    ----------------------------------------------------------------------------
    default生命周期负责项目部署，包含validate，compile，test，package，verify，install，deploy等重要阶段（不完整）
    通过compile命令调用default生命周期中compile阶段，依次执行compile阶段前的所有阶段，编译主代码，字节码文件输出到target中
    通过test-compile命令调用default生命周期中test-compile阶段，执行test-compile阶段前的所有阶段
    通过test命令调用default生命周期中test阶段，执行test阶段前的所有阶段，编译主代码，测试代码，并运行单元测试，字节码文件输出到target中
    通过package命令调用default生命周期中package阶段，调用将工件打包
    通过install命令调用default生命周期中install阶段，将工件包安装进本地仓库
    ----------------------------------------------------------------------------
    site生命周期负责？？？
    ----------------------------------------------------------------------------
    maven通过插件完成具体构建任务，一个插件可以具有多个功能，每个功能称为一个插件目标
    生命周期阶段与插件目标绑定
    通常不通过命令调用具有连字符的阶段
    3.POM
    POM是maven的基本工作单元，定义在pom.xml中
    父POM
    maven中存在默认父POM，所有POM默认继承父POM
    POM继承
    在子POM中声明其父POM，POM继承目的在于消除重复配置，父POM打包方式必须是pom
    子POM会继承父POM中的依赖列表，
    POM聚合
    在父POM中声明其子模块，对父模块的命令同时也会应用于子模块，父POM打包方式必须是pom
    4.依赖机制
    依赖范围
    存在6种范围，compile，provided，runtime，test，system，import
    compile
    默认值，compile范围依赖在所有类路径中可用
    test
    test范围，依赖仅在编译测试代码，运行测试阶段可用
    provided
    provided范围，期望jdk或容器在运行时提供该依赖，该范围依赖仅在编译主代码，测试代码，运行单元测试时可用，不会包含进工件包
    import
    import范围，在dependencyManagement中导入指定POM的dependencyManagement列表
    依赖管理
    依赖管理用于集中依赖信息
    使用场景之一在父POM中使用dependencyManagement元素定义依赖完整信息，在dependencyManagement中声明的依赖不会引入项目
    在子POM中使用dependencies元素简单引用依赖，通过groupId, artifactId, type, classifier与dependencyManagement中依赖进行匹配
    type默认值为jar，classifier默认值为null
    导入依赖
    由于子POM只能有一个父POM，具有单继承局限性，将所有依赖信息定义在父POM的dependencyManagement中，会导致pom.xml过长
    此时



    project
    pom.xml中根元素
    modelVersion
    定义POM使用的对象模型版本
    groupId
    定义创建项目的组织或组的id
    artifactId
    定义项目生成工件的唯一标识，工件通常是jar文件
    packaging
    定义工件的打包方式
    version
    定义项目生成工件的版本



    4.过滤属性文件
    从pom.xml，settings.xml，自定义属性文件中获取属性值动态生成属性文件
    从pom.xml中获取属性值，需将filtering配置为true
    从自定义属性文件中获取属性值，需将filter配置为属性文件路径
    5.使用依赖项
     */
}
