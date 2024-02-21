package gradeassignment.portlet;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import esami.model.Exam;
import esami.service.ExamLocalServiceUtil;
import gradeassignment.constants.GradeAssignmentPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author alexa
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=GradeAssignment",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + GradeAssignmentPortletKeys.GRADEASSIGNMENT,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class GradeAssignmentPortlet extends MVCPortlet {
    @ProcessAction(name = "addExam")
    public void add(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {

        //get current teacher
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long teacherId = themeDisplay.getUser().getUserId();

        //get exam count and create new examId
        long examCount = ExamLocalServiceUtil.getExamsCount();
        Exam exam = ExamLocalServiceUtil.createExam(examCount + 1);
        exam.setTeacherId(teacherId);

        //get attributes from request
        long studentId = ParamUtil.getLong(actionRequest, "studentId");
        //impostare un dtataformat altrimenti non va (Da tradurre)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date examDate = ParamUtil.getDate(actionRequest, "date", sdf);
        System.out.println("data esame: " + examDate);
        long courseId = ParamUtil.getLong(actionRequest, "subjectOfExam");
        double grade = ParamUtil.getDouble(actionRequest, "grade");


        //set attributes
        exam.setStudentId(studentId);
        exam.setExamDate(examDate);
        exam.setCourseId(courseId);
        exam.setGrade(grade);
        ExamLocalServiceUtil.addExam(exam);

        //print on console exam
        System.out.println("New exam add to database: " + exam);
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        //get current teacher and set name in request
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User teacher = themeDisplay.getUser();
        String teacherName = teacher.getScreenName();
        renderRequest.setAttribute("teacherName", teacherName);

//        List<User> backEndStudents = UserLocalServiceUtil.getRoleUsers(32933);
//        List<User> frontEndStudents = UserLocalServiceUtil.getRoleUsers(32934);

        //get studentsList using getRoleUsers methods (filtered by role)
        //roleId get by DBeaver
        List<User> students = new ArrayList<>();
        students.addAll(UserLocalServiceUtil.getRoleUsers(32933)); //back end
        students.addAll(UserLocalServiceUtil.getRoleUsers(32934)); //front end
        renderRequest.setAttribute("students", students);
        super.doView(renderRequest, renderResponse);
    }
}