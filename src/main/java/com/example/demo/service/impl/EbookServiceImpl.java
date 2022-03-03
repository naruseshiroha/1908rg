package com.example.demo.service.impl;

import com.example.demo.entity.Ebook;
import com.example.demo.mapper.EbookMapper;
import com.example.demo.service.IEbookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电子书 服务实现类
 * </p>
 *
 * @author lixun
 * @since 2022-03-03
 */
@Service
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook> implements IEbookService {

}
