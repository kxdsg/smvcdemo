package com.argus.web.main;

import com.argus.web.domain.TUser;
import com.argus.web.mapper.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionUtils;

import java.util.List;

/**
 * Created by xingding on 18/4/20.
 */
/*
脱离Spring容器进行mybatis测试
 */
public class MybatisTest {
    public static final String driverName = "com.mysql.jdbc.Driver";
    public static final String url="jdbc:mysql://localhost:3306/test";
    public static final String username = "root";
    public static final String password = "admin123";

    private SqlSessionFactory init(){
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setUrl(url);
        dataSource.setDriver(driverName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("test", transactionFactory, dataSource);
        //类似mybatis-config.xml
        Configuration configuration = new Configuration(environment);
        //开启驼峰转换
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.getTypeAliasRegistry().registerAlias("TUser", TUser.class);//注册别名
        configuration.addMapper(UserMapper.class);//添加mapper
        return new DefaultSqlSessionFactory(configuration);
    }

    public static void main(String[] args) {
        MybatisTest main = new MybatisTest();
        SqlSessionFactory sqlSessionFactory = main.init();
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtils.getSqlSession(sqlSessionFactory);
            //返回的应该是一个由jdk动态代理生成的代理类，底层代码：return Proxy.newProxyInstance(this.mapperInterface.getClassLoader(), new Class[]{this.mapperInterface}, mapperProxy);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //这里UserMapper是接口，没有实现类，为什么能直接把数据查询出来呢？
            //原因是因为 它采用了：Java动态代理实现接口
            List<TUser> userList = userMapper.selectAllUsers();
            for(TUser user: userList){
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlSessionUtils.closeSqlSession(sqlSession,sqlSessionFactory);
        }
    }

}
