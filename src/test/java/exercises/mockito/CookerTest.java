package exercises.mockito;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CookerTest {

	@InjectMocks
	Cooker cooker;

	@Mock
	Pan pan;

	@Before
	public void initialize() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void panShouldWarmUp() {
		cooker.turnOn();
		verify(pan).increaseHeat(anyInt());
	}

	@Test
	public void panShouldIncreaseHeatByOneDegree() {
		cooker.turnOn();
		ArgumentCaptor<Integer> degrees = ArgumentCaptor.forClass(Integer.class);
		verify(pan).increaseHeat(degrees.capture());
		assertThat(degrees.getValue(), equalTo(1));
	}
}
