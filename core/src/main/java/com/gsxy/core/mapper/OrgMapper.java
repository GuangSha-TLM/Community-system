package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Org;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrgMapper {

    public Long addOrg(Org org);

    public Long deleteByIdOrg(Long id);

    public Org selectByIdOrg(Long id);

    public Long updateByIdOrg(Org org);




}
