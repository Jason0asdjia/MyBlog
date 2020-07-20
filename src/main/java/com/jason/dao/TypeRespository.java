package com.jason.dao;

import com.jason.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jason
 * @date 7/20/2020 11:56 PM
 */
public interface TypeRespository extends JpaRepository<Type,Long> {
    Type findByName(String name);
}
