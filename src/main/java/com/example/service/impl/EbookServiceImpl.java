package com.example.service.impl;

import com.example.entity.Ebook;
import com.example.mapper.EbookMapper;
import com.example.req.EbookReq;
import com.example.resp.EbookResp;
import com.example.service.IEbookService;

import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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
    public List<EbookResp> findAllEbook(EbookReq ebookReq) {
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

        return ebookResps;
    }

    public boolean save(EbookResp ebookResp) {
        Ebook ebook = new Ebook();
        boolean flag = false;
        BeanUtils.copyProperties(ebookResp, ebook);
        if (ObjectUtils.isEmpty(ebookResp.getId())) {
            // 新增
            flag = baseMapper.insert(ebook) > 0 ? true : false;
        } else {
            // 更新
            flag = baseMapper.updateById(ebook) > 0 ? true : false;
        }
        return flag;
    }

    public boolean deleteById(Long id) {
        return baseMapper.deleteById(id) > 0;
    }

}
