package org.apache.ibatis.isiyi;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.isiyi.entity.ActorEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

/**
 * mybatis 测试类
 * <p></p>
 *
 * @version 1.0.0
 * @description: MybatisTest
 * @author: 向鹏飞
 * @since: 2021/12/6
 */
public class MybatisTest {


    @Test
    public void testMybatisWithXml(){
        try {
            // 根据 mybatis.xml 配置的信息得到 sqlSessionFactory
            String resource = "mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 然后根据 sqlSessionFactory 得到 session
            SqlSession session = sqlSessionFactory.openSession();
            // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
            ActorEntity listActor = session.selectOne("getById");

            System.out.println(listActor);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
