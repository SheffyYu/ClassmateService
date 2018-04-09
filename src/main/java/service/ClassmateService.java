package main.java.service;

import main.java.bean.ClassmateBean;
import main.java.dao.ClassmateDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by Sheffy on 2018/4/9.
 */
@Service(value = "classmateService")
public class ClassmateService {
    @Resource(name = "classmateDao")
    private ClassmateDao classmateDao;

    //获取姓名和性别列表
    public List<ClassmateBean> getItemListByBookId(String bookId){
        return classmateDao.selectItemListByBookId(bookId);
    }
}
