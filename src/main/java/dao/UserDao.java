package main.java.dao;

import main.java.bean.UserBean;
import org.springframework.stereotype.Repository;

/**
 * Created by Sheffy on 2018/3/27.
 */
@Repository(value="userDao")
public interface UserDao {
    //根据用户ID获取相应的用户名和密码
    UserBean selectByUserId(String userId);

    //添加用户
    void insertUser(UserBean userBean);

    //修改密码
    void updatePassword(UserBean userBean);

    //修改头像
    void updateFavicon(UserBean userBean);
}
