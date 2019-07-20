package com.wx.controller;

import com.wx.domain.Film;
import com.wx.service.FilmService;
import com.wx.utils.PagedResult;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class IndexController {

    @Autowired
    private FilmService filmService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "index";
    }

    /**
     * 分页从查询电影的数据
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping("/page")
    @ResponseBody
    public String page(Integer pageNumber, Integer pageSize) {
        try {
            PagedResult<Film> pageResult = filmService.queryByPage(pageNumber, pageSize);
            JSONObject jsonObj = null;
            if (pageResult != null) {
                JsonConfig jsonConfig = new JsonConfig();
                jsonObj = JSONObject.fromObject(pageResult, jsonConfig);
                jsonObj.element("isError", false);
                jsonObj.element("errorMsg", "");
            }
            return jsonObj.toString();
        } catch (Exception e) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("isError", true);
            jsonObj.put("errorMsg", e.getMessage());
            return jsonObj.toString();
        }
    }
}
