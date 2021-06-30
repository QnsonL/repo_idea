import com.lsm.mapper.ArticleMapper;
import com.lsm.pojo.Article;
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

public class ArticleTest {
    private SqlSession sqlSession;
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    @After
    public void after(){
        sqlSession.close();
    }
    @Test
    public void queryAllWithComment(){
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        List<Article> list = mapper.queryAllWithComment();
        for (Article article : list) {
            System.out.println(article);
            System.out.println(article.getCList());
        }
    }
}
