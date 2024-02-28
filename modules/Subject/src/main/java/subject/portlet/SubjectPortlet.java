package subject.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import esami.model.Course;
import esami.service.CourseLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import subject.constants.SubjectPortletKeys;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;

/**
 * @author alexa
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Subject",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + SubjectPortletKeys.SUBJECT,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class SubjectPortlet extends MVCPortlet {
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        List<Course> coursesList = CourseLocalServiceUtil.getCourses(-1,-1);
        renderRequest.setAttribute("coursesList", coursesList);

        int courseCount = CourseLocalServiceUtil.getCoursesCount();
        renderRequest.setAttribute("courseCount", courseCount);

        super.doView(renderRequest, renderResponse);
    }

    @ProcessAction(name = "addSubjectOfStudy")
    public void addSubjectOfStudy(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            long courseCount = CourseLocalServiceUtil.getCoursesCount();
            Course course = CourseLocalServiceUtil.createCourse(courseCount + 1);

            String subjectOfStudy = ParamUtil.getString(actionRequest, "subjectOfStudy");
            course.setCourseName(subjectOfStudy);

            CourseLocalServiceUtil.addCourse(course);
            System.out.println("subjectOfStudyId: " + course.getCourseId() + " subjectOfStudy: " + course.getCourseName());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}