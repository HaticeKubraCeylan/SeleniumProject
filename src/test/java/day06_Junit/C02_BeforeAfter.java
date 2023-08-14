package day06_Junit;

import org.junit.*;

public class C02_BeforeAfter {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Tüm classtan önce tek bir sefer çalışır");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her methodtan önce bir kez çalışır");
    }

    @Test
    public void test01() {
        System.out.println("Test01 çalıştı");
    }

    @Test
    public void test02() {
        System.out.println("Test02 çalıştı");
    }

    @Test
    public void test03() {
        System.out.println("Test03 çalıştı");
    }

    @Test
    public void test04() {
        System.out.println("Test04 çalıştı");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her methodtan sonra bir kez çalışır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Tüm classtan sonra tek bir sefer çalışır");
    }
    /*
    Bir classta 4 tane test methodu 1 tane before 1 tane after methodu varsa classta kaç tane method çalışmıştır (12)
     */
}
