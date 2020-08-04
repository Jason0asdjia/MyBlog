package com.jason.dao;

import com.jason.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Jason
 * @date 7/21/2020 1:44 PM
 */
public interface TagRespository extends JpaRepository<Tag, Long> {

    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
