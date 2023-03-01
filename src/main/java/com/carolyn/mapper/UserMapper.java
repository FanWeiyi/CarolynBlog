package com.carolyn.mapper;

import com.carolyn.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author Carolyn
 * @since 2023-03-01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
