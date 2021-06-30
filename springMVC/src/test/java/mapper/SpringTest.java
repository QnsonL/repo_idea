package mapper;

import com.lsm.mapper.DeptMapper;
import com.lsm.pojo.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationConfig.xml")
public class SpringTest {
    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void DeptMapperFindAllDeptTest(){
        List<Dept> allDept = deptMapper.findAllDept();
        for (Dept dept : allDept) {
            System.out.println(dept);
            dept.getEmpList();
            System.out.println(dept);
        }
    }
}
