package com.example.mad;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Login login=null;
    private MainActivity mainActivity=null;
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testLogin() {
        assertNotNull(login.findViewById(R.id.btnLogin));


    }

    @Test
    public void testMain(){
            assertNotNull(mainActivity.findViewById(R.id.button));

        }
    }

