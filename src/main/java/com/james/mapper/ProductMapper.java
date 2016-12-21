/*
 * Copyright (c) Hewlett Packard Enterprise Company, L.P. Limited 2016.
 * 
 */
package com.james.mapper;

import java.util.List;

import com.james.model.Product;
import com.james.page.PagingBounds;

public interface ProductMapper {

//    int countByExample(productEntityExample example);
//
//    int deleteByExample(productEntityExample example);
//
//    int insert(productEntity record);
//
//    int insertSelective(productEntity record);
//
//    List<productEntity> selectByExample(productEntityExample example);
//
//    int updateByExampleSelective(@Param("record") productEntity record, @Param("example") productEntityExample example);
//
//    int updateByExample(@Param("record") productEntity record, @Param("example") productEntityExample example);

    /**
     * 检索商品信息一览
     *
     * @return 商品信息一览
     */
    public List<Product> selectProductList(PagingBounds<Product> page);

}
