package main.java.dao;

import main.java.bean.BookBean;
import main.java.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sheffy on 2018/4/5.
 */
@Repository(value = "bookDao")
public interface BookDao {

    //注册时生成默认同学录
    void insertDefaultBook(BookBean bookBean);

    //获取全部同学录列表
    List<BookBean> selectAllBookByUserId(String userId);

    //更新count
    void updateAddItemCount(String bookId);

    //更新删除count
    void updateDeleteItemCount(String bookId);
}
