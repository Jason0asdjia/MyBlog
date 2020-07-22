package com.jason.dao;

import com.jason.po.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Jason
 * @date 7/22/2020 8:04 PM
 */
public interface BlogRespository  extends JpaRepository<Blog, Long> , JpaSpecificationExecutor <Blog>{
}
