
package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

/**
 * @author by wyl
 * @date 2021/10/16.10点13分
 */

public interface UserMapper {

    /**
     * 通过userName查找user
     */
    User getUserByUserName(@Param("userName") String userName);

    /**
     * 通过UserName和password得到用户
     */
    User getUserByNameAndPwd(@Param("userName") String userName, @Param("password") String password);

    /**
     * 添加用户
     */
    int addUser(User user);
}

