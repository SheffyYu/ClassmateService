package main.java.web;

import main.java.bean.ClassmateBean;
import main.java.service.ClassmateService;
import org.springframework.stereotype.Controller;
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
}
