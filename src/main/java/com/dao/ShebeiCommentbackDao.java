package com.dao;

import com.entity.ShebeiCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeiCommentbackView;

/**
 * 设备评价 Dao 接口
 *
 * @author 
 */
public interface ShebeiCommentbackDao extends BaseMapper<ShebeiCommentbackEntity> {

   List<ShebeiCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
