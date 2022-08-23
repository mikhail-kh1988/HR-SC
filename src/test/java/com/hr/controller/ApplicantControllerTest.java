package com.hr.controller;


import com.hr.dto.ApplicantDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(ApplicantController.class)
class ApplicantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicantController controller;

    @Test
    void testApplicant() throws Exception{
        ApplicantDto applicantDto = new ApplicantDto();
        applicantDto.setVacancyId(1);
        applicantDto.setDescription("test");
        applicantDto.setEmail("test");
        applicantDto.setFullName("TeSt");
        applicantDto.setCvFileName("testFile");

        MockHttpServletRequest requestPost = new MockHttpServletRequest();
        RequestBuilder request = MockMvcRequestBuilders.put("/register", applicantDto);
        MvcResult result = mockMvc.perform(request)
                .andExpectAll()
                .andReturn();

        assertEquals("{ \"message\": \"ok\" }", result.getResponse().getContentAsString());

    }

    @Test
    void isViewedApplicant() {
    }

    @Test
    void applyApplicant() {
    }

    @Test
    void getApplicantByID() {
    }

    @Test
    void getApplicantsByVacancyId() {
    }

    @Test
    void getNotViewedApplicant() {
    }

    @Test
    void registrationApplicant() {
    }

    @Test
    void getStatusApplicant() {
    }
}