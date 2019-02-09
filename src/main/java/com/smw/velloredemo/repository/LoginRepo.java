package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.LoginDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
@Repository
public interface LoginRepo extends JpaRepository<LoginDao, Long> {


    @Query("select j from LoginDao j where username=:username")
    Optional<LoginDao> findbyUsername(String username);


    @Query("select j from LoginDao j where mobileno=:mobileno")
    Optional<LoginDao> findbyMobileno(String mobileno);



//    @Query(value = "call getRoles(:roleid)",nativeQuery = true)   // call store procedure with arguments
//    List<Object> findRoles(@Param("role_id")int roleid);

    @Query(value = "{call getRoles(:role)}",nativeQuery = true)   // call store procedure with arguments
    List<String> findRoles(@Param("role")int role);







    @Query("select j from LoginDao j where  userid=:userid")
    Optional<String> findUserid(int userid);
//
//    @Query(value="UPDATE swm.login  SET password=:pass WHERE userid=:id",nativeQuery = true)
//    public void updatePassword(@Param("userid") Integer id, @Param("password") String pass);
//

    @Modifying
    @Query("update LoginDao m set password = ?1 where userid in ?2")
    int updatePassword( String pass,int id);


    @Modifying
    @Query("update LoginDao m set  firebaseid= ?1 where id in ?2")
    void updateFirebaseToken(String firebaseid, Integer id);


    @Query("select j from LoginDao j where firebaseid=:firebaseid")
    List<LoginDao> checkalreadyTokenPresent(String firebaseid);





}