package com.hr.service;

import com.hr.dto.ApplicantDto;
import com.hr.entity.Applicant;
import com.hr.repository.ApplicantRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("application-dev.properties")
@Sql(value = {})
class IApplicantServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IApplicantService applicantService;

    @MockBean
    private ApplicantRepository applicantRepository;

    @MockBean
    private IVacancyService vacancyService;

    @Test
    void registration() throws Exception{
        ApplicantDto dto = new ApplicantDto();
        dto.setCvFileName("testFileName");
        dto.setEmail("test@mail.ru");
        dto.setDescription("test");
        dto.setFullName("test");
        dto.setVacancyId(1);

        //applicantService.registration(dto);



    }

    @Test
    void getAllApplicants() {
    }

    @Test
    void getNotViewedApplicant() {
        List<Applicant> list = new ArrayList<>();

        Mockito.doReturn(list)
                .when(applicantRepository)
                .findByViewed(true);

        applicantService.getNotViewedApplicant();
    }

    @Test
    void getApplicantByVacancyId() {
    }

    @Test
    void applicantIsViewed() {
    }

    @Test
    void getApplicantById() {
    }

    @Test
    void applyApplicant() {
    }

    @Test
    void getStatusApplicant() {
    }
}