import com.lsm.pojo.Article;
import com.lsm.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationConfig.xml")
public class ArticleTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void saveArticle(){
        Article article = new Article();
        article.setTitle("Mybatis");
        article.setContent("1天学会！！");
        articleService.saveArticle(article);
    }
}
