package me.iolsh.membersapp

import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner)
@SpringBootTest(classes = Application)
@WebAppConfiguration
class ApplicationTests {

    @Ignore
    @Test
    void contextLoads() {
    }

}
