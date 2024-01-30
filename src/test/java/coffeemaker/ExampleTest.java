package coffeemaker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {
	private List<String> list;

	@BeforeEach
	void init() {
		list = new ArrayList<>();
	}

	@Test
	void testAdd() {
		list.add("test");
		assertEquals(1, list.size());
	}

	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
	}

	@Test
	void testSetException() {
		assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, ""));
	}
}
