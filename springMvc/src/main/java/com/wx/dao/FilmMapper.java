package com.wx.dao;

import com.wx.domain.Film;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FilmMapper  {
    List<Film> select() throws Exception;
}
