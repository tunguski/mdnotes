package pl.matsuo.mdnotes.model;

import lombok.Data;

@Data
public class MdNotesModel {

  Folder root = new Folder();

  String currentPath;
}
