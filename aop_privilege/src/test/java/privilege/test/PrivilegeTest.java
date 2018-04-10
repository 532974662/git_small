package privilege.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import privilege.aspect.PrivilegeAspect;
import privilege.service.FirmService;
import privilege.userprivilege.FirmPrivilege;

/**
 * aop+注解权限控制测试类
 *
 * @author Minhellic
 *
 */
public class PrivilegeTest {
    /**
     * 客户端直接调用这个Service的方法，而不需要关心权限问题
     */
    private FirmService firmService;

    /**
     * 在初始化方法中，初始化firmService
     * 同时为用户赋上原始权限，这个在项目中，会使用别的方式实现，这里只是模拟，就不搞那么复杂了
     */
    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        firmService = (FirmService) context.getBean("firmService");

        /*
         * 给用户添加默认权限
         */
        PrivilegeAspect privilegeAspect = (PrivilegeAspect) context.getBean("privilegeAspect");
        List<FirmPrivilege> privileges = new ArrayList<FirmPrivilege>();
        privileges.add(new FirmPrivilege("save"));
        privileges.add(new FirmPrivilege("update"));
        privilegeAspect.setPrivileges(privileges);
    }

    /**
     * 客户端直接调用Service中的方法，而不需要关心权限问题，会有切面去做
     */
    @Test
    public void test() {
        firmService.save();
        firmService.update();
        firmService.get();
    }
}