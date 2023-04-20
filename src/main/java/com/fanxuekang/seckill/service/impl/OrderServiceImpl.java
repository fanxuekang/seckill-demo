package com.fanxuekang.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanxuekang.seckill.mapper.OrderMapper;
import com.fanxuekang.seckill.pojo.Order;
import com.fanxuekang.seckill.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fanxuekang
 * @since 2023-04-20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
