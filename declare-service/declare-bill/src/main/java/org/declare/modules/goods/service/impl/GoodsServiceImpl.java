package org.declare.modules.goods.service.impl;


import org.declare.modules.goods.mapper.GoodsMapper;
import org.declare.modules.goods.service.IGoodsService;
import org.declare.modules.goods.entity.Goods;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 商品展示
 * @Author: jeecg-boot
 * @Date:   2020-07-23
 * @Version: V1.0
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
