package examqueryv2.portlet;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import esami.model.Exam;
import esami.service.CourseLocalServiceUtil;
import esami.service.ExamLocalService;
import examqueryv2.constants.ExamQueryV2PortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alexa
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=ExamQueryV2",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ExamQueryV2PortletKeys.EXAMQUERYV2,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class ExamQueryV2Portlet extends MVCPortlet {
    @ProcessAction(name = "getExam")
    public void getExam(ActionRequest actionRequest, ActionResponse actionResponse) {
        long selectedStudent = ParamUtil.getLong(actionRequest, "studentId");
        long selectedTeacher = ParamUtil.getLong(actionRequest, "teacherId");

        if (selectedStudent > 0) {
            List<Object[]> findByStudentId = getExamsByStudentId(selectedStudent);
            actionRequest.setAttribute("getExams", findByStudentId);
            System.out.println("studentId: " + selectedStudent);
        }
        if (selectedTeacher > 0) {
            List<Object[]> findByTeacherId = getExamsByTeacherId(selectedTeacher);
            actionRequest.setAttribute("getExams", findByTeacherId);
            System.out.println("teacherId: " + selectedTeacher);
        }

    }


    @Reference
    private ExamLocalService examLocalService;


    //get exam by student
    public List<Object[]> getExamsByStudentId(long id) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Order order = OrderFactoryUtil.desc("examDate");

            ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
            projectionList.add(ProjectionFactoryUtil.property("examId"));
            projectionList.add(ProjectionFactoryUtil.property("studentId"));
            projectionList.add(ProjectionFactoryUtil.property("teacherId"));
            projectionList.add(ProjectionFactoryUtil.property("courseId"));
            projectionList.add(ProjectionFactoryUtil.property("examDate"));
            projectionList.add(ProjectionFactoryUtil.property("grade"));
            DynamicQuery examQuery = DynamicQueryFactoryUtil.forClass(Exam.class, classLoader)
                    .setProjection(projectionList)
                    .add(RestrictionsFactoryUtil.eq("studentId", id))
                    .addOrder(order);

            List<Object[]> resultsObj = examLocalService.dynamicQuery(examQuery);

            for (Object[] obj : resultsObj) {
                String studentScreenName = UserLocalServiceUtil.getUserById((Long) obj[1]).getScreenName();
                String teacherScreenName = UserLocalServiceUtil.getUserById((Long) obj[2]).getScreenName();
                String courseName = CourseLocalServiceUtil.getCourse((Long) obj[3]).getCourseName();

                obj[1] = studentScreenName;
                obj[2] = teacherScreenName;
                obj[3] = courseName;
            }
            return resultsObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }


    //get exam by teacher
    public List<Object[]> getExamsByTeacherId(long id) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Order order = OrderFactoryUtil.desc("examDate");

            ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
            projectionList.add(ProjectionFactoryUtil.property("examId"));
            projectionList.add(ProjectionFactoryUtil.property("studentId"));
            projectionList.add(ProjectionFactoryUtil.property("teacherId"));
            projectionList.add(ProjectionFactoryUtil.property("courseId"));
            projectionList.add(ProjectionFactoryUtil.property("examDate"));
            projectionList.add(ProjectionFactoryUtil.property("grade"));
            DynamicQuery examQuery = DynamicQueryFactoryUtil.forClass(Exam.class, classLoader)
                    .setProjection(projectionList)
                    .add(RestrictionsFactoryUtil.eq("teacherId", id))
                    .addOrder(order);

            List<Object[]> resultsObj = examLocalService.dynamicQuery(examQuery);

            for (Object[] obj : resultsObj) {
                String studentScreenName = UserLocalServiceUtil.getUserById((Long) obj[1]).getScreenName();
                String teacherScreenName = UserLocalServiceUtil.getUserById((Long) obj[2]).getScreenName();
                String courseName = CourseLocalServiceUtil.getCourse((Long) obj[3]).getCourseName();

                obj[1] = studentScreenName;
                obj[2] = teacherScreenName;
                obj[3] = courseName;
            }
            return resultsObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }


    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        //get students
        List<User> students = new ArrayList<>();
        students.addAll(UserLocalServiceUtil.getRoleUsers(32933)); //back end
        students.addAll(UserLocalServiceUtil.getRoleUsers(32934)); //front end
        renderRequest.setAttribute("students", students);

        //get teachers
        List<User> teachers = UserLocalServiceUtil.getRoleUsers(32935);
        renderRequest.setAttribute("teachers", teachers);

        super.doView(renderRequest, renderResponse);
    }
}