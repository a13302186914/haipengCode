package com.haipeng;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haipeng.mapper.UserMapper;
import com.haipeng.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    //添加
    public void addUser(){
        User user = new User();
        user.setName("地瓜");
        user.setPhone("12312312312");
        user.setSex("男");

        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
    @Test
    //修改
    public void update(){
        User user = new User();
        user.setId(1351428138504056834L);
        user.setPhone("12345678922");
        int i = userMapper.updateById(user);
        System.out.println(i);

    }
    @Test
    //修改，乐观锁
    public void updateleguansuo(){
        User user = userMapper.selectById(1351428138504056834L);
        user.setPhone("123");
        int i = userMapper.updateById(user);
        System.out.println(i
        );
    }

    @Test
    //批量查询
    public void selectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(3, 4, 5, 6, 7));
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    //分页
    public void selectPage(){
        //传入两个参数：当前页 和 每页展示几条
        Page<User> page = new Page<>(2,3);
        userMapper.selectPage(page, null);
        long current = page.getCurrent();
//        System.out.println("当前页"+current);
        List<User> records = page.getRecords();
        for (User record : records) {
            System.out.println("当前页:"+current+"数据有"+record);
        }


    }
    @Test
    public void test2(){
        int i=1;
        int j=++i;
        System.out.println(i);
        System.out.println(j);


    }
}
