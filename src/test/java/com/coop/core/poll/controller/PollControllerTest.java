package com.coop.core.poll.controller;

import java.time.LocalDateTime;

import com.coop.core.poll.dto.PollDto;
import com.coop.core.poll.model.Poll;
import com.coop.core.poll.service.IPollService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class PollControllerTest {

  @MockBean
  private IPollService pollService;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void shouldCreateNewPoll() throws Exception {
    String description = "Is poll working well?";
    int duration = 20;
    LocalDateTime startDate = LocalDateTime.now().plusMinutes(1);

    PollDto pollDto = new PollDto(description, duration, startDate);
    ResponseEntity<Poll> response = restTemplate.postForEntity("/api/v1/polls",
        pollDto, Poll.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    // assertThat(response.getBody()).isNotNull();

    // List<Session> sessions = poll.getSessions();
    // Session session = sessions.get(0);
    // assertThat(poll.getDescription()).isEqualTo(description);
    // assertThat(poll.getDurationMinutes()).isEqualTo(duration);
    // assertThat(sessions.size()).isEqualTo(1);
    // assertThat(session.getStartDate()).isEqualTo(startDate);
  }

}
