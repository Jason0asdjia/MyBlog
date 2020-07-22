package com.jason.dao;

import com.jason.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jason
 * @date 7/21/2020 1:44 PM
 */
public interface TagRespository extends JpaRepository<Tag, Long> {

    Tag findByName(String name);

}
