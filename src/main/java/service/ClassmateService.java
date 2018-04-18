package main.java.service;

import main.java.bean.BookBean;
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
    public List<ClassmateBean> getItemListByBookId(BookBean bookBean){
        return classmateDao.selectItemListByBookId(bookBean);
    }

    //添加同学
    public ClassmateBean createClassmate(ClassmateBean classmateBean){
        System.out.println("!!!!!!!");
        classmateDao.insertClassmate(classmateBean);
        System.out.println(classmateBean.toString());
        System.out.println("添加成功");
        return classmateBean;
    }

    //更新同学
    public void updateClassmate(List<ClassmateBean> cblist){
        classmateDao.deleteClassmate(cblist.get(0));
        classmateDao.insertClassmate(cblist.get(1));
    }

    //删除同学
    public ClassmateBean deleteClassmate(ClassmateBean classmateBean){
        classmateDao.deleteClassmate(classmateBean);
        System.out.println(classmateBean.toString());
        System.out.println("删除成功");
        return classmateBean;
    }

    //删除同学
    public void deleteClassmateByBookId(BookBean bookBean){
        classmateDao.deleteClassmateByBookId(bookBean);
        System.out.println("删除成功");
    }

    //获取所有同学
    public List<ClassmateBean> getAllClassmateByUserId(String userId){
        return classmateDao.selectAllClassmateByUserId(userId);
    }
}
