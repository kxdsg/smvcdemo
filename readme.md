### Spring 3.x

##### 版本号 3.2.10.RELEASE

##### 表现层 JSP
##### 数据库 MySQL


#### 整合Mybatis

+ pom引入依赖
```
<dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.3.0</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.2.3</version>
        </dependency>
```
+ 创建Mybatis全局配置文件 mybatis-config.xml
    - setting （常用设置）
    - typeAliases （引入Mapper接口类包名）
    - mappers (引入业务mapper.xml文件)
    
+ spring配置文件applicationContext.xml配置mybatis
    - 配置Mybatis的SqlSessionFactoryBean
    ```
        <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
            <!--配置mybatis全局文件-->
            <property name="configLocation" value="classpath:mybatis-config.xml"/>
            <property name="dataSource" ref="dataSource"/>
        </bean>
    ```
    - 配置扫描Mapper接口包
    ```
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
            <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
            <property name="basePackage" value="com.argus.web.mapper"/>
        </bean>
    ```





