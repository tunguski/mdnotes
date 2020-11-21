package pl.matsuo.mdnotes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class File {

  String name;
  String content;
  Folder parent;
}
