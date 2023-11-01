package com.example.demo.Pagination;

import com.example.demo.Cursos.CursoModel.ReturnCoursesHome;
import com.example.demo.Posts.PostModel.ReturnPostsHome;

import java.util.List;

public class PaginationCourses {
    private final List<ReturnCoursesHome> data;
    private final int currentPage;

    private final int itemsPerPage;

    public PaginationCourses(List<ReturnCoursesHome> data) {
        this.data = data;
        this.itemsPerPage = 15;
        this.currentPage = 1;
    }

    public List<ReturnCoursesHome> getCurrentPageData() {
        int startIndex = (currentPage - 1) * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, data.size());
        return data.subList(startIndex, endIndex);
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) data.size() / itemsPerPage);
    }
}
