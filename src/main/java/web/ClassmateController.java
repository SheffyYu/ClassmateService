package main.java.web;

import com.google.gson.Gson;
import main.java.bean.ClassmateBean;
import main.java.service.ClassmateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sheffy on 2018/4/9.
 */
@Controller
@RequestMapping(value = "/classmateController")
public class ClassmateController {
    @Resource(name = "classmateService")
    private ClassmateService classmateService;

    //获取姓名和性别的列表
    @RequestMapping(value = "/getItemListByBookId.action")
    public @ResponseBody List<ClassmateBean> getItemListByBookId(String bookId){
        //获取列表
        List<ClassmateBean> classmateList=classmateService.getItemListByBookId(bookId);
        System.out.println(classmateList);
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
        return classmateBean;
    }
}
