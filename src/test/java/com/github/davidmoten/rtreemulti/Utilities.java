package com.github.davidmoten.rtreemulti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.github.davidmoten.rtreemulti.geometry.Rectangle;

public class Utilities {

    static List<Entry<Object, Rectangle>> entries1000(Precision precision) {
        List<Entry<Object, Rectangle>> list = new ArrayList<Entry<Object, Rectangle>>();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(BenchmarksRTree.class.getResourceAsStream("/1000.txt")));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] items = line.split(" ");
                double x = Double.parseDouble(items[0]);
                double y = Double.parseDouble(items[1]);
                Entry<Object, Rectangle> entry;
                if (precision == Precision.DOUBLE)
                    entry = Entry.entry(new Object(), Rectangle.create(x, y, x + 1, y + 1));
                else
                    entry = Entry.entry(new Object(), Rectangle.create((float) x, (float) y,
                            (float) x + 1, (float) y + 1));
                list.add(entry);
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
