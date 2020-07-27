package com.social.postboard.controller;

import com.social.postboard.service.CommunityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CommunityController.class)
public class CommunityControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommunityService communityService;

    @Test
    public void testAddCommunity_200OK() throws Exception {
        mockMvc.perform(post("/communities")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk());

        verify(communityService).addCommunity(any());
    }

}
