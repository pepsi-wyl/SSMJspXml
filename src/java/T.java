
import org.junit.jupiter.api.Test;
import pojo.User;
import service.UserService;
import utils.SpringUtils;

/**
 * @author by wyl
 * @date 2021/10/9.11点02分
 */
public class T {

    @Test
    public void t() {
        UserService userService = SpringUtils.getApplicationContext().getBean("userServiceImpl", UserService.class);
        User userByNameAndPwd = userService.getUserByNameAndPwd("zhazha", "888888");
        System.out.println(userByNameAndPwd);
        userService.addUser(new User(1,"zhazha","888888"));
    }

}
