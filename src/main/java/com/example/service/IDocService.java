package com.example.service;

import com.example.entity.Doc;
import com.example.req.DocReq;
import com.example.resp.DocResp;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文档 服务类
 * </p>
 *
 * @author lixunsam
 * @since 2022-03-29
 */
public interface IDocService extends IService<Doc> {
    List<DocResp> all();

    List<DocResp> findDoc(DocReq docReq);

    boolean save(DocResp docResp);

    boolean deleteById(Long id);

    boolean delete(List<String> ids);
}
