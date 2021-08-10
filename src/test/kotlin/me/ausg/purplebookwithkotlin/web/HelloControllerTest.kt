package me.ausg.purplebookwithkotlin.web

import me.ausg.purplebookwithkotlin.web.dto.HelloResponseDto
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(controllers = [HelloController::class])
internal class HelloControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun hello가_리턴된다() {
        // given
        val url = "/hello"
        val expectedContent = "hello";

        // when then
        mvc.perform(get(url))
            .andExpect { status().isOk }
            .andExpect { content().string(expectedContent) }
    }

    @Test
    fun HelloResponseDto가_리턴된다() {
        // given
        val url = "/hello/dto"
        val name = "name"
        val amount = 1000

        // when
        mvc.perform(
            get(url)
                .param("name", name)
                .param("amount", amount.toString())
        )
            .andExpect { status().isOk }
            .andExpect { jsonPath("$.name", `is`(name)) }
            .andExpect { jsonPath("$.amount", `is`(amount)) }

        // given
    }

}