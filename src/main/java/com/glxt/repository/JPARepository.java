package com.glxt.repository;

import com.glxt.model.JPABean;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JPARepository extends JpaRepository<JPABean, Integer> {
    @Cacheable(cacheNames = "findById")
    Optional<JPABean> findById(int id);

    //按用户名字段查询的接口
    List findByUserName(String name);

    //按用户角色字段查询
    List<JPABean> findByUserRole(String Role);

    //使用@query进行复杂查询接口
    @Query("from tbluser where userName = ?1 order by id desc ")
    List<JPABean> listByName(String name);

    //JPA的JpaRepository方式插入数据
    @Modifying
    @Query(value = "insert into tbluser(userName,userPass,userRole) value(?1,?2,?3)", nativeQuery = true)
    public void JPAInsert(String userName, String userPass, String userRole);

    //JPA的JpaRepository方式删除数据
    @Modifying
    @Query(value = "delete from tbluser where userName=?1", nativeQuery = true)
    public void JPADelete(String name);

    //JPA的JpaRepository方式更新修改数据
    @Modifying
    @Query(value = "update tbluser set userName=?1 where userName=?2", nativeQuery = true)
    public void JPAUpdate(String name1, String name);
}

