package main.java.service;

import main.java.bean.NotesBean;
import main.java.dao.NotesDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheffy on 2018/5/2.
 */
@Service(value = "notesService")
public class NotesService {
    @Resource(name = "notesDao")
    private NotesDao notesDao;

    public List<NotesBean> getAllNotes(String userId){
        List<NotesBean> notesBeanList=new ArrayList<NotesBean>();
        notesBeanList=notesDao.selectAllNotes(userId);
        System.out.println(notesBeanList);
        return notesBeanList;
    }

    //添加记录
    public void addNotes(NotesBean notesBean){
        notesDao.insertNotes(notesBean);
        System.out.println("记录添加成功");
    }

    //删除记录
    public void deleteNotes(NotesBean notesBean){
        notesDao.deleteNotes(notesBean);
        System.out.println("记录删除成功");
    }
}
