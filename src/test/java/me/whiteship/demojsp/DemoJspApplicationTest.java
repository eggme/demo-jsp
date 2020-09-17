package me.whiteship.demojsp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
class DemoJspApplicationTest {

    @MockBean
    MockMvc mockMvc;

    @Test
    public void events() throws Exception {
        // Test가 Null이 나와..
        String msg = "Happy New year!!";
        mockMvc.perform(get("/events"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", msg));
    }

}