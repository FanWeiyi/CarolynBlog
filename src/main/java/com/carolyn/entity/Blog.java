package com.carolyn.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 用户博客表
 * </p>
 *
 * @author Carolyn
 * @since 2023-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @NotBlank(message = "用户不能为空")
    private Long userId;
    @NotBlank(message = "标题不能为空")
    private String title;
    @NotBlank(message = "描述不能为空")
    private String description;

    private String content;

    private LocalDateTime created;

    private Integer status;


}
