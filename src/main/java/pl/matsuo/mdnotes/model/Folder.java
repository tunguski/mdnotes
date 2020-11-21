package pl.matsuo.mdnotes.model;

import java.util.SortedMap;
import java.util.TreeMap;
import lombok.Data;

@Data
public class Folder {

  final SortedMap<String, Folder> folders = new TreeMap<>();
  final SortedMap<String, String> files = new TreeMap<>();
  boolean expanded = true;

  public File getFile(String fileName) {
    if (fileName == null || fileName.isEmpty()) {
      return null;
    } else {
      if (fileName.contains("/")) {
        String[] split = fileName.split("[/]", 2);
        return getFolders().get(split[0]).getFile(split[1]);
      } else {
        SortedMap<String, String> files = getFiles();
        if (files.containsKey(fileName)) {
          return new File(fileName, files.get(fileName), this);
        } else {
          return null;
        }
      }
    }
  }

  public Folder getFolder(String path) {
    if (path == null || path.isEmpty()) {
      return this;
    } else {
      if (path.contains("/")) {
        String[] split = path.split("[/]", 2);

        if (getFolders().containsKey(split[0])) {
          return getFolders().get(split[0]);
        } else {
          return null;
        }
      } else {

        if (getFolders().containsKey(path) || getFiles().containsKey(path)) {
          return getFolders().get(path);
        } else {
          return null;
        }
      }
    }
  }
}
