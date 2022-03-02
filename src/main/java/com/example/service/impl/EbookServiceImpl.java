package com.example.service.impl;

import com.example.entity.Ebook;
import com.example.mapper.EbookMapper;
import com.example.req.EbookReq;
import com.example.resp.EbookResp;
import com.example.service.IEbookService;
import com.github.pagehelper.PageInfo;

import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
// import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.mybatis.logging.LoggerFactory;
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

    @Resource
    EbookMapper ebookMapper;

    @Override
    public List<EbookResp> findAllEbook(EbookReq ebookReq) {
        LambdaQueryWrapper<Ebook> lqw = new LambdaQueryWrapper<>();

        lqw.like(!StringUtils.isEmpty(ebookReq.getName()), Ebook::getName,
                ebookReq.getName())
                .like(!StringUtils.isEmpty(ebookReq.getDescription()), Ebook::getDescription,
                        ebookReq.getDescription());

        // baseMapper.selectList(null);
        Logger log = LoggerFactory.getLogger("log");
        ebookMapper.selectList(lqw).stream().map(ebook -> {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook, ebookResp);
            System.out.println(ebookResp);
            return ebookResp;
        });

        return null;
        // return baseMapper.selectList(null);
    }

    // @Override
    // public PageInfo<EbookResp> findAllEbook(EbookReq ebookReq) {
    // LambdaQueryWrapper<Ebook> lqw = new LambdaQueryWrapper<>();

    // lqw.like(!StringUtils.isEmpty(ebookReq.getName()), Ebook::getName,
    // ebookReq.getName())
    // .like(!StringUtils.isEmpty(ebookReq.getDescription()), Ebook::getDescription,
    // ebookReq.getDescription());

    // // PageInfo<News> newsPageInfo = new PageInfo<>(listNews);
    // return null;
    // // return baseMapper.selectList(lqw);
    // // return null;
    // }

}
