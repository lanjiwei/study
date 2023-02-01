package com.atguigu.mybatisplus.vo;

import com.atguigu.mybatisplus.dto.UserDTO;
import com.atguigu.mybatisplus.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description: <br/>
 * date: 2023/1/13$ 8:34$<br/>
 *
 * @author: lanjiwei <br/>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends User {
    private static final long serialVersionUID = 1L;


}
