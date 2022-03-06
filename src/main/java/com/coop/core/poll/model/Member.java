package com.coop.core.poll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Member {
  @Id
  @NotNull
  private Long id;

  @Column(name = "description", length = 11)
  private String cpf;

  /**
   * @return String
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * @param cpf
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * @return Long
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id
   */
  public void setId(Long id) {
    this.id = id;
  }
}
