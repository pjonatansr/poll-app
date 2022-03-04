package com.coop.core.common.service;

import com.coop.core.common.exception.ValidationException;

public interface IBaseService<T, TDto> {
  T save(TDto entityDto) throws ValidationException;

}
