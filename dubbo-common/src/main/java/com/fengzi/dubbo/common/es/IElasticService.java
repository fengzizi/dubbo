package com.fengzi.dubbo.common.es;


import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/04/02
 */
public interface IElasticService {

    void createIndex();

    void deleteIndex(String index);

    void save(DocBean docBean);

    void saveAll(List<DocBean> list);

    Iterator<DocBean> findAll();

    Page<DocBean> findByContent(String content);

    Page<DocBean> findByFirstCode(String firstCode);

    Page<DocBean> findBySecordCode(String secordCode);

    Page<DocBean> query(String key);
}