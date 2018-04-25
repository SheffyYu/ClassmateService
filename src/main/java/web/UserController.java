package main.java.web;

import com.google.gson.Gson;
import main.java.bean.BookBean;
import main.java.bean.UserBean;
import main.java.service.BookService;
import main.java.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 处理与用户相关的逻辑
 * Created by Sheffy on 2018/3/27.
 */
@Controller
@RequestMapping(value = "/userController")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "bookService")
    private BookService bookService;



    @RequestMapping(value = "/getUserByUserId.action")
    public @ResponseBody UserBean getUserByUserId(String userId){
        // 调用 service ,获取用户名和密码
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(userId);
        UserBean user=userService.getUserByUserId(userId);
        System.out.println(user);
        // 将用户类以 json 形式返回到客户端
        return user;
    }

    @RequestMapping(value = "/updatePassword.action")
    public @ResponseBody UserBean updatePassword(@RequestBody String json){
        Gson gson=new Gson();
        UserBean o=gson.fromJson(json,UserBean.class);
        System.out.println("begin--update : " + o);

        UserBean userBean=userService.updatePassword(o);
        System.out.println("修改完成");
        return userBean;
    }

    @RequestMapping(value = "/updateFavicon.action")
    public @ResponseBody UserBean updateFavicon(@RequestBody String json){
        Gson gson=new Gson();
        UserBean o=gson.fromJson(json,UserBean.class);
        System.out.println("begin--update : " + o);

        UserBean userBean=userService.updateFavicon(o);
        System.out.println("修改完成");
        return userBean;
    }


    @RequestMapping(value="/createUser.action")
    public @ResponseBody UserBean createUser(@RequestBody String json){
        // 获取到 客户端提交的json 文本: spring 直接赋值给String json 参数

        // 转换成 java 对象
        Gson gson = new Gson();
        UserBean o = gson.fromJson(json, UserBean.class);
        System.out.println("begin--create : " + o);

        // 调用 Service保存数据
        UserBean userBean = userService.createUser(o);

        //注册时自动生成一个默认的同学录
        BookBean bookBean=new BookBean();
        String bookName="我的同学录";
        bookBean.setBookId(bookName);
        bookBean.setUserId(o.getUserId());
        bookBean.setIntroduce("默认");
        bookBean.setFace(0);
        bookBean.setPager(0);
        //调用BookService保存数据
        bookService.createDefaultBook(bookBean);

        System.out.println("注册完成");
        return userBean;
    }
}
