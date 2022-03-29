package com.example.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.example.req.DocReq;
import com.example.resp.DocResp;
import com.example.service.IDocService;
import com.example.utils.JsonResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 文档 前端控制器
 * </p>
 *
 * @author lixunsam
 * @since 2022-03-29
 */
@RestController
@RequestMapping("/doc")
public class DocController {
    @Resource
    private IDocService docService;

    @GetMapping("/all")
    public JsonResult<List<DocResp>> all() {
        JsonResult<List<DocResp>> json = new JsonResult<>();
        // json.setData(PageHelper.startPage(docReq.getPageNum(),docReq.getPageSize())
        // .doSelectPageInfo(() -> docService.findAllDoc(docReq)));
        json.setData(docService.all());
        json.setCode(200);
        json.setMsg("操作成功");
        return json;
    }

    @GetMapping("/findDoc")
    public JsonResult<List<DocResp>> findDoc(@Valid DocReq docReq) {
        JsonResult<List<DocResp>> json = new JsonResult<>();
        // json.setData(PageHelper.startPage(docReq.getPageNum(),docReq.getPageSize())
        // .doSelectPageInfo(() -> docService.findAllDoc(docReq)));
        json.setData(docService.findDoc(docReq));
        json.setCode(200);
        json.setMsg("操作成功");
        return json;
    }

    @PostMapping("/save")
    public JsonResult<Boolean> save(@RequestBody DocResp docResp) {
        JsonResult<Boolean> json = new JsonResult<>();
        json.setData(docService.save(docResp));
        json.setCode(200);
        json.setMsg("操作成功");
        return json;
    }

    // @DeleteMapping("/delete/{id}")
    // public JsonResult<Boolean> delete(@PathVariable Long id) {
    //     JsonResult<Boolean> json = new JsonResult<>();
    //     json.setData(docService.deleteById(id));
    //     json.setCode(200);
    //     json.setMsg("操作成功");
    //     return json;
    // }

    @DeleteMapping("/delete/{idsStr}")
    public JsonResult<Boolean> delete(@PathVariable String idsStr) {
        // List<String> ids = Stream.of(idsStr).collect(Collectors.toList());
        List<String> ids = Arrays.asList(idsStr.split(","));
        JsonResult<Boolean> json = new JsonResult<>();
        json.setData(docService.delete(ids));
        json.setCode(200);
        json.setMsg("操作成功");
        return json;
    }

}
