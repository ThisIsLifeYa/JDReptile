package com.shen.backstage.dao;

import com.shen.backstage.entity.JdModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JdMapper {

    int insert(@Param("JdModels")List<JdModel> JdModels);
}
