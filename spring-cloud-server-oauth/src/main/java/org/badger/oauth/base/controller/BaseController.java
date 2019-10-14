package org.badger.oauth.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * 基础控制器
 *
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/3/20 15:06
 * @copyright www.ucarinc.com All Rights Reserved.
 */
public abstract class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 获取request
     *
     * @return javax.servlet.http.HttpServletRequest
     */
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取session
     *
     * @return javax.servlet.http.HttpSession
     */
    protected HttpSession getSession() {
        return this.getRequest().getSession();
    }

    /**
     * 设置session值
     *
     * @param key   会话key
     * @param value 会话值
     * @return void
     */
    protected void setSessionAttribute(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 获取session值
     *
     * @param key 会话key
     * @return java.lang.Object
     */
    protected Object getSessionAttribute(String key) {
        return getSession().getAttribute(key);
    }

    /**
     * 获取web项目根路径
     *
     * @return
     */
    protected String getWebRoot() {
        HttpServletRequest request = getRequest();
        // 得到协议如：http
        String scheme = request.getScheme();
        // 得到服务器名称如：127.0.0.1
        String serverName = request.getServerName();
        // 得到端口号如8080
        String serverPort = request.getServerPort() == 80 ? "" : (":" + request.getServerPort());
        // 得到当前上下文路径，也就是安装后的文件夹位置。
        String contextPath = "/".equals(request.getContextPath()) ? "" : request.getContextPath();
        // 连起来拼成完整的url
        return scheme + "://" + serverName + serverPort + contextPath + "/";
    }

    /**
     * 获取本机IP
     *
     * @return
     */
    protected String getLocalhostIp() {
        String ip = null;
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                List<InterfaceAddress> interfaceAddress = netInterface.getInterfaceAddresses();
                for (InterfaceAddress add : interfaceAddress) {
                    InetAddress inetAddress = add.getAddress();
                    if (inetAddress != null && inetAddress instanceof Inet4Address) {
                        ip = inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            LOGGER.error("获取IP异常", e);
        }
        return ip;
    }

}
