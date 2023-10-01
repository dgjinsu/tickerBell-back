package com.tickerBell.domain.event.repository;

import com.tickerBell.domain.event.entity.Category;
import com.tickerBell.domain.event.entity.Event;
import com.tickerBell.domain.member.entity.Member;
import com.tickerBell.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("이벤트 저장 테스트")
    void saveTest() {
        // given
        Member member = Member.builder().build();
        Member savedMember = memberRepository.save(member);

        String name = "mockName";
        LocalDateTime startEvent = LocalDateTime.now();
        LocalDateTime endEvent = LocalDateTime.now();
        Integer normalPrice = 100;
        Integer premiumPrice = 1000;
        Float saleDegree = 0.0F;
        String casting = "mockCasting";
        Integer totalSeat = 60;
        Integer remainSeat = 60 ;
        String host = "mockHost";
        String place = "mockPlace";
        Integer age = 18;
        Category category = Category.MUSICAL;
        Event event = Event.builder()
                .name(name)
                .startEvent(startEvent)
                .endEvent(endEvent)
                .normalPrice(normalPrice)
                .premiumPrice(premiumPrice)
                .saleDegree(saleDegree)
                .casting(casting)
                .totalSeat(totalSeat)
                .remainSeat(remainSeat)
                .host(host)
                .place(place)
                .age(age)
                .category(category)
                .member(member)
                .build();

        // when
        Event savedEvent = eventRepository.save(event);

        // then
        assertThat(savedEvent).isEqualTo(event);
        assertThat(savedEvent.getId()).isEqualTo(event.getId());
        assertThat(savedEvent.getName()).isEqualTo(event.getName());
        assertThat(savedEvent.getStartEvent()).isEqualTo(event.getStartEvent());
        assertThat(savedEvent.getEndEvent()).isEqualTo(event.getEndEvent());
        assertThat(savedEvent.getNormalPrice()).isEqualTo(event.getNormalPrice());
        assertThat(savedEvent.getPremiumPrice()).isEqualTo(event.getPremiumPrice());
        assertThat(savedEvent.getSaleDegree()).isEqualTo(event.getSaleDegree());
        assertThat(savedEvent.getCasting()).isEqualTo(event.getCasting());
        assertThat(savedEvent.getTotalSeat()).isEqualTo(event.getTotalSeat());
        assertThat(savedEvent.getRemainSeat()).isEqualTo(event.getRemainSeat());
        assertThat(savedEvent.getHost()).isEqualTo(event.getHost());
        assertThat(savedEvent.getPlace()).isEqualTo(event.getPlace());
        assertThat(savedEvent.getAge()).isEqualTo(event.getAge());
        assertThat(savedEvent.getCategory()).isEqualTo(event.getCategory());
        assertThat(savedEvent.getCategory().name()).isEqualTo(event.getCategory().name());
        assertThat(savedEvent.getCategory().getDescription()).isEqualTo(event.getCategory().getDescription());
        assertThat(savedEvent.getMember()).isEqualTo(savedMember);
    }
}