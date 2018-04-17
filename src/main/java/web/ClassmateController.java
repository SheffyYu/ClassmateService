package main.java.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.bean.ClassmateBean;
import main.java.service.BookService;
import main.java.service.ClassmateService;
import main.java.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheffy on 2018/4/9.
 */
@Controller
@RequestMapping(value = "/classmateController")
public class ClassmateController {
    @Resource(name = "classmateService")
    private ClassmateService classmateService;
    @Resource(name = "bookService")
    private BookService bookService;

    //获取姓名和性别的列表
    @RequestMapping(value = "/getItemListByBookId.action")
    public @ResponseBody List<ClassmateBean> getItemListByBookId(String bookId){
        //获取列表
        List<ClassmateBean> classmateList=classmateService.getItemListByBookId(bookId);
        System.out.println("获取目录："+classmateList);
        // 将同学录列表以 json 形式返回到客户端
        return classmateList;
    }

    //添加同学
    @RequestMapping(value = "/createClassmate.action")
    public @ResponseBody ClassmateBean createClassmate(@RequestBody String json){
        // // 获取到 客户端提交的json 文本: spring 直接赋值给String json 参数

        // 转换成 java 对象
        Gson gson=new Gson();
        ClassmateBean o=gson.fromJson(json,ClassmateBean.class);
        System.out.println("begin--create : " + o);

        //调用service保存数据
        ClassmateBean classmateBean=classmateService.createClassmate(o);
        System.out.println("添加成功");

        //更新count
        bookService.setAddItemCount(classmateBean.getBookId());

        return classmateBean;
    }

    //更新同学
    @RequestMapping(value = "updateClassmate.action")
    public @ResponseBody ClassmateBean updateClassmate(@RequestBody String json){
        Gson gson=new Gson();
        List<ClassmateBean> cbl=new ArrayList<ClassmateBean>();
        cbl=gson.fromJson(json,new TypeToken<List<ClassmateBean>>(){}.getType());
        System.out.println("list："+cbl.toString());
        classmateService.updateClassmate(cbl);
        System.out.println("更新成功");
        System.out.println("新："+cbl.get(1));
        return cbl.get(1);
    }

    //删除同学
    @RequestMapping(value = "/deleteClassmate.action")
    public @ResponseBody ClassmateBean deleteClassmate(@RequestBody String json){
        // 获取到 客户端提交的json 文本: spring 直接赋值给String json 参数

        // 转换成 java 对象
        Gson gson=new Gson();
        ClassmateBean o=gson.fromJson(json,ClassmateBean.class);
        System.out.println("begin--delete : " + o);

        //调用service删除数据
        ClassmateBean classmateBean=classmateService.deleteClassmate(o);
        System.out.println("删除成功");

        //更新count
        bookService.setDeleteItemCount(classmateBean.getBookId());

        return classmateBean;
    }

    //获取所有同学
    @RequestMapping(value = "/getAllClassmateByUserId.action")
    public @ResponseBody List<ClassmateBean> getAllClassmateByUserId(String userId){
        //获取列表
        List<ClassmateBean> classmateList=classmateService.getAllClassmateByUserId(userId);
        System.out.println("获取所有同学："+classmateList);
        // 将同学录列表以 json 形式返回到客户端
        return classmateList;
    }
}
