
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.User;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author by wyl
 * @date 2021/10/15.20点53分
 */

@Controller
@RequestMapping(value = "/user")

public class UserController {

    @Resource(name = "userServiceImpl")
    private UserService userService;

    /**
     * 跳转到注册界面
     */
    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }

    /**
     * 跳转到登陆界面
     */
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    /**
     * ajax验证用户名是否存在
     */
//    @RequestMapping(value = "/userIsExist", method = RequestMethod.POST)
//    @ResponseBody
//    public String userIsExist(String userName) {
//        if (userService.getUserByUserName(userName) != null) {
//            return "true";        //存在
//        } else {
//            return "false";       //不存在
//        }
//    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, String userName, String password, String vcode) {
        if (request.getSession().getAttribute("loginCpacha").toString().toUpperCase(Locale.ROOT).equals(vcode.trim().toUpperCase())) {
            //验证码正确
            User user = userService.getUserByNameAndPwd(userName.trim(), password.trim());
            if (user != null) {
                //用户密码正确
                request.getSession().setAttribute("user", user);      //用户信息存入Session
                return "redirect:/book/allBook";    //跳转页面
            } else {
                //用户名密码不正确
                request.setAttribute("error", "name错误或者password错误");
                return "login";
            }
        } else {
            //验证码不正确
            request.setAttribute("error", "验证码错误!");
            return "login";
        }
    }

    /**
     * 注册用户
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String userName, String password) {
        if ("".equals(userName) || "".equals(password))
            return "register";
        userService.addUser(new User(1, userName, password));
        return "login";
    }


}

