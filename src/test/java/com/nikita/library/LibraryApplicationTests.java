package com.nikita.library;

import com.nikita.library.controllers.PriorityController;
import com.nikita.library.entity.Priority;
import com.nikita.library.repo.CategoryRepository;
import com.nikita.library.repo.PriorityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LibraryApplicationTests {

	private CategoryRepository categoryRepository;
	private PriorityRepository priorityRepository;
	private PriorityController priorityController;

	@Test
	void getPriority() {
		List<Priority> priorities = priorityRepository.findAll();
		if (!priorities.isEmpty()){
			Assert.notEmpty(priorityController.getPriority(),"Check");
		}
	}

}
