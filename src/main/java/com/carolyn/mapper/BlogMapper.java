package com.carolyn.mapper;

import com.carolyn.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户博客表 Mapper 接口
 * </p>
 *
 * @author Carolyn
 * @since 2023-03-01
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

}
