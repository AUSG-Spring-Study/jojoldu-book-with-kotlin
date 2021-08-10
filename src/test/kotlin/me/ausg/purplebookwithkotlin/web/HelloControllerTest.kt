package me.ausg.purplebookwithkotlin.web

import me.ausg.purplebookwithkotlin.web.dto.HelloResponseDto
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.util.MultiValueMap

@WebMvcTest(controllers = [HelloController::class])
internal class HelloControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun hello가_리턴된다() {
        // given
        val expectedContent = "hello";

        // when then
        mvc.get("/hello")
            .andExpect {
                status { isOk() }
                content { string(expectedContent) }
            }

    }

    @Test
    fun HelloResponseDto가_리턴된다() {
        // given
        val name = "name"
        val amount = 1000

        // when then
        mvc.get("/hello/dto") {
                param("name", name)
                param("amount", amount.toString())
            }.andExpect {
                status { isOk() }
                jsonPath("$.name", `is`(name))
                jsonPath("$.amount", `is`(amount))
            }

    }

}