import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author  : Abhishek
 * @since   : 2024-03-26, Tuesday
 **/
public class MockitoTest {

    @Test
    void mock_list_returns_correct_element(){
        List<String> mockList = mock(ArrayList.class);
        when(mockList.get(0)).thenReturn("Hello World");
        assertEquals("Hello World", mockList.get(0));
    }
}
