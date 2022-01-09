package com.company.test;

import com.company.PaginationHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaginationHelperTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void itemCount() {
        Integer[] ints = {1, 2, 45, 78, 980};
        PaginationHelper<Integer> pageHelper = new PaginationHelper<>(List.of(ints), 2);
        String[] strings = {"Hello", "Hi"};
        PaginationHelper<String> pageHelperString = new PaginationHelper<>(List.of(strings), 3);
        Character[] chars = {'a', 'b', 'n', 'm', 'e', 'y', 'e', 'g', 'j', 'a', 'w', 'o', 'p', 'q', 'c'};
        PaginationHelper<Character> pageHelperChar = new PaginationHelper<>(List.of(chars), 4);

        //First parameter is what is expected, the second is the function that produces the actual result
        assertEquals(5, pageHelper.itemCount());
        assertEquals(2, pageHelperString.itemCount());
        assertEquals(15, pageHelperChar.itemCount());
    }

    @Test
    void pageCount() {
        Integer[] ints = {1, 2, 45, 78, 980};
        PaginationHelper<Integer> pageHelper = new PaginationHelper<>(List.of(ints), 2);
        Character[] chars = {'a', 'b', 'n', 'm', 'e', 'y', 'e', 'g', 'j', 'a', 'w', 'o', 'p', 'q', 'c'};
        PaginationHelper<Character> pageHelperChar = new PaginationHelper<>(List.of(chars), 4);
        String[] strings = {"Hello", "Hi"};
        PaginationHelper<String> pageHelperString = new PaginationHelper<>(List.of(strings), 3);

        //First parameter is what is expected, the second is the function that produces the actual result
        assertEquals(3, pageHelper.pageCount());
        assertEquals(4, pageHelperChar.pageCount());
        assertEquals(1, pageHelperString.pageCount());
    }

    @Test
    void pageItemCount() {
        Integer[] Integers = {};
        PaginationHelper<Integer> pageHelperEmpty = new PaginationHelper<>(List.of(Integers), 8);
        Integer[] ints = {1, 2, 45, 78, 980};
        PaginationHelper<Integer> pageHelper = new PaginationHelper<>(List.of(ints), 2);
        Character[] chars = {'a', 'b', 'n', 'm', 'e', 'y', 'e', 'g', 'j', 'a', 'w', 'o', 'p', 'q', 'c'};
        PaginationHelper<Character> pageHelperChar = new PaginationHelper<>(List.of(chars), 4);
        String[] strings = {"Hello", "Hi"};
        PaginationHelper<String> pageHelperString = new PaginationHelper<>(List.of(strings), 3);

        //First parameter is what is expected, the second is the function that produces the actual result

        //Test out of range
        assertEquals(-1, pageHelper.pageItemCount(50));
        assertEquals(-1, pageHelper.pageItemCount(-100));
        assertEquals(-1, pageHelperString.pageItemCount(1));
        assertEquals(-1, pageHelperChar.pageItemCount(4));

        //Test in range
        assertEquals(4, pageHelperChar.pageItemCount(0));
        assertEquals(4, pageHelperChar.pageItemCount(2));
        assertEquals(3, pageHelperChar.pageItemCount(3));
        assertEquals(2, pageHelper.pageItemCount(0));
        assertEquals(2, pageHelper.pageItemCount(1));
        assertEquals(1, pageHelper.pageItemCount(2));
        assertEquals(2, pageHelperString.pageItemCount(0));


    }

    @Test
    void pageIndex() {
        Integer[] Integers = {};
        PaginationHelper<Integer> pageHelperEmpty = new PaginationHelper<>(List.of(Integers), 8);
        Integer[] ints = {1, 2, 45, 78, 980};
        PaginationHelper<Integer> pageHelper = new PaginationHelper<>(List.of(ints), 2);
        Character[] chars = {'a', 'b', 'n', 'm', 'e', 'y', 'e', 'g', 'j', 'a', 'w', 'o', 'p', 'q', 'c'};
        PaginationHelper<Character> pageHelperChar = new PaginationHelper<>(List.of(chars), 4);

        //First parameter is what is expected, the second is the function that produces the actual result

        //Test out of range
        assertEquals(-1, pageHelper.pageIndex(50));
        assertEquals(-1, pageHelper.pageIndex(-100));
        assertEquals(-1, pageHelperEmpty.pageIndex(0));

        //Test in range
        assertEquals(0, pageHelper.pageIndex(1));
        assertEquals(2, pageHelper.pageIndex(4));
        assertEquals(1, pageHelper.pageIndex(3));
        assertEquals(0, pageHelper.pageIndex(0));

        //Test out of range
        assertEquals(-1, pageHelperChar.pageIndex(50));
        assertEquals(-1, pageHelperChar.pageIndex(-100));

        //Test in range
        assertEquals(3, pageHelperChar.pageIndex(13));
        assertEquals(2, pageHelperChar.pageIndex(10));
        assertEquals(1, pageHelperChar.pageIndex(4));
        assertEquals(0, pageHelperChar.pageIndex(0));
        assertEquals(0, pageHelperChar.pageIndex(1));
        assertEquals(3, pageHelperChar.pageIndex(14));
        assertEquals(3, pageHelperChar.pageIndex(12));
        assertEquals(2, pageHelperChar.pageIndex(11));
    }
}