package main.java.service;

import main.java.bean.testBean;
import main.java.dao.testDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sheffy on 2018/3/18.
 */
@Service(value="testService")
public class testService {
    @Resource(name="testDao")
    private testDao testDaos;
    public List<testBean> listTest(){
        // 调用 Dao,查询数据库
        return testDaos.selectAllTest();
    }
    public testDao getTestDaos() {
        return testDaos;
    }

    public void setTestDaos(testDao testDaos) {
        this.testDaos = testDaos;
    }



}
