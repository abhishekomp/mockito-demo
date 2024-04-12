import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author  : Abhishek
 * @since   : 2024-03-26, Tuesday
 **/
@ExtendWith(MockitoExtension.class)
public class MockCreationTest {

    @Mock
    List<String> mockList;

    @Test
    void mock_list_returns_correct_element(){
        //List<String> mockList = mock(ArrayList.class);
        when(mockList.get(0)).thenReturn("Hello World");
        assertEquals("Hello World", mockList.get(0));
    }
}
