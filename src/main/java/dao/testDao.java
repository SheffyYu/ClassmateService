package main.java.dao;

import main.java.bean.testBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sheffy on 2018/3/18.
 */
@Repository(value="testDao")
public interface testDao {
    List<testBean> selectAllTest();
    testBean selectById(String id);
}
