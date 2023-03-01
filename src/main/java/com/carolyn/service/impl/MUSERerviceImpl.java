package com.carolyn.service.impl;

import com.carolyn.entity.MUser;
import com.carolyn.mapper.MUserMapper;
import com.carolyn.service.MUSERervice;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Carolyn
 * @since 2023-03-01
 */
@Service
public class MUSERerviceImpl extends ServiceImpl<MUserMapper, MUser> implements MUSERervice {

}
