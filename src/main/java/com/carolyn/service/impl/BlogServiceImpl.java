package com.carolyn.service.impl;

import com.carolyn.entity.Blog;
import com.carolyn.mapper.BlogMapper;
import com.carolyn.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户博客表 服务实现类
 * </p>
 *
 * @author Carolyn
 * @since 2023-03-01
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
