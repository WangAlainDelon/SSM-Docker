package com.wx.service;

import com.wx.domain.Film;
import com.wx.utils.PagedResult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FilmService {
    PagedResult<Film> queryByPage(Integer pageNo, Integer pageSize) throws Exception;

    void exception() throws Exception;
}
