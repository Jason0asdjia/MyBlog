package com.jason.service;

import com.jason.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Jason
 * @date 7/21/2020 1:42 PM
 */
public interface TagService {
    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id, Tag tag);

    void deleteTag(Long id);

    Tag getTagByName(String name);

    List<Tag> listTag();
    List<Tag> listTag(String ids);
}