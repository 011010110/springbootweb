package org.jiang.dao;

import org.jiang.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author Li.Linhua
 * @description 用户接口
 * @Date 2019/4/27 18:25
 */
public interface UserRepository extends PagingAndSortingRepository<User, Serializable> {
}
