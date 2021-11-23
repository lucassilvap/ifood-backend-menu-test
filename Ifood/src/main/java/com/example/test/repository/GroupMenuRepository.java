package com.example.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.GroupMenu;

@Repository
public interface GroupMenuRepository extends CrudRepository<GroupMenu, Long>{

}
