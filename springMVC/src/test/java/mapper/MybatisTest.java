package mapper;

import com.lsm.mapper.DeptMapper;
import com.lsm.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private SqlSession sqlSession;

    @Before
    public void before(){
        String resource = "Mybatis.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void DeptMapperFindAllDeptTest(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> allDept = mapper.findAllDept();
        for (Dept dept : allDept) {
            System.out.println(dept);
            System.out.println(dept.getEmpList());
        }
    }
}
