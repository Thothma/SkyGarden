package com.baomidou.mybatisplus.samples.crud;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.samples.crud.entity.User;
import com.baomidou.mybatisplus.samples.crud.mapper.UserMapper;
/**
 * <p>
 * 内置 CRUD 演示
 * </p>
 *
 * @author hubin
 * @since 2018-08-11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    private static final Logger logger = LoggerFactory.getLogger(SampleTest.class);


    @Resource
    private UserMapper mapper;

    @Test
    public void aInsert() {
        User user = new User();

            user.setName("小猫");
            user.setAge(1);
            user.setEmail("abc@mp.com");
            user.insert();
    }


    @Test
    public void bDelete() {
        assertThat(mapper.deleteById(3L)).isGreaterThan(0);
        assertThat(mapper.delete(new QueryWrapper<User>()
                .lambda().eq(User::getName, "Sandy"))).isGreaterThan(0);
    }


    @Test
    public void cUpdate() {
        assertThat(mapper.updateById(new User().setId(1L).setEmail("ab@c.c"))).isGreaterThan(0);
        assertThat(mapper.update(new User().setName("mp"),
                Wrappers.<User>lambdaUpdate()
                        .set(User::getAge, 3)
                        .eq(User::getId, 2))).isGreaterThan(0);
    }


    @Test
    public void dSelect() {
        assertThat(mapper.selectById(1L).getEmail()).isEqualTo("ab@c.c");
        User user = mapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getId, 2));
        assertThat(user.getName()).isEqualTo("mp");
        assertThat(user.getAge()).isEqualTo(3);
    }

    @Test
    public void orderBy() {
        List<User> users = mapper.selectList(Wrappers.<User>query().orderByAsc("age"));
        assertThat(users).isNotEmpty();
    }

    @Test
    public void selectMaps() {
        List<Map<String, Object>> mapList = mapper.selectMaps(Wrappers.<User>query().orderByAsc("age"));
        assertThat(mapList).isNotEmpty();
        assertThat(mapList.get(0)).isNotEmpty();
        System.out.println(mapList.get(0));
    }

    @Test
    public void selectMapsPage() {
        IPage<Map<String, Object>> page = mapper.selectMapsPage(new Page<>(1, 5), Wrappers.<User>query().orderByAsc("age"));
        assertThat(page).isNotNull();
        assertThat(page.getRecords()).isNotEmpty();
        assertThat(page.getRecords().get(0)).isNotEmpty();
        System.out.println(page.getRecords().get(0));
    }

    @Test
    public void orderByLambda() {
        List<User> users = mapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getId,"1").or().eq(User::getId,"2").orderByAsc(User::getAge,User::getName).groupBy(User::getEmail));
        assertThat(users).isNotEmpty();
    }

    @Test
    public void test(){
        try{
            Set<Object> set=new HashSet<>();
            logger.info("empty set {}", CollectionUtils.isEmpty(set));
            for(Object s:set){
                System.out.println(1);
            }
        }catch (Exception e){
            logger.info("occur error",e);
        }

    }
}
