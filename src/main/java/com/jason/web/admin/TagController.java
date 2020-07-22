package com.jason.web.admin;

import com.jason.po.Tag;
import com.jason.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author Jason
 * @date 7/21/2020 1:40 PM
 */

@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    private TagService tagService;

    //根据前端页面封装分页
    @GetMapping("/tags")
    public String tags(@PageableDefault(size=10, sort = {"id"},direction = Sort.Direction.DESC)
                                Pageable pageable, Model model){
        model.addAttribute("page",tagService.listTag(pageable));
        return "admin/tags";
    }

    //跳转新增页面
    @GetMapping("/tags/input")
    public String addInput(Model model){
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }


    //编辑跳转
    @GetMapping("/tags/{id}/input")
    public  String editInput(@PathVariable Long id, Model model){
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags-input";
    }
    //编辑
    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag, BindingResult bindingResult,@PathVariable Long id, RedirectAttributes attributes){
        Tag t_name = tagService.getTagByName(tag.getName());
        //是否重复
        if(t_name!=null){
            bindingResult.rejectValue("name", "nameError","名称已存在，不能重复添加");
        }
        //验证结果如果有错误
        if(bindingResult.hasErrors()){
            return "admin/tags-input";
        }
        Tag t = tagService.updateTag(id,tag);
        if(t==null){
            //没保存成功
            attributes.addFlashAttribute("message","更新失败！");
        }else{
            attributes.addFlashAttribute("message","更新成功！");
        }
        return "redirect:/admin/tags";

    }


    //提交分类
    @PostMapping("/tags")
    public String post(@Valid Tag tag, BindingResult bindingResult, RedirectAttributes attributes){
        Tag t_name = tagService.getTagByName(tag.getName());
        //是否重复
        if(t_name!=null){
            bindingResult.rejectValue("name", "nameError","名称已存在，不能重复添加");
        }
        //验证结果如果有错误
        if(bindingResult.hasErrors()){
            return "admin/tags-input";
        }

        Tag t = tagService.saveTag(tag);
        if(t==null){
            //没保存成功
            attributes.addFlashAttribute("message","新增失败！");
        }else{
            attributes.addFlashAttribute("message","新增成功！");
        }
        return "redirect:/admin/tags";
    }


    //删除分类
    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功！");
        return "redirect:/admin/tags";
    }
}

