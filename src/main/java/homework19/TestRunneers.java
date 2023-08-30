package homework19;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestRunneers {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Test {
        int priority() default 5; // Задаем приоритет по умолчанию
    }

    // Создаем аннотацию для метода, который должен запускаться перед всеми тестами
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface BeforeSuite {
    }

    // Создаем аннотацию для метода, который должен запускаться после всех тестов
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface AfterSuite {
    }
}
