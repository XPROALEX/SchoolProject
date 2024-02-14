package memberlist.portlet;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import memberlist.constants.MemberListPortletKeys;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
                "javax.portlet.display-name=MemberList",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + MemberListPortletKeys.MEMBERLIST,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class MemberListPortlet extends MVCPortlet {
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        String userName = user.getScreenName();
        List<Role> roles = user.getRoles();
        List<UserGroup> grouplist2 = user.getUserGroups();
        renderRequest.setAttribute("grouplist2", grouplist2);
        List<UserGroup> userGroups = UserGroupLocalServiceUtil.getUserUserGroups(user.getUserId());
        boolean isAdmin = roles.stream().anyMatch(role -> role.getName().equals("Administrator"));

        renderRequest.setAttribute("groups", userGroups);
//        int totalUsersOnSite = UserLocalServiceUtil.getUsersCount();
        if (isAdmin) {
            List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
            renderRequest.setAttribute("users", users);
        }


//        String totalUsersOnSiteString = String.valueOf(totalUsersOnSite);
//        renderRequest.setAttribute("totalUsersOnSiteString", totalUsersOnSiteString);

        String userRoles = roles.stream().map(role -> role.getName()).collect(Collectors.joining(", "));
        renderRequest.setAttribute("userRoles", userRoles);
        renderRequest.setAttribute("userName", userName);
        super.doView(renderRequest, renderResponse);
    }
}