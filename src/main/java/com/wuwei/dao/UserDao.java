package com.wuwei.dao;

import com.wuwei.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int addUser(User user);

    User findUser(@Param("phone") String phone);

    List<User> findAllUser();
}
