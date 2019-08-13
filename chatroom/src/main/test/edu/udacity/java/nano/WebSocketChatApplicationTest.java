package edu.udacity.java.nano;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(WebSocketChatApplication.class)
public class WebSocketChatApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void login() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/")).andDo(print())
                .andExpect(status().isOk()).andExpect(view().name("login"));
    }

   @Test
    public void index() throws Exception{

        mvc.perform(MockMvcRequestBuilders.get("/index?username={username}", "test")).andDo(print())
                .andExpect(status().isOk()).andExpect(view().name("chat"));

    }
}