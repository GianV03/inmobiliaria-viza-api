package com.inmobiliariavives.inmobiliariavives.utils;

import java.util.List;

public class PaginatedResponse<T> {
    private List<T> data;
    private long totalElements;
    private int page;

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getData() {
        return data;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getPage() {
        return page;
    }
// Constructor, getters y setters
}