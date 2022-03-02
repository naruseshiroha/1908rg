package com.example.service.impl;

import com.example.entity.Ebook;
import com.example.mapper.EbookMapper;
import com.example.req.EbookReq;
import com.example.resp.EbookResp;
import com.example.service.IEbookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电子书 服务实现类
 * </p>
 *
 * @author lixun
 * @since 2022-02-23
 */
@Service
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook> implements IEbookService {

    @Override
    public PageInfo<EbookResp> findAllEbook(EbookReq ebookReq) {
        PageHelper.startPage(ebookReq.getPageNum(), ebookReq.getPageSize());
        // Page<Ebook> page = new Page<>(ebookReq.getPageNum(), ebookReq.getPageSize());
        LambdaQueryWrapper<Ebook> lqw = new LambdaQueryWrapper<>();
        lqw.like(!StringUtils.isEmpty(ebookReq.getName()), Ebook::getName,
                ebookReq.getName())
                .like(!StringUtils.isEmpty(ebookReq.getDescription()), Ebook::getDescription,
                        ebookReq.getDescription());

        List<EbookResp> ebookResps = baseMapper.selectList(lqw).stream().map(ebook -> {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook, ebookResp);
            return ebookResp;
        }).collect(Collectors.toList());

        PageInfo<EbookResp> pageInfo = new PageInfo<>(ebookResps);

        return pageInfo;
    }

}
