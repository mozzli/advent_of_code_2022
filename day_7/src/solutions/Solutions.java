package solutions;

import java.util.ArrayList;

public class Solutions {

    private Directory currentDirectory = null;
    private final ArrayList<Directory> DIRECTORY_LIST = new ArrayList<>();
    private final int DISK_SPACE = 70000000;
    private final int NEEDED_DISK_SPACE = 30000000;

    public int getDataSize(ArrayList<ArrayList<String>> commands) {
        int dataSize = 0;
        for (ArrayList<String> command : commands) {
            switch (command.get(0)) {
                case "$" -> fileCommand(command);
                case "dir" -> {
                    Directory newDirectory = new Directory(currentDirectory, command.get(1));
                    currentDirectory.addSubDirectory(newDirectory);
                    DIRECTORY_LIST.add(newDirectory);
                }
                default -> currentDirectory.increaseSize(Integer.parseInt(command.get(0)));
            }
        }
        for (Directory value : DIRECTORY_LIST) {
            if (value.getSize() <= 100000) {
                dataSize += value.getSize();
            }
        }
        return dataSize;
    }

    private void fileCommand(ArrayList<String> command) {
        if ("cd".equals(command.get(1))) {
            changeDirectory(command.get(2));
        }
    }

    private void changeDirectory(String name) {
        switch (name) {
            case ".." -> currentDirectory = currentDirectory.getParentDirectory();
            case "/" -> currentDirectory = new Directory(null, "/");
            default -> currentDirectory = currentDirectory.getSubDirectory(name);
        }
    }

    private void resetInitialValues() {
        currentDirectory = null;
        DIRECTORY_LIST.clear();
    }

    public int getFileToDeleteSize(ArrayList<ArrayList<String>> commands) {
        resetInitialValues();
        getDataSize(commands);
        int dataSize = 0;
        int lowestFileDifference = NEEDED_DISK_SPACE;
        int lowestFileSize = 0;
        for (ArrayList<String> command: commands){
            if (!command.get(0).equals("$") && !command.get(0).equals("dir")){
                dataSize += Integer.parseInt(command.get(0));
            }
        }
        int freeSpace = DISK_SPACE - dataSize;
        int sizeToDelete = NEEDED_DISK_SPACE - freeSpace;
        for (Directory value : DIRECTORY_LIST){
            if (value.getSize()>sizeToDelete && value.getSize() - sizeToDelete < lowestFileDifference){
                lowestFileDifference = value.getSize() - sizeToDelete;
                lowestFileSize = value.getSize();
                }
            }
        return lowestFileSize;
    }
}

