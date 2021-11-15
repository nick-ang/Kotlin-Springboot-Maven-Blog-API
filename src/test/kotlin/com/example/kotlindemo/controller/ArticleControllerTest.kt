package com.example.kotlindemo.controller

import com.jayway.jsonpath.JsonPath
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath


@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `should return 200 when articles endpoint receives a GET request`() {


        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/api/articles")
                .contentType(MediaType.APPLICATION_JSON)

        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    fun `should return 200 when a new article is added`() {
        val requestBody = """
            {"title": "How to learn Spring framework", "content": "Resources to learn Spring framework"}
        """.trimIndent()

        val expectedResponseBody = """
            {"id":2,"title":"How to learn Spring framework","content":"Resources to learn Spring framework"}
        """.trimIndent()

        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/api/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)

        )
            .andExpect(MockMvcResultMatchers.status().isOk)
//            .andExpect(MockMvcResultMatchers.content().json(expectedResponseBody, true))
            .andExpect(jsonPath("$.title").value("How to learn Spring framework"))
            .andExpect(jsonPath("$.content").value("Resources to learn Spring framework"))
    }


    @Test
    fun getArticleById() {
    }

    @Test
    fun updateArticleById() {
    }

}