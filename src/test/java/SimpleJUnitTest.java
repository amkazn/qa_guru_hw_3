import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("### @BeforeAll");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("### @BeforeEach beforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("### @AfterEach");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("### @AfterAll");
    }

    @Test
    void firstTest(){
        System.out.println("### @Test firstTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest(){
        System.out.println("### @Test secondTest");
        Assertions.assertTrue(3 > 2);
    }

}
