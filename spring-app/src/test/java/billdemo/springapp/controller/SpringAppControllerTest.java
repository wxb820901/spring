package billdemo.springapp.controller;

import billdemo.springapp.feign.SpringRepoFeign;

import billdemo.springapp.pojo.UserPojo;
import billdemo.springjpa.model.entity.User;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SpringAppControllerTest {
    @Mock
    private SpringRepoFeign springRepoFeign;
    @InjectMocks
    private SpringAppController springAppController;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(springAppController).build();
    }

    @Test
    public void testPostUser() throws Exception {
        User user = new User();
        EntityModel<User> userEntityModel = EntityModel.of(user);
        when(springRepoFeign.createUser(any())).thenReturn(userEntityModel);
        this.mockMvc.perform(
                post("/api/v1/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\"userId\":\"dummy_user_id\",\n" +
                                "\"userName\":\"dummy_user_name\",\n" +
                                "\"name\": \"dummy_name\",\n" +
                                "\"birthday\": \"2012-12-12T00:01:01.123\",\n" +
                                "\"groupId\":\"dummy_group_id\"\n" +
                                "}")
        )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("{\"id\":null,\"createTime\":null,\"updateTime\":null,\"userId\":null,\"userName\":null,\"userGroup\":null,\"name\":null,\"birthday\":null}"));

    }

    @Test
    public void testGetUser() throws Exception {
        User user = new User();
        List<User> users = Arrays.asList(user);
        CollectionModel<User> userPojos = CollectionModel.of(users);
        when(springRepoFeign.listUser()).thenReturn(userPojos);
        this.mockMvc.perform(get("/api/v1/user"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("[{\"id\":null,\"createTime\":null,\"updateTime\":null,\"userId\":null,\"userName\":null,\"userGroup\":null,\"name\":null,\"birthday\":null}]"));

    }
}
