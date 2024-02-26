package examquery.portlet;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import esami.model.Exam;
import esami.model.impl.ExamImpl;
import esami.service.CourseLocalServiceUtil;
import esami.service.ExamLocalService;
import examquery.constants.ExamQueryPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author alexa
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=ExamQuery",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ExamQueryPortletKeys.EXAMQUERY,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class ExamQueryPortlet extends MVCPortlet {
    @ProcessAction(name = "getByGrade")
    public void getByGrade(ActionRequest actionRequest, ActionResponse actionResponse) {
        List<Exam> findByGradeNoProjection = findByGradeNoProjection(6.0);
        actionRequest.setAttribute("findByGradeNoProjection", findByGradeNoProjection);

        List<Object[]> findByGrade = findByGrade(6.0);
        actionRequest.setAttribute("findByGrade", findByGrade);
        findByGrade.stream()
                .map(Arrays::toString)
                .forEach(System.out::println);

        List<Object[]> getByGradeWithTeacherStudentCourseName = getByGradeWithTeacherStudentCourseName(6.0);
        actionRequest.setAttribute("getByGradeWithTeacherStudentCourseName", getByGradeWithTeacherStudentCourseName);

        getByGradeWithTeacherStudentCourseName.stream()
                .map(Arrays::toString)
                .forEach(System.out::println);

    }

    @Reference
    private ExamLocalService examLocalService;


    //for projectionlist use List<Object[]> name
    public List<Object[]> findByGrade(Double grade) {
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
                    .add(RestrictionsFactoryUtil.lt("grade", grade))
                    .addOrder(order);


            return examLocalService.dynamicQuery(examQuery);

        } catch (Exception e) {
            e.getMessage();
        }
        return new ArrayList<>();
    }


    public List<Exam> findByGradeNoProjection(Double grade) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Order order = OrderFactoryUtil.desc("examDate");

            DynamicQuery examQuery = DynamicQueryFactoryUtil.forClass(Exam.class, classLoader)
                    .add(RestrictionsFactoryUtil.lt("grade", grade))
                    .addOrder(order);


            return examLocalService.dynamicQuery(examQuery);

        } catch (Exception e) {
            e.getMessage();
        }
        return new ArrayList<>();
    }

    public List<Object[]> getByGradeWithTeacherStudentCourseName(Double grade) {
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
                    .add(RestrictionsFactoryUtil.lt("grade", grade))
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
            e.getMessage();
        }
        return new ArrayList<>();

    }
}


//lt = less than , gt = greater than , le = less or equal
// ge = greater or equal

// SELECT * FROM User_ WHERE lastName=’Bloggs’  .eq("lastName", "Bloggs");

// SELECT * FROM User_ WHERE lastName like ‘ord%’
// .like("lastName", "ord%");

// SELECT * FROM User_ WHERE userId BETWEEN 10931 AND 10945
// .between(new Long(10931), new Long(10945)));  between two values

//SELECT DISTINCT firstName from User_
// .distinct("firstName");

//            SELECT DISTINCT firstName from User_