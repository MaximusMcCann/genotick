package com.alphatica.genotick.data;

import com.alphatica.genotick.ui.UserInputOutputFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@SuppressWarnings("WeakerAccess")
public class DataUtils {

    public static List<String> listFiles(final String extension, final String... paths) {
        List<String> list = new ArrayList<>();
        for(String path: paths) {
            list.addAll(namesFromPath(path,extension));
        }
        return list;
    }

    private static List<String> namesFromPath(String path, final String extension) {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        if(file.isDirectory()) {
            list.addAll(getFullPaths(path,extension));
        } else {
            list.add(path);
        }
        return list;
    }

    private static List<String> getFullPaths(String path, final String extension) {
        File directory = new File(path);
        String[] names = getFilesNames(extension, directory);
        List<String> list = new ArrayList<>();
        for(String name: names) {
            list.add(path + File.separator + name);
        }
        return list;
    }

    private static String[] getFilesNames(String extension, File directory) {
        String[] list = directory.list((dir, name) -> name.endsWith(extension));
        if (isNull(list)) {
            UserInputOutputFactory.getUserOutput().errorMessage("Unable to list files ");
            throw new DataException("Unable to list files in " + directory.getAbsolutePath());
        }
        return list;
    }

    public static List<Number[]> createLineList(BufferedReader br) {
        List<Number[]> list = new ArrayList<>();
        int linesRead = 1;
        try {
            String line = br.readLine();
            processFirstLine(line, list);
            linesRead++;
            while ((line = br.readLine())!=null){
                linesRead++;
                Number[] row = processLine(line);
                list.add(row);
            }
            return list;
        } catch(IOException | NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            throw new DataException("Error reading line " + linesRead, ex);
        }
    }

    private static void processFirstLine(String line, List<Number[]> list) {
        validateFirstLine(line);
        try {
            Number[] row = processLine(line);
            list.add(row);
        } catch (NumberFormatException ignore) {
            /* If it's the first line then it's probably just a heading. Let's ignore NFE */
        }
    }


    public static Number[] processLine(String line) {
        String separator = ",";
        String[] fields = line.split(separator);
        Number[] array = new Number[fields.length];
        String timePointString = getTimePointString(fields[0]);
        array[0] = Long.valueOf(timePointString);
        for(int i = 1; i < fields.length; i++) {
            array[i] = Double.valueOf(fields[i]);
        }
        return array;
    }

    public static String getTimePointString(String field) {
        if(field.contains("-"))
            return field.replaceAll("-","");
        else
            return field;

    }

    private static void validateFirstLine(String line) {
        if(isNull(line)) {
            UserInputOutputFactory.getUserOutput().errorMessage("Unable to read line or file empty");
            throw new DataException("Unable to read line or file empty");
        }
    }

}
