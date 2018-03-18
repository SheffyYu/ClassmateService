package main.java.web;

import main.java.bean.testBean;
import main.java.service.testService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sheffy on 2018/3/18.
 */
@Controller
@RequestMapping(value="/testController")
public class testController {
    @Resource(name="testService")
    private testService testService;


    @RequestMapping(value="/showTest.action")
    public @ResponseBody
    List<testBean> showTest(){
        // 调用 service ,获取商品列表
        List<testBean> testList = testService.listTest();

        System.out.println(testList);
        //TODO  将商品列表以 json 形式返回到客户端
        return testList;
    }


    public testService getTestService() {
        return testService;
    }


    public void setTestService(testService goodsService) {
        this.testService = goodsService;
    }

}

