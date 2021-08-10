package me.ausg.purplebookwithkotlin.web.dto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

internal class HelloResponseDtoTest {
    @Test
    fun 데이터_클래스_테스트() {
        // given
        val name = "test";
        val amount = 1000;

        // when
        val dto = HelloResponseDto(name, amount)

        // then
        assertAll(
            Executable { assertThat(dto.name).isEqualTo(name) },
            Executable { assertThat(dto.amount).isEqualTo(amount) },
        )

    }
}