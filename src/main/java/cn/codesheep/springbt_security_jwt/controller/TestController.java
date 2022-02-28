package cn.codesheep.springbt_security_jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @www.codesheep.cn 20190312
 */
@RestController
public class TestController {

    /**
     * 注意hasAnyAuthority与hasAuthority的区别，前者可以同时配置多个权限角色，后者只能配置一个
     *
     * @return
     */

    // 测试普通权限
    @PreAuthorize("hasAnyAuthority('ROLE_NORMAL','ROLE_ADMIN')")
    @RequestMapping(value = "/normal/test", method = RequestMethod.GET)
    public String test1() {
        return "ROLE_NORMAL /normal/test接口调用成功！";
    }

    // 测试管理员权限
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/admin/test", method = RequestMethod.GET)
    public String test2() {
        return "ROLE_ADMIN /admin/test接口调用成功！";
    }

    // 测试其他
    @PreAuthorize("hasAuthority('ROLE_ELSE')")
    @RequestMapping(value = "/else/test", method = RequestMethod.GET)
    public String test3() {
        return "ROLE_ADMIN /admin/test接口调用成功！";
    }
}
