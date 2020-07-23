package org.declare.modules.goods.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.declare.modules.goods.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 商品展示
 * @Author: jeecg-boot
 * @Date:   2020-07-23
 * @Version: V1.0
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}
