package com.jason.web.admin;

import com.jason.po.Type;
import com.jason.service.TypeService;
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
 * @date 7/21/2020 12:05 AM
 */
@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    //根据前端页面封装分页
    @GetMapping("/types")
    public String types(@PageableDefault(size=10, sort = {"id"},direction = Sort.Direction.DESC)
                                    Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    //跳转新增页面
    @GetMapping("types/input")
    public String addInput(Model model){
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }


    //编辑跳转
    @GetMapping("/types/{id}/input")
    public  String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }
    //编辑
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult bindingResult,@PathVariable Long id, RedirectAttributes attributes){
        Type t_name = typeService.getTypeByName(type.getName());
        //是否重复
        if(t_name!=null){
            bindingResult.rejectValue("name", "nameError","名称已存在，不能重复添加");
        }
        //验证结果如果有错误
        if(bindingResult.hasErrors()){
            return "admin/types-input";
        }
        Type t = typeService.updateType(id,type);
        if(t==null){
            //没保存成功
            attributes.addFlashAttribute("message","更新失败！");
        }else{
            attributes.addFlashAttribute("message","更新成功！");
        }
        return "redirect:/admin/types";

    }


    //提交分类
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult bindingResult, RedirectAttributes attributes){
        Type t_name = typeService.getTypeByName(type.getName());
        //是否重复
        if(t_name!=null){
            bindingResult.rejectValue("name", "nameError","名称已存在，不能重复添加");
        }
        //验证结果如果有错误
        if(bindingResult.hasErrors()){
            return "admin/types-input";
        }

        Type t = typeService.saveType(type);
        if(t==null){
            //没保存成功
            attributes.addFlashAttribute("message","新增失败！");
        }else{
            attributes.addFlashAttribute("message","新增成功！");
        }
        return "redirect:/admin/types";
    }


    //删除分类
    @GetMapping("types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功！");
        return "redirect:/admin/types";
    }
}
