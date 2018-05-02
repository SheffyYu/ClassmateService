package main.java.web;

import main.java.bean.NotesBean;
import main.java.service.NotesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheffy on 2018/5/2.
 */
@Controller
@RequestMapping(value = "/notesController")
public class NotesController {
    @Resource(name = "notesService")
    private NotesService notesService;

    //获取所有记录
    @RequestMapping(value = "/getAllNotes.action")
    public @ResponseBody List<NotesBean> getAllNotes(String userId){
        System.out.println(userId);
        List<NotesBean> notesBeanList=new ArrayList<NotesBean>();
        notesBeanList=notesService.getAllNotes(userId);
        System.out.println(notesBeanList);
        return notesBeanList;
    }
}
