package main.java.service;

/**
 * Created by Sheffy on 2018/3/27.
 */

import main.java.bean.UserBean;
import main.java.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserService {
    @Resource(name="userDao")
    private UserDao userDao;


    public UserBean getUserByUserId(String userId){
        UserBean userBean=userDao.selectByUserId(userId);
        System.out.println(userBean);
        return userBean;
    }

    public UserBean createUser(UserBean userBean){
       userDao.insertUser(userBean);
       System.out.println(userBean.toString());

       System.out.println("注册成功");
       return userBean;
   }

   //修改密码
    public UserBean updatePassword(UserBean userBean){
        userDao.updatePassword(userBean);
        System.out.println(userBean.toString());
        System.out.println("修改成功");
        return userBean;
    }

    //修改头像
    public UserBean updateFavicon(UserBean userBean){
        userDao.updateFavicon(userBean);
        System.out.println(userBean.toString());
        System.out.println("修改成功");
        return userBean;
    }
}
