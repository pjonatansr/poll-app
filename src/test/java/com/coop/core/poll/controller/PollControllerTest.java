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
    ResponseEntity<Poll> response = restTemplate.postForEntity("/api/v1/polls",
        new PollDto("Is poll working well?", 20, LocalDateTime.now().plusMinutes(1)), Poll.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

}
