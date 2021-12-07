package org.apache.ibatis.isiyi;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.isiyi.entity.ActorEntity;
import org.apache.ibatis.isiyi.mappers.ActorMapper;
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
            InputStream xml = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            ActorMapper actorMapper = sqlSession.getMapper(ActorMapper.class);
            ActorEntity actorEntity = actorMapper.getById();
            System.out.println(actorEntity);



        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
