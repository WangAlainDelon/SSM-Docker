package com.wx.service.imp;

import com.github.pagehelper.PageHelper;
import com.wx.dao.FilmMapper;
import com.wx.domain.Film;
import com.wx.error.MyException;
import com.wx.service.FilmService;
import com.wx.utils.BeanUtil;
import com.wx.utils.PagedResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FilmServiceImp implements FilmService {
    @Resource
    private FilmMapper filmMapper;
    @Override
    public PagedResult<Film> queryByPage(Integer pageNo, Integer pageSize) throws Exception {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return BeanUtil.toPagedResult(filmMapper.select());
    }

    @Override
    public void exception() throws Exception {
        boolean condition=true;
        //当业务条件不满足时抛出异常
        if (condition){
            MyException myException=new MyException("Service层异常");
            throw myException;
        }
    }
}
