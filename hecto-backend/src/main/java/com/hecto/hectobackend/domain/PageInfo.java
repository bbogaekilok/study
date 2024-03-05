package com.hecto.hectobackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int pageIndex;
    private final int pageSize;
    private final int totalCount;
    private final List<T> data;

    public int getTotalPage(){
        return (int) Math.ceil((double) totalCount / pageSize);
    }
}
