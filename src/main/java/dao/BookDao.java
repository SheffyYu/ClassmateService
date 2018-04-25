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

    //添加同学录
    void insertBook(BookBean bookBean);

    //获取全部同学录列表
    List<BookBean> selectAllBookByUserId(String userId);

    //删除同学录
    void deleteBook(BookBean bookBean);

    //修改同学录简介
    void updateIntroduce(BookBean bookBean);

    //修改封面
    void updateFace(BookBean bookBean);

    //修改内部背景
    void updatePager(BookBean bookBean);

}
