package com.fanxuekang.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanxuekang.seckill.mapper.GoodsMapper;
import com.fanxuekang.seckill.pojo.Goods;
import com.fanxuekang.seckill.service.IGoodsService;
import com.fanxuekang.seckill.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fanxuekang
 * @since 2023-04-20
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    /**
     * 获取商品列表
     * @return
     */
    @Override
    public List<GoodsVO> findGoodsVO() {


        return goodsMapper.findGoodsVO();
    }


}
