package resourcecommand.portlet;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import resourcecommand.constants.ResourceCommandPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
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
                "javax.portlet.display-name=ResourceCommand",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ResourceCommandPortletKeys.RESOURCECOMMAND,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class ResourceCommandPortlet extends MVCPortlet {


    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
        User user = (User) resourceRequest.getAttribute(WebKeys.USER);
        List<Role> userRole = user.getRoles();
        List<String> userRoleName = userRole.stream().map(role -> role.getName()).collect(Collectors.toList());
        String redirectUrl = "";
        for (String role : userRoleName) {
            switch (role) {
                case "Administrator":

                    break;
                case "back-end Student":
                    redirectUrl = PropsUtil.get("class.backEnd");
                    resourceRequest.setAttribute("redirectUrl", redirectUrl);
                    break;
                case "Front-end Student":
                    redirectUrl = PropsUtil.get("class.frontEnd");
                    resourceRequest.setAttribute("redirectUrl", redirectUrl);
                    break;
                case "Coordinatore":

                    break;
                default:
                    break;
            }
        }
        super.serveResource(resourceRequest, resourceResponse);
    }
}