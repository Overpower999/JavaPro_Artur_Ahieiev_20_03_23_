package homework19;

public class MyTest extends TestRunneers {
    @BeforeSuite
    public void before() {
        System.out.println("This method runs before all tests");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("This is test 1 with priority 1");
    }

    @Test(priority = 10)
    public void test2() {
        System.out.println("This is test 2 with priority 10");
    }

    @Test
    public void test3() {
        System.out.println("This is test 3 with default priority 5");
    }

    @AfterSuite
    public void after() {
        System.out.println("This method runs after all tests");
    }
}

