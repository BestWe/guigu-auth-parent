package com.atguigu.system;

import com.atguigu.model.system.SysRole;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SysRoleServiceTest {
    @Resource
    private SysRoleService sysRoleService;
    @Test
    public void testSelectList(){
        List<SysRole> list = sysRoleService.list();
        for (SysRole sysRole : list) {
            System.out.println("sysRole = " + sysRole);
        }
    }

    @Test
    public void testUpdateById(){
        SysRole sysRole = new SysRole();
        sysRole.setId("1");
        sysRole.setRoleName("角色管理员1");
        boolean b = sysRoleService.updateById(sysRole);
        System.out.println("b = " + b);
    }

    @Test
    public void testDeleteById(){
        boolean b = sysRoleService.removeById(10L);
        System.out.println("b = " + b);
    }
    @Test
    public void testQueryWrapper(){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("role_code","role");
        List<SysRole> list = sysRoleService.list(queryWrapper);
        System.out.println("list = " + list);
    }

}
