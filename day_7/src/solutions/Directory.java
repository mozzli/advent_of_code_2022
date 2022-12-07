package solutions;

import java.util.ArrayList;

public class Directory {

    int size = 0;
    Directory parentDirectory;
    ArrayList<Directory> subDirectories = new ArrayList<>();
    String name;

    public Directory(Directory parentDirectory, String name) {
        this.parentDirectory = parentDirectory;
        this.name = name;
    }

    public void addSubDirectory(Directory subDirectory) {
        subDirectories.add(subDirectory);
    }

    public void increaseSize(int newSize) {
        size += newSize;
        if (parentDirectory != null) {
            parentDirectory.increaseSize(newSize);
        }
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public Directory getSubDirectory(String subName) {
        for (Directory directory : subDirectories) {
            if (directory.getName().equals(subName)) {
                return directory;
            }
        }
        return null;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

}
