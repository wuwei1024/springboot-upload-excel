package com.wuwei.service.impl;

import com.wuwei.dao.UserDao;
import com.wuwei.entity.Result;
import com.wuwei.entity.User;
import com.wuwei.service.UserService;
import com.wuwei.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @Override
    public Result addUser(User user) {
        if (user == null || StringUtils.isEmpty(user.getPhone()))
            return Result.getFailedResult("参数不能为空!");
        try {
            userDao.addUser(user);
            return Result.getSuccessResult("添加成功!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return Result.getFailedResult("添加失败!");
        }
    }

    /**
     * 下载空白的Excel模板文件
     *
     * @param response
     * @return
     */
    @Override
    public Result downloadExcelTemplate(HttpServletResponse response) {
        try {
            ExcelUtil.exportExcel(User.class, "用户表.xls", response);
            return Result.getFailedResult("下载成功!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return Result.getFailedResult("下载失败!");
        }
    }

    /**
     * 导入用户
     *
     * @param file
     */
    @Override
    public Result importExcel(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            return Result.getFailedResult("上传文件格式不正确！");
        }
        try {
            List<User> users = ExcelUtil.getUserList(file);
            //todo 优化，直接传递集合到数据库
            for (User user : users) {
                User user0 = userDao.findUser(user.getPhone());
                if (user0 == null) {
                    userDao.addUser(user);
                }
            }
            return Result.getSuccessResult("导入成功!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return Result.getFailedResult("导入失败!");
        }
    }

    /**
     * 导出用户
     *
     * @param response
     */
    @Override
    public Result exportExcel(HttpServletResponse response) {
        try {
            List<User> users = userDao.findAllUser();
            ExcelUtil.exportExcel(users, User.class, "用户.xls", response);
            //ExcelUtil.exportExcel(users, "用户表明细", "用户表", User.class, "用户表.xls", response);
            return Result.getFailedResult("导出成功!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return Result.getFailedResult("导出失败!");
        }
    }
}
