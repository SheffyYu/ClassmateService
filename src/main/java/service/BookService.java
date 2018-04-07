package main.java.service;

import main.java.bean.BookBean;
import main.java.bean.UserBean;
import main.java.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sheffy on 2018/4/5.
 */
@Service(value = "bookService")
public class BookService {

    @Resource(name="bookDao")
    private BookDao bookDao;

    //创建默认同学录
    public void createDefaultBook(BookBean bookBean){
        bookDao.insertDefaultBook(bookBean);
        System.out.println("添加默认同学录完成！");
        System.out.println(bookBean.toString());
    }

    //获取全部同学录
    public List<BookBean> getAllBookByUserId(String userId){
        return bookDao.selectAllBookByUserId(userId);
    }

}
