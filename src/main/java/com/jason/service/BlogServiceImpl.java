package com.jason.service;

import com.jason.NotFoundException;
import com.jason.dao.BlogRespository;
import com.jason.po.Blog;
import com.jason.po.Type;
import com.jason.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jason
 * @date 7/22/2020 8:03 PM
 */

@Service
public class BlogServiceImpl implements  BlogService{
    @Autowired
    private BlogRespository blogRespository;


    @Override
    public Blog getBlog(Long id) {
        return blogRespository.getOne(id);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogRespository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                //查询标题
                if(!"".equals(blog.getTitle()) && blog.getTitle()!=null){
                    predicates.add(criteriaBuilder.like(root.<String>get("title"), "%"+ blog.getTitle()+"%"));
                }
                //查询分类
                if(blog.getTypeId() !=null){
                    predicates.add(criteriaBuilder.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
                }
                //是否推荐
                if(blog.isRecommend()){
                    predicates.add(criteriaBuilder.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }
                criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    @Override
    @Transactional
    public Blog saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        return blogRespository.save(blog);
    }

    @Override
    @Transactional
    public Blog updateBlog(Long id, Blog blog) {
        Blog b = blogRespository.getOne(id);
        if(b==null){
            throw new NotFoundException("该博客不存在！");
        }
        BeanUtils.copyProperties(blog, b);
        return blogRespository.save(b);
    }

    @Override
    @Transactional
    public void deleteBlog(Long id) {
        blogRespository.deleteById(id);
    }
}
