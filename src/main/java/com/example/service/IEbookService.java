package com.example.service;

import com.example.entity.Ebook;

import java.util.List;

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
    List<Ebook> findAllEbook(Ebook bEbook);

    Ebook findEbookById(Long id);
}
