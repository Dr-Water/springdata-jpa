package com.ratel.jpa;

import com.ratel.jpa.dao.UserDao;
import com.ratel.jpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserDao userDao;

    //springjpa的简单使用
    @Test
    public void findAll(){
        List<User> list = userDao.findAll();
        list.forEach(System.out::println);
    }

    /**
     * 根据主键id获取一个对象
     */
    @Test
    public void findOne(){
        System.out.println(userDao.findOne("1"));
    }

    /**
     * 自定义的
     */
    @Test
    public void findById(){
        System.out.println(userDao.findById("1"));
    }

    /**
     *新增一个对象
     */
    @Test
    public void save(){
        //User user = userDao.save(new User( "zhangsan", "2222", "123@qq.com"));
        User user = userDao.save(new User( "1002","zhangsan", "333", "123@qq.com"));
        System.out.println(user);
    }

    /**
     * 删除
     */
    @Test
    public void delete(){
        userDao.delete("1");
    }


    /**
     *测试原生查询
     */
    @Test
    public void nativeQueryTest(){
        ArrayList<String> idList = new ArrayList<>();
        idList.add("1");
        idList.add("2");
        List<User> all = userDao.findAllByIdList(idList);
        all.forEach(System.out::println);
    }

    /**
     *测试jpa的独有的查询
     */
    @Test
    public void jpaTest(){
        ArrayList<String> idList = new ArrayList<>();
        idList.add("3");
        idList.add("4");
        List<User> all = userDao.findByIdList(idList);
        all.forEach(System.out::println);
    }













    @Test
    public void t3(){
        Map<String, Object> paramMap = new HashMap();
        ArrayList<Object> list = new ArrayList<>();
        list.add(Long.valueOf(4));
        list.add(Long.valueOf(5));
        paramMap.put("id", list);
        // List<User> users = userDao.query("select obj from Goods obj where obj.gc.id in(:id)", paramMap, -1, -1);
        // System.out.println(users);
    }
    @Test
    public void t4(){
        ArrayList<String> idList = new ArrayList<>();
        idList.add("1");
        idList.add("2");
        List<User> all = userDao.findAllByIdInAndIdEquals(idList,"1");
        System.out.println(all);
        System.out.println("hahaha");

    }

    @Test
    public void t5(){
        ArrayList<String> idList = new ArrayList<>();
        idList.add("1");
        idList.add("2");
        Specification<User> sepc = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!CollectionUtils.isEmpty(idList)) {
                Predicate status = root.get("id").in(idList);
                predicates.add(status);

            }
            predicates.add(cb.equal(root.get("email"),"lisi@163.com"));
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };

        List<User> all = userDao.findAll(sepc);
        System.out.println(all);
    }

    @Test
    public void testSpec() {
        //匿名内部类
        /**
         * 自定义查询条件
         *      1.实现Specification接口（提供泛型：查询的对象类型）
         *      2.实现toPredicate方法（构造查询条件）
         *      3.需要借助方法参数中的两个参数（
         *          root：获取需要查询的对象属性
         *          CriteriaBuilder：构造查询条件的，内部封装了很多的查询条件（模糊匹配，精准匹配）
         *       ）
         *  案例：根据客户名称查询，查询客户名
         *          查询条件
         *              1.查询方式
         *                  cb对象
         *              2.比较的属性名称
         *                  root对象
         *
         */
        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //1.获取比较的属性
                Path<Object> id = root.get("id");//查询的式属性名，不是表的字段名
                //2.构造查询条件  ：    select * from cst_customer where cust_id = 3
                /**
                 * 第一个参数：需要比较的属性（path对象）
                 * 第二个参数：当前需要比较的取值
                 */
                Predicate predicate = cb.equal(id, 3);//进行精准的匹配  （比较的属性，比较的属性的取值）
                return predicate;
            }
        };
        User user = userDao.findOne(spec);
        System.out.println(user);
    }

}
