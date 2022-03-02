package com.example.service;

import com.example.entity.Ebook;
import com.example.req.EbookReq;
import com.example.resp.EbookResp;
import com.github.pagehelper.PageInfo;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 电子书 服务类
 * </p>
 *
 * @author lixun
 * @since 2022-02-23
 */
public interface IEbookService extends IService<Ebook> {
    PageInfo<EbookResp> findAllEbook(EbookReq ebookReq);
}
