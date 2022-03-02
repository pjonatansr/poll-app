package com.coop.core.poll.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.coop.core.common.model.BaseEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Member extends BaseEntity {
  @Column(name = "description")
  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

}
