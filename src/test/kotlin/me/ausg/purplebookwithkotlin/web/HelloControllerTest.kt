package me.ausg.purplebookwithkotlin.web

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

@WebMvcTest(controllers = [HelloController::class])
internal class HelloControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun hello가_리턴된다() {
        // given
        val to = get("/hello")
        val expectedContent = "hello";
        val expectedStatus = status().isOk

        // when then
        mvc.perform(to)
            .andExpect(expectedStatus)
            .andExpect { content().string(expectedContent) }
    }

}