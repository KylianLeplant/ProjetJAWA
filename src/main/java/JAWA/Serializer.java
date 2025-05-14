package JAWA;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;

public class Serializer {
    private File file;

    public Serializer(String filePath) {
        this.file = new File(filePath);
    }

    //write on a new line
    public void writeLine(String line) {
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardOpenOption.APPEND)) {
            writer.write(line);
            writer.newLine();
            System.out.println("Data saved\n");
        } catch (IOException e) {
            System.err.println("Error writing in file :\n    " + line + "\n    " + e.getMessage() + "\n");
        }
    }

    public String readLastLine() {
        List<String> lines = readList();  // Get all lines once
        if (lines != null && !lines.isEmpty()) {
            return lines.getLast();  // Get the last line
        } else {
            System.out.println("The file is empty\n");
            return null;
        }
    }

    public void deleteLine() {
        List<String> lines = readList();  // Get all lines once
        if (lines != null && !lines.isEmpty()) {
            lines.removeLast();
            try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardOpenOption.APPEND)) {
                for (String line : lines) {
                    writer.write(line);
                }
                System.out.println("Last line deleted\n");
            } catch (IOException e) {
                System.err.println("Error rewriting file: " + e.getMessage());
            }
        } else {
            System.out.println("The file is empty\n");
        }
    }

    public void modifyLine(int id, String line){
        try {
            List<String> lines = readList();
            int index = getIndexLine(id);
            lines.set(index, line);
            Files.write(file.toPath(), lines);
            System.out.println("Line modified\n");
        }
        catch(IOException e){
            System.out.println("Error rewriting file: " + e.getMessage());
        }
    }

    //Get all lines in a list
    public List<String> readList() {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return null;
        }
    }

    public List<String> readList(int from, int to){
        int indexFrom = getIndexLine(from);
        int indexTo = getIndexLine(to);
        List<String> lines = readList();
        List<String> linesFromTo = new ArrayList<>();
        if (indexFrom == -1 || indexTo == -1){
            System.err.println("Error, id doesn't exist in the file");
            return linesFromTo;
        }
        if (indexFrom > indexTo) {
            System.err.println("Error : 'from' index should be less than or equal to 'to' index.");
            return linesFromTo;  //Return an empty list in case of error
        }
        for (int i = indexFrom; i <= indexTo; i++){
            String toAdd = lines.get(i);
            linesFromTo.add(toAdd);
        }
        return linesFromTo;
    }

    public void deleteLine(int id) {
        List<String> lines = readList();
        int index = getIndexLine(id);
        if (index == -1){
            System.err.println("Error, id doesn't exist in the file");
        }
        if (lines != null && !lines.isEmpty() && index >= 0 && index < lines.size()) {
            lines.remove(index);
            try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardOpenOption.APPEND)){
                for (String line : lines) {
                    writer.write(line); //Rewrite the file after de deletion
                    writer.newLine(); //hop to the next line
                }
            }
            catch (IOException e) {
                System.err.println("Error rewriting file: " + e.getMessage());
            }
            System.out.println("Line at index " + index + " deleted\n");
        } else {
            System.out.println("The file is empty or the index is out of bounds\n");
        }
    }

    //return -1 if id not found
    public int getIndexLine(int id){
        List<String> lines = readList();
        int index = 0;
        for (String line : lines){
            String foundId = "";
            int i = 0;
            while (i < line.length() && line.charAt(i) != ','){
                foundId += line.charAt(i);
                i++;
            }
            try {
                int iFoundId = Integer.parseInt(foundId);
                if (iFoundId == id) return index;
            }
            catch (NumberFormatException e){
                System.out.println("Error : invalid id.");
            }
            index++;
        }
        return -1;
    }

}