package main.java.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.bean.BookBean;
import main.java.bean.ClassmateBean;
import main.java.bean.UserBean;
import main.java.service.BookService;
import main.java.service.ClassmateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理与同学录相关的逻辑
 * Created by Sheffy on 2018/4/5.
 */
@Controller
@RequestMapping(value = "/bookController")
public class BookController {

    @Resource(name = "bookService")
    private BookService bookService;
    @Resource(name = "classmateService")
    private ClassmateService classmateService;

    //添加同学录
    @RequestMapping(value="/createBook.action")
    public @ResponseBody BookBean createBook(@RequestBody String json){

        Gson gson=new Gson();
        BookBean o=gson.fromJson(json,BookBean.class);
        System.out.println("begin--delete : " + o);

        // 调用 Service保存数据
        o.setPager(0);
        o.setFace(0);
       bookService.createBook(o);

        BookBean bookBean =o;
        System.out.println("注册完成");
        return bookBean;
    }

    //删除同学录
    @RequestMapping(value = "/deleteBook.action")
    public @ResponseBody BookBean deleteBook(@RequestBody String json){
        Gson gson=new Gson();
        BookBean book=gson.fromJson(json,BookBean.class);
        System.out.println("begin--delete : " + book);

        //删除classmate
        classmateService.deleteClassmateByBookId(book);
        //删除book
        bookService.deleteBook(book);

        System.out.println("删除成功");
        return book;
    }

    //获取所有同学录
    @RequestMapping(value = "/getAllBookByUserId.action")
    public @ResponseBody List<BookBean> getAllBookByUserId(String userId){
        //调用service获取同学录列表
        List<BookBean> bookBeanList=bookService.getAllBookByUserId(userId);

        System.out.println(bookBeanList);
        // 将同学录列表以 json 形式返回到客户端
        return bookBeanList;
    }

    //修改同学录名称
    @RequestMapping(value = "/updateBookName.action")
    public @ResponseBody BookBean updateBookName(@RequestBody String json){
        Gson gson=new Gson();
        List<BookBean> bbl=new ArrayList<BookBean>();
        bbl=gson.fromJson(json,new TypeToken<List<BookBean>>(){}.getType());
        System.out.println("list："+bbl.toString());
        bookService.updateBookName(bbl);
        System.out.println("更新成功");
        System.out.println("新："+bbl.get(1));
        return bbl.get(1);
    }

    //修改同学录简介
    @RequestMapping(value = "/updateIntroduce.action")
    public @ResponseBody BookBean updateIntroduce(@RequestBody String json){
        Gson gson=new Gson();
        BookBean o=new BookBean();
        o=gson.fromJson(json,BookBean.class);
        bookService.updateIntroduce(o);
        return o;
    }

    //修改同学录封面
    @RequestMapping(value = "/updateFace.action")
    public @ResponseBody BookBean updateFace(@RequestBody String json){
        Gson gson=new Gson();
        BookBean o=new BookBean();
        o=gson.fromJson(json,BookBean.class);
        bookService.updateFace(o);
        return o;
    }

    //修改同学录封面
    @RequestMapping(value = "/updatePager.action")
    public @ResponseBody BookBean updatePager(@RequestBody String json){
        Gson gson=new Gson();
        BookBean o=new BookBean();
        o=gson.fromJson(json,BookBean.class);
        bookService.updatePager(o);
        return o;
    }

}
