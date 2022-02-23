package com.example.controller;

import java.util.List;

import javax.annotation.Resource;

import com.example.entity.Ebook;
import com.example.service.IEbookService;

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
    public List<Ebook> findAllEbook(Ebook ebook) {
        return ebookService.findAllEbook(ebook);
    }

    @GetMapping("/findEbook")
    public Ebook findEbookById(Long id) {
        // Ebook ebook = ebookService.findEbookById(id);
        return ebookService.findEbookById(id);
    }

}
