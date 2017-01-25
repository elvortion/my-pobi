package net.slipp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.slipp.domain.Question;
import net.slipp.domain.QuestionRepository;

@RestController
@RequestMapping("/api/questions")
public class ApiQuestionController {
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("")
	public List<Question> list() {
		return questionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Question show(@PathVariable long id) {
		return questionRepository.findOne(id);
	}
}
