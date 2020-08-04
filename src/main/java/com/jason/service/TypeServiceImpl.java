package com.jason.service;

import com.jason.NotFoundException;
import com.jason.dao.TypeRespository;
import com.jason.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Jason
 * @date 7/20/2020 11:55 PM
 */

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRespository typeRespository;


    @Override
    public Type saveType(Type type) {
        return typeRespository.save(type);
    }

    @Override
    public Type getType(Long id) {
        return typeRespository.getOne(id);
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRespository.findAll(pageable);
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort.Order sort=new Sort.Order(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0,size,Sort.by(sort));
        return typeRespository.findTop(pageable);
    }

    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRespository.getOne(id);
        if(t==null){
            throw new NotFoundException("id类型不存在");
        }
//        typeRespository.deleteById(id);
        BeanUtils.copyProperties(type, t);
        return typeRespository.save(t);
    }

    @Override
    public void deleteType(Long id) {
        typeRespository.deleteById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRespository.findByName(name);
    }

    @Override
    public List<Type> listType() {
        return typeRespository.findAll();
    }
}
