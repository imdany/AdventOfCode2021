package com.imdany.utils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {

    private final String resourceName;
    private final URL resource;
    private final String path;
    private final BufferedReader reader;

    public ResourceReader(String resourceName) throws FileNotFoundException {
        this.resourceName = resourceName;
        this.resource = this.getClass().getResource(resourceName);
        this.path = this.resource.getPath();

        System.out.println("Getting resouce: " + this.path);
        InputStream inputStream = new FileInputStream(this.path);
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        this.reader = new BufferedReader(streamReader);
    }

    public List<Integer> resourceToListInt() throws IOException {
        List<Integer> data = new ArrayList<Integer>();
        String line;
        while ((line = reader.readLine()) != null) {
            data.add(Integer.valueOf(line));
        }
        System.out.println("Elements loaded: " + data.size());
        return data;
    }

    public List<String> resourceToListString() throws IOException {
        List<String> data = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            data.add(line);
        }
        System.out.println("Elements loaded: " + data.size());
        return data;
    }
}
