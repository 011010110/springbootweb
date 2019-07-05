package org.jiang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jiang.domain.MybatisDepartment;

/**
 * @author Li.Linhua
 * @description TODO
 * @Date 2019/4/29 23:35
 */
@Mapper
public interface MybatisDepartmentMapper {

    void insert(MybatisDepartment mybatisDepartment);

    MybatisDepartment get(Integer id);
}
