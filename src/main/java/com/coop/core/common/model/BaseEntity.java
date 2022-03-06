package com.coop.core.common.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  
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