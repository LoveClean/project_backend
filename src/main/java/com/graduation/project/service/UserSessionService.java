package com.graduation.project.service;

import com.graduation.project.dao.entity.Admin;
import com.graduation.project.vo.AdminVO;

import javax.servlet.http.HttpServletRequest;


/**
 * @Title: UserService.java
 * @Package cc.uworks.library.service
 * @author liyuchang
 * @Description: 用户缓存，具体实现可以是session或memcached中
 * @date 2017年1月23日
 * @version V1.0
 */
public interface UserSessionService {

  /**
   * 缓存用户信息，JSON格式
   *
   * @param request
   * @param user
   */
  void sessionUser(HttpServletRequest request, AdminVO admin);

  /**
   * 获取缓存用户，不为空，重新设置缓存中用户的过期时间
   *
   * @param request
   * @return
   */
  AdminVO getSessionUser(HttpServletRequest request);

  /**
   * 根据accessToken获取缓存用户
   * 
   * @param accessToken
   * @return
   */
  AdminVO getSessionUser(String accessToken);

  /**
   * 删除缓存中得用户信息
   *
   * @param request
   */
  void deleteSessionUser(HttpServletRequest request);

  /**
   * 生成登录权限token
   *
   * @param request
   * @return
   */
  String generateAccessToken(HttpServletRequest request);

  /**
   * 返回登录用户，未登录返回null
   * 
   * @param request
   * @return
   */
  AdminVO getLoginUser(HttpServletRequest request);
  
  /**
   * 获取真实ip
   * 
   * @param request
   * @return
   */
  public String getRemoteIP(HttpServletRequest request);

}
