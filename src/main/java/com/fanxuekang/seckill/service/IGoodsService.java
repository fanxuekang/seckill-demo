package com.fanxuekang.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fanxuekang.seckill.pojo.Goods;
import com.fanxuekang.seckill.vo.GoodsVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fanxuekang
 * @since 2023-04-20
 */
public interface IGoodsService extends IService<Goods> {

    /**
     * 或许商品列表
     * @return
     */
    List<GoodsVO> findGoodsVO();
}
