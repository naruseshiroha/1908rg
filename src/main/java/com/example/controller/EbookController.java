package com.example.controller;

import java.util.List;

import javax.annotation.Resource;

import com.example.entity.Ebook;
import com.example.service.IEbookService;
import com.example.utils.JsonResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 电子书 前端控制器
 * </p>
 *
 * @author lixun
 * @since 2022-02-23
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private IEbookService ebookService;

    @GetMapping("/findAllEbook")
    public JsonResult<List<Ebook>> findAllEbook(Ebook ebook) {
        JsonResult<List<Ebook>> json = new JsonResult<>(200, "查询成功");
        json.setData(ebookService.findAllEbook(ebook));
        // Ebook ebook = ebookService.findEbookById(id);
        return json;
    }

}
