package cn.ch.service;

import java.util.List;

/**
 * 通用的Service层接口
 *
 * @author ch
 * @date 2021/5/13
 */
public interface BaseService<T> {

    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll();

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 添加
     *
     * @param t
     */
    void create(T t);

    /**
     * 删除（批量）
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 修改
     *
     * @param t
     */
    void update(T t);
}