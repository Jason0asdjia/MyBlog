package com.jason.service;

import com.jason.NotFoundException;
import com.jason.dao.TagRespository;
import com.jason.po.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason
 * @date 7/21/2020 1:43 PM
 * Transactional  mysql事务
 */


@Service
@Transactional
public class TagServiceImpl implements TagService{
    @Autowired
    TagRespository tagRespository;

    @Override
    public Tag saveTag(Tag tag) {
        return tagRespository.save(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagRespository.getOne(id);
    }

    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRespository.findAll(pageable);
    }

    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRespository.getOne(id);
        if(t==null){
            throw new NotFoundException("id类型不存在");
        }
//        typeRespository.deleteById(id);
        return tagRespository.save(tag);
    }

    @Override
    public void deleteTag(Long id) {
        tagRespository.deleteById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRespository.findByName(name);
    }

    @Override
    public List<Tag> listTag() {
        return tagRespository.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagRespository.findAllById(convertToList(ids));
    }

    private List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if("".equals(ids) && ids!=null){
            String[] idarray = ids.split(".");
            for(int i=0;i<idarray.length;i++){
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

}
