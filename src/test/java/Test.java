import com.itheima.domain.Suffer;
import com.itheima.mapper.SufferMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @program: IDEAProject
 * @description:
 * @author: Mr.Laroth
 * @create: 2019-11-18 19:32
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {
    @Autowired
    private SufferMapper sufferMapper;
    @org.junit.Test
    public void test1(){
        List<Suffer> query = sufferMapper.query();
        System.out.println(query);
    }
}
