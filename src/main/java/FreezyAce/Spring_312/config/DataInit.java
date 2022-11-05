package FreezyAce.Spring_312.config;

import FreezyAce.Spring_312.model.User;
import FreezyAce.Spring_312.service.RoleService;
import FreezyAce.Spring_312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@ConditionalOnExpression("${freezy.init:true}")
@Component
public class DataInit {

    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public DataInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUser() {
        userService.save(new User("admin", 23, "admin", "admin", "admin", Set.copyOf(roleService.getAllRole())));
    }
}
