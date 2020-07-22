package com.jason.service;

import com.jason.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 分类的增删改
 * @author Jason
 * @date 7/20/2020 11:52 PM
 */
public interface TypeService {
    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id, Type type);

    void deleteType(Long id);

    Type getTypeByName(String name);

    List<Type> listType();


}

