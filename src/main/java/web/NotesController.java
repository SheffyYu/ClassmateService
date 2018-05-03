package main.java.web;

import com.google.gson.Gson;
import main.java.bean.NotesBean;
import main.java.service.NotesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    //添加记录
    @RequestMapping(value = "/addNotes.action")
    public @ResponseBody NotesBean addNotes(@RequestBody String json){
        Gson gson=new Gson();
        NotesBean n=gson.fromJson(json,NotesBean.class);
        System.out.println("create:"+n);
        notesService.addNotes(n);
        System.out.println("添加成功呢");
        return n;
    }

    //删除记录
    @RequestMapping(value = "/deleteNotes.action")
    public @ResponseBody NotesBean deleteNotes(@RequestBody String json){
        Gson gson=new Gson();
        NotesBean nb=gson.fromJson(json,NotesBean.class);
        System.out.println("delete:"+nb);
        notesService.deleteNotes(nb);
        System.out.print("删除成功");
        return nb;
    }
}
