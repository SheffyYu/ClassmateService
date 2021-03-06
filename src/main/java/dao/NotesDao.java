package main.java.dao;

import main.java.bean.NotesBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sheffy on 2018/5/2.
 */
@Repository(value = "notesDao")
public interface NotesDao {
    //获取全部记录
    List<NotesBean> selectAllNotes(String userId);

    //添加记录
    void insertNotes(NotesBean notesBean);

    //删除记录
    void deleteNotes(NotesBean notesBean);
}
