package com.dao;

import com.entity.ShebeiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeiOrderView;

/**
 * 设备订单 Dao 接口
 *
 * @author 
 */
public interface ShebeiOrderDao extends BaseMapper<ShebeiOrderEntity> {

   List<ShebeiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
