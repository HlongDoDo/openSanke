package com.study.excel.memberRwhController;

import com.study.my.entity.FsmpRwhAppInfo;
import com.study.my.entity.FsmpRwhCategory;
import com.study.my.entity.FsmpRwhExchangeProdInfo;
import com.study.my.mapper.FsmpRwhAppInfoMapper;
import com.study.my.mapper.FsmpRwhCategoryMapper;
import com.study.my.mapper.FsmpRwhExchangeProdInfoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MemberRwhController.class)
class MemberRwhControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FsmpRwhCategoryMapper mockCategoryMapper;
    @MockBean
    private FsmpRwhAppInfoMapper mockAppInfoMapper;
    @MockBean
    private FsmpRwhExchangeProdInfoMapper mockExchangeProdInfoMapper;

    @Test
    void testInsertCategoryFromExcel() throws Exception {
        // Setup
        when(mockCategoryMapper.insertSelective(new FsmpRwhCategory())).thenReturn(0);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(
                multipart("/memberRwhController/insertCategoryFromExcel")
                        .file(new MockMultipartFile("file", "originalFilename", MediaType.APPLICATION_JSON_VALUE,
                                "content".getBytes()))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockCategoryMapper).insertSelective(new FsmpRwhCategory());
    }

    @Test
    void testInsertCategoryFromExcel_ThrowsIOException() throws Exception {
        // Setup
        when(mockCategoryMapper.insertSelective(new FsmpRwhCategory())).thenReturn(0);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(
                multipart("/memberRwhController/insertCategoryFromExcel")
                        .file(new MockMultipartFile("file", "originalFilename", MediaType.APPLICATION_JSON_VALUE,
                                "content".getBytes()))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockCategoryMapper).insertSelective(new FsmpRwhCategory());
    }

    @Test
    void testInsertAppInfoFromExcel() throws Exception {
        // Setup
        when(mockAppInfoMapper.insertSelective(new FsmpRwhAppInfo())).thenReturn(0);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(
                multipart("/memberRwhController/insertAppInfoFromExcel")
                        .file(new MockMultipartFile("file", "originalFilename", MediaType.APPLICATION_JSON_VALUE,
                                "content".getBytes()))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockAppInfoMapper).insertSelective(new FsmpRwhAppInfo());
    }

    @Test
    void testInsertAppInfoFromExcel_ThrowsIOException() throws Exception {
        // Setup
        when(mockAppInfoMapper.insertSelective(new FsmpRwhAppInfo())).thenReturn(0);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(
                multipart("/memberRwhController/insertAppInfoFromExcel")
                        .file(new MockMultipartFile("file", "originalFilename", MediaType.APPLICATION_JSON_VALUE,
                                "content".getBytes()))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockAppInfoMapper).insertSelective(new FsmpRwhAppInfo());
    }

    @Test
    void testInsertProdInfoFromExcel() throws Exception {
        // Setup
        when(mockExchangeProdInfoMapper.insertSelective(new FsmpRwhExchangeProdInfo())).thenReturn(0);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(
                multipart("/memberRwhController/insertProdInfoFromExcel")
                        .file(new MockMultipartFile("file", "originalFilename", MediaType.APPLICATION_JSON_VALUE,
                                "content".getBytes()))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockExchangeProdInfoMapper).insertSelective(new FsmpRwhExchangeProdInfo());
    }

    @Test
    void testInsertProdInfoFromExcel_ThrowsIOException() throws Exception {
        // Setup
        when(mockExchangeProdInfoMapper.insertSelective(new FsmpRwhExchangeProdInfo())).thenReturn(0);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(
                multipart("/memberRwhController/insertProdInfoFromExcel")
                        .file(new MockMultipartFile("file", "originalFilename", MediaType.APPLICATION_JSON_VALUE,
                                "content".getBytes()))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockExchangeProdInfoMapper).insertSelective(new FsmpRwhExchangeProdInfo());
    }
}
