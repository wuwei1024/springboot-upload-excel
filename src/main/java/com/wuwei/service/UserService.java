package com.wuwei.service;

import com.wuwei.entity.Result;
import com.wuwei.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    Result addUser(User user);

    Result downloadExcelTemplate(HttpServletResponse response);

    Result importExcel(MultipartFile file);

    Result exportExcel(HttpServletResponse response);
}
