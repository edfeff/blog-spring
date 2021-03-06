package com.edfeff.uploading.files;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Paths;
import java.util.stream.Stream;


/**
 * @author wangpp
 */
@SpringBootTest
@AutoConfigureMockMvc
public class FileUploadTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private StorageService storageService;

    @Test
    //test get /
    public void shouldListAllFiles() throws Exception {
        BDDMockito.given(this.storageService.loadAll())
                .willReturn(Stream.of(Paths.get("first.txt"), Paths.get("second.txt")));
        this.mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("files", Matchers.contains("http://localhost/files/first.txt", "http://localhost/files/second.txt")));
    }

    @Test
    //test upload
    public void shouldSaveUploadedFile() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "tests.txt", "text/plain", "Spring Upload".getBytes());
        this.mvc.perform(MockMvcRequestBuilders.multipart("/").file(multipartFile))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.header().string("Location", "/"));

        BDDMockito.then(this.storageService).should().store(multipartFile);
    }

    @Test
    @SuppressWarnings( "unchecked" )
    public void should404WhenMissingFile() throws Exception {
        BDDMockito.given(storageService.loadAsResource("test.txt"))
                .willThrow(RuntimeException.class);

        this.mvc.perform(MockMvcRequestBuilders.get("/files/test.txt"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
