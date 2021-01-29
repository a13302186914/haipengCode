package com.haipeng.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String name;
    private String phone;
    private String sex;
    @TableField(fill= FieldFill.INSERT)
    private Date createTime;
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updateTime;//修改时间
    @Version
    @TableField(fill= FieldFill.INSERT)
    private Integer version;//版本号

}
