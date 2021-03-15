package com.wf.mybatis.demo;

import com.wf.mybatis.mapper.StudentMapper;
import com.wf.mybatis.model.Student;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void mybatisTest() throws IOException {

        String resource = "mybatis/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setName("fafa");
        student.setAge(24);
        student.setSex(0);
        student.setAddress("henan");

        int insert = mapper.insert(student);
        sqlSession.commit();

        System.out.println("插入数据"+insert);

        Student select = mapper.selectByPrimaryKey(1);
        System.out.println(select);

        sqlSession.close();
    }


    @Test
    public void testParseConfiguration() throws IOException {

        String resource = "mybatis/mapper/StudentMapper.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        Configuration configuration = new Configuration();
        XMLMapperBuilder xmlMapperBuilder =
                new XMLMapperBuilder(inputStream,configuration,resource,configuration.getSqlFragments());

        xmlMapperBuilder.parse();
        MappedStatement mappedStatement = configuration.getMappedStatement("com.wf.mybatis.mapper.StudentMapper.selectByPrimaryKey");
        System.out.println(mappedStatement);
    }


}
