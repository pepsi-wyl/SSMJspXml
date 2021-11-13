
package service;

import mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;

import javax.annotation.Resource;

/**
 * @author by wyl
 * @date 2021/10/16.17点23分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAspectJAutoProxy

@Service
@Scope("singleton")

//编写事务
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, timeout = 10)
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public User getUserByNameAndPwd(String userName, String password) {
        return userMapper.getUserByNameAndPwd(userName, password);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

}
