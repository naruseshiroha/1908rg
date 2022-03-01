package com.example.service.impl;

import com.example.entity.Ebook;
import com.example.mapper.EbookMapper;
import com.example.service.IEbookService;

import java.util.List;

// import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
// import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public List<Ebook> findAllEbook(Ebook ebook) {
        return baseMapper.selectList(null);
        // return null;
    }

    @Override
    public Ebook findEbookById(Long id) {
        return baseMapper.selectById(id);
    }

}
