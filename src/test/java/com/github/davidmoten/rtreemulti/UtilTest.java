package com.github.davidmoten.rtreemulti;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import com.github.davidmoten.guavamini.Lists;
import com.github.davidmoten.junit.Asserts;
import com.github.davidmoten.rtreemulti.geometry.Point;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import com.github.davidmoten.rtreemulti.internal.Util;

public class UtilTest {

    private static final double PRECISION = 0.00001;

    @Test
    public void coverPrivateConstructor() {
        Asserts.assertIsUtilityClass(Util.class);
    }

    @Test
    public void testMbrWithNegativeValues() {
        Rectangle r = Rectangle.create(-2D, -2, -1, -1);
        Rectangle mbr = Util.mbr(Collections.singleton(r));
        assertEquals(r, mbr);
        System.out.println(r);
    }

    @Test
    public void testMbr() {
        Rectangle a = Point.create(38.9, 23.9);
        Rectangle b = Point.create(39.75, 25.25);
        Rectangle c = Point.create(38.5, 22.25);
        Rectangle mbr = Util.mbr(Lists.newArrayList(a, b, c));
        assertEquals(38.5, mbr.min(0), PRECISION);
        assertEquals(39.75, mbr.max(0), PRECISION);
        assertEquals(22.25, mbr.min(1), PRECISION);
        assertEquals(25.25, mbr.max(1), PRECISION);
    }

}
