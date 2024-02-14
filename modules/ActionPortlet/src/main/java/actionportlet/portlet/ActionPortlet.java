package actionportlet.portlet;

import actionportlet.constants.ActionPortletKeys;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author alexa
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Action",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ActionPortletKeys.ACTION,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class ActionPortlet extends MVCPortlet {
    @ProcessAction(name = "getUserDetails")
    public void getUserDetails(ActionRequest actionRequest, ActionResponse actionResponse) {
        User user = (User) actionRequest.getAttribute(WebKeys.USER);
        List<Role> userRole = user.getRoles();
        List<String> userRoleString = userRole.stream().map(role -> role.getName()).collect(Collectors.toList());
//        String userRoleString = userRole.stream().map(role -> role.getName()).collect(Collectors.joining(","));
//        List<String> userRoleString=  userRole.stream().map(role->role.getName()).toString().split(",");
        actionRequest.setAttribute("userRole", userRoleString);
        System.out.println(userRoleString);
        String redirectUrl = "";
        for (String role : userRoleString) {
            switch (role) {
                case "Administrator":

                    System.out.println("Administrator");
                    break;
                case "back-end Student":
                    redirectUrl = PropsUtil.get("class.backEnd");
                    actionRequest.setAttribute("redirectUrl", redirectUrl);
                    System.out.println("back-end Student");
                    break;
                case "Front-end Student":
                    redirectUrl = PropsUtil.get("class.frontEnd");
                    actionRequest.setAttribute("redirectUrl", redirectUrl);
                    System.out.println("Front-end Student");
                    break;
                default:
                    redirectUrl = "https://www.advancia.it/lavora-con-noi/";
                    actionRequest.setAttribute("redirectUrl", redirectUrl);
                    break;
            }
        }
    }
}