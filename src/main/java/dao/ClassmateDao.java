package main.java.dao;

import main.java.bean.ClassmateBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sheffy on 2018/4/9.
 */
@Repository(value = "classmateDao")
public interface ClassmateDao {
    //获取个人数据
    List<ClassmateBean> selectItemListByBookId(String bookId);
}