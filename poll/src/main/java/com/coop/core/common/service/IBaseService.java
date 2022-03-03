package com.coop.core.common.service;

import java.util.List;

public interface IBaseService<T, TDto> {
  T save(TDto entityDto);

  List<T> fetchList();

}
