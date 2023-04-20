package com.fanxuekang.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanxuekang.seckill.pojo.Goods;
import com.fanxuekang.seckill.vo.GoodsVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fanxuekang
 * @since 2023-04-20
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 获取商品列表
     * @return
     */
    public List<GoodsVO> findGoodsVO();
}
