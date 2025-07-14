package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入员工数据
     * @param employee
     */
    @Insert("insert into employee (name,username,password,phone,sex,status,create_time,update_time,create_user,update_user,id_number) " +
            "values " +
            "(#{name},#{username},#{password},#{phone},#{sex},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser},#{idNumber})")
    void insert(Employee employee);

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    Page<Employee> queryPage(EmployeePageQueryDTO queryDTO);

    void update(Employee employee);

    /**
     * 根据ID获取员工信息
     * @param id
     * @return
     */
    @Select("select * from employee where id =#{id}")
    Employee getById(Integer id);
}
