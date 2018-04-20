package com.argus.web.mapper;

import com.argus.web.domain.TUser;
import com.argus.web.vo.UserVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by xingding on 18/4/20.
 */
//注意这里没有@Mapper,@Repository等注解,通过applicationContext.xml中配置扫描mapper接口类
public interface UserMapper {
    //配合UserMapper.xml使用
    List<TUser> listUsers(Map params);
    List<UserVo> listUsersSpec(Map params);

    //纯java
    @Select(value = "select * from user")
    List<TUser> selectAllUsers();

}
