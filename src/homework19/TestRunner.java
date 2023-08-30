package homework19;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner extends TestRunneers {

    public static void start(Class<?> testClass) {

        if (testClass == null) {
            throw new IllegalArgumentException("Test class cannot be null");
        }

        Method[] methods = testClass.getDeclaredMethods();


        List<Method> testMethods = new ArrayList<>();


        Method beforeSuite = null;
        Method afterSuite = null;


        for (Method method : methods) {

            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }

            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuite == null) {
                    beforeSuite = method;
                } else {
                    throw new RuntimeException("Only one method with @BeforeSuite annotation is allowed");
                }
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuite == null) {
                    afterSuite = method;
                } else {
                    throw new RuntimeException("Only one method with @AfterSuite annotation is allowed");
                }
            }
        }


        testMethods.sort(Comparator.comparingInt(m -> -m.getAnnotation(Test.class).priority()));

        try {

            Object testInstance = testClass.getDeclaredConstructor().newInstance();


            if (beforeSuite != null) {
                beforeSuite.invoke(testInstance);
            }


            for (Method testMethod : testMethods) {
                testMethod.invoke(testInstance);
            }


            if (afterSuite != null) {
                afterSuite.invoke(testInstance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start(MyTest.class);
    }
}

