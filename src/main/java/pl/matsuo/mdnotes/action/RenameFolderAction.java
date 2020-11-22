package pl.matsuo.mdnotes.action;

import static java.util.Collections.emptyMap;
import static pl.matsuo.core.util.desktop.mvc.IRequest.request;

import pl.matsuo.core.util.desktop.mvc.IActionController;
import pl.matsuo.core.util.desktop.mvc.IRequest;
import pl.matsuo.mdnotes.model.Folder;
import pl.matsuo.mdnotes.model.MdNotesModel;

public class RenameFolderAction implements IActionController<IRequest, MdNotesModel> {

  @Override
  public IRequest execute(IRequest iRequest, MdNotesModel mdNotesModel) {
    String name = iRequest.getParam("name");
    String newName = iRequest.getParam("new_name");

    Folder content = mdNotesModel.getRoot().getFolders().remove(name);
    mdNotesModel.getRoot().getFolders().put(newName, content);

    return request("/", emptyMap());
  }
}
