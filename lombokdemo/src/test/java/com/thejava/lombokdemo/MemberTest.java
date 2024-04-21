package com.thejava.lombokdemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    public void getterSetter() {
        Member member = new Member();
        member.setName("hwanwoo");

        Assertions.assertThat("hwanwoo").isEqualTo(member.getName());
    }
}