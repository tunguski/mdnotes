package pl.matsuo.mdnotes.model;

import lombok.Data;

@Data
public class MdNotesModel {

  Folder root = new Folder();

  public MdNotesModel() {
    root.getFolders().put("test", new Folder());
    root.getFolders().get("test").getFiles().put("test-one", "content!");
    root.getFolders().get("test").getFiles().put("test-two", "content! two!");
    root.getFiles().put("test-one", "content!");
    root.getFiles().put("test-two", "content! two!");
  }
}
