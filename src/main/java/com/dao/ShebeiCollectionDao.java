package com.dao;

import com.entity.ShebeiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeiCollectionView;

/**
 * 设备收藏 Dao 接口
 *
 * @author 
 */
public interface ShebeiCollectionDao extends BaseMapper<ShebeiCollectionEntity> {

   List<ShebeiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
