package com.atguigu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * Description: <br/>
 * date: 2023/1/10$ 14:24$<br/>
 *
 * @author: lanjiwei <br/>
 */

@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;

    //表示乐观锁版本号字段
    @Version
    private Integer version;

}
