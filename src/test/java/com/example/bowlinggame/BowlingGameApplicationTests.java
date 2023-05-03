package com.example.bowlinggame;

import com.example.bowlinggame.BowlingGameApplication.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BowlingGameApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testGutterGame() throws Exception {
		rollMany(20, 0);
		assertThat(g.score()).isZero();
	}

	@Test
	void testAllOnes() throws Exception {
		rollMany(20, 1);
		assertThat(g.score()).isEqualTo(20);
	}

	@Test
	void testOneSpare() throws Exception {
		rollSpare();
		g.roll(3);
		rollMany(17,0);
		assertThat(g.score()).isEqualTo(16);
	}

	@Test
	void testStrike() throws Exception {
		g.roll(10);
		g.roll(3);
		g.roll(4);
		rollMany(16,0);
		assertThat(g.score()).isEqualTo(24);
	}

	public void testPerfectGame() throws Exception {
		rollMany(12,10);
		assertThat(g.score()).isEqualTo(300);
	}

	@BeforeEach
	void setUp() throws Exception {
		g = new Game();
	}

	private void rollSpare(){
		g.roll(5);
		g.roll(5);
	}

	private void rollMany(int n, int pins){
		for (int i = 0; i < n; i++) {
			g.roll(pins);
		}
	}


	private Game g;
}
