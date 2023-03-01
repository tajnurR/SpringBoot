package com.garmentsmanagement.GM.repository;

import com.garmentsmanagement.GM.entity.test.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestModelRepo extends JpaRepository<TestModel, Integer> {

    @Query("select x from TestModel x where x.title = ?1")
    public List<TestModel> findTestModelByTitle(String title);
}
