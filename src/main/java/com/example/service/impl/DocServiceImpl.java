package com.example.service.impl;

import com.example.entity.Content;
import com.example.entity.Doc;
import com.example.mapper.ContentMapper;
import com.example.mapper.DocMapper;
import com.example.service.IDocService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.example.req.DocReq;
import com.example.resp.DocResp;
import com.example.utils.SnowFlake;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import org.springframework.beans.BeanUtils;

/**
 * <p>
 * 文档 服务实现类
 * </p>
 *
 * @author lixunsam
 * @since 2022-03-29
 */
@Service
public class DocServiceImpl extends ServiceImpl<DocMapper, Doc> implements IDocService {

    @Resource
    private ContentMapper contentMapper;

    @Resource
    private SnowFlake snowFlake;

    @Override
    public List<DocResp> all() {
        List<DocResp> docResps = baseMapper.selectList(null).stream().map(doc -> {
            DocResp docResp = new DocResp();
            BeanUtils.copyProperties(doc, docResp);
            return docResp;
        }).collect(Collectors.toList());

        return docResps;
    }

    public List<DocResp> findDoc(DocReq docReq) {
        LambdaQueryWrapper<Doc> lqw = new LambdaQueryWrapper<>();
        lqw.eq(!ObjectUtils.isNull(docReq.getEbookId()), Doc::getEbookId, docReq.getEbookId())
                .eq(!ObjectUtils.isNull(docReq.getParent()), Doc::getParent, docReq.getParent())
                .eq(!StringUtils.isEmpty(docReq.getName()), Doc::getName, docReq.getName())
                .eq(!ObjectUtils.isNull(docReq.getSort()), Doc::getSort, docReq.getSort());

        List<DocResp> docResps = baseMapper.selectList(lqw).stream().map(doc -> {
            DocResp docResp = new DocResp();
            BeanUtils.copyProperties(doc, docResp);
            return docResp;
        }).collect(Collectors.toList());

        return docResps;
    }

    public boolean save(DocResp docResp) {
        boolean flag = false;
        int a = 0, b = 0;
        Doc doc = new Doc();
        Content content = new Content();
        BeanUtils.copyProperties(docResp, doc);
        BeanUtils.copyProperties(docResp, content);
        if (ObjectUtils.isEmpty(docResp.getId())) {
            // 新增
            doc.setId(snowFlake.nextId());
            a = baseMapper.insert(doc);
            content.setId(doc.getId());
            b = contentMapper.insert(content);
            flag = (a > 0 && b > 0) ? true : false;
        } else {
            // 更新
            a = baseMapper.updateById(doc);
            b = contentMapper.updateById(content);
            if (b == 0) {
                contentMapper.insert(content);
            }
            flag = (a > 0 && b > 0) ? true : false;
        }
        return flag;
    }

    public boolean delete(List<String> ids) {
        return baseMapper.deleteBatchIds(ids) > 0;
    }

    public boolean deleteById(Long id) {
        return baseMapper.deleteById(id) > 0;
    }

}
