package resourcecommand.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PropsUtil;
import org.osgi.service.component.annotations.Component;
import resourcecommand.constants.ResourceCommandPortletKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.Random;

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
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws IOException {

        try {
            String test1 = PropsUtil.get("test1-key");
            String test2 = PropsUtil.get("test2-key");
            String test3 = PropsUtil.get("test3-key");
            String test4 = PropsUtil.get("test4-key");

            String[] values = {test1, test2, test3, test4};
            String selectedValue = values[new Random().nextInt(values.length)];

            resourceResponse.getWriter().write(selectedValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



