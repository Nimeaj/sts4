package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

public class TestController {
	private final BoardRepository boardRepo;

	@GetMapping("/board")
	public List<Board> getBoards() {
		// 코딩
	}

	@GetMapping("/board/{seq}")
	public Board getBoard(@PathVariable Long seq) {
		// 코딩
	}

	@PostMapping("/board")
	public Board postBoard(Board board) {
		// 코딩
	}

	@PutMapping("/board")
	public Board putBoard(Board board) {
		// 코딩
	}

	@DeleteMapping("/board/{seq}")
	public Board deleteBoard(@PathVariable Long seq) {
		// 코딩
	}
}
