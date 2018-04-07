package main.java.web;

import com.google.gson.Gson;
import main.java.bean.BookBean;
import main.java.bean.UserBean;
import main.java.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
/**
 * 为了获取userId，此处要在userservice中调用
    @RequestMapping(value="/createDefaultBook.action")
    public @ResponseBody BookBean createDefaultBook(){

        // 调用 Service保存数据
       bookBean = bookService.createDefaultBook();

        System.out.println("注册完成");
        return bookBean;
    }
*/
    @RequestMapping(value = "/getAllBookByUserId.action")
    public @ResponseBody List<BookBean> getAllBookByUserId(String userId){
        //调用service获取同学录列表
        List<BookBean> bookBeanList=bookService.getAllBookByUserId(userId);

        System.out.println(bookBeanList);
        // 将同学录列表以 json 形式返回到客户端
        return bookBeanList;
    }

}
