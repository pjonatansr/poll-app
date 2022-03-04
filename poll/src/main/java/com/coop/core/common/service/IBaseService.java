package com.coop.core.common.service;

import org.quartz.xml.ValidationException;

public interface IBaseService<T, TDto> {
  T save(TDto entityDto) throws ValidationException;

}
