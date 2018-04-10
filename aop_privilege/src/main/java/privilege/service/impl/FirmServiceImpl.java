package privilege.service.impl;

import privilege.annotation.PrivilegeInfo;
import privilege.service.FirmService;

/**
 * 用户业务实现
 * @author Minhellic
 *
 */
public class FirmServiceImpl implements FirmService {

    /**
     * 在需要权限的目标方法上，使用PrivilegeInfo注解，配置权限
     */
    @Override
    @PrivilegeInfo("save")
    public void save() {
        System.out.println("FirmServiceImpl.save()");

    }

    /**
     * 在需要权限的目标方法上，使用PrivilegeInfo注解，配置权限
     */
    @Override
    @PrivilegeInfo("update")
    public void update() {
        System.out.println("FirmServiceImpl.update()");

    }

    /**
     * 不需要权限的目标方法上，则不添加PrivilegeInfo注解
     * 在切面中，默认用户拥有权限
     */
    @Override
    public void get() {
        System.out.println("FirmServiceImpl.get()");

    }
}