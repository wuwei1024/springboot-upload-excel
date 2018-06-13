package com.wuwei.controller;

import com.wuwei.entity.Result;
import com.wuwei.entity.User;
import com.wuwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result addUser(User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/downloadExcelTemplate")
    public Result downloadExcelTemplate(HttpServletResponse response) {
        return userService.downloadExcelTemplate(response);
    }

    @RequestMapping("/import")
    public Result importExcel(@RequestParam(value = "filename") MultipartFile file) {
        return userService.importExcel(file);
    }

    @RequestMapping("/export")
    public Result exportExcel(HttpServletResponse response) {
        return userService.exportExcel(response);
    }
}