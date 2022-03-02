package com.example.controller;

import java.util.List;

import javax.annotation.Resource;

import com.example.entity.Ebook;
import com.example.req.EbookReq;
import com.example.resp.EbookResp;
import com.example.service.IEbookService;
import com.example.utils.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

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
    public JsonResult<PageInfo<EbookResp>> findAllEbook(EbookReq ebookReq) {
        JsonResult<PageInfo<EbookResp>> json = new JsonResult<>(200, "查询成功");
        // List<EbookResp> ebookResps = 
        PageInfo<EbookResp> pageInfo = ebookService.findAllEbook(ebookReq);
        json.setData(pageInfo);
        return json;

    }

}
