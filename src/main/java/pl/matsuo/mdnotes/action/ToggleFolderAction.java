package pl.matsuo.mdnotes.action;

import static java.util.Collections.emptyMap;
import static pl.matsuo.core.util.desktop.IRequest.request;

import pl.matsuo.core.util.desktop.IActionController;
import pl.matsuo.core.util.desktop.IRequest;
import pl.matsuo.mdnotes.model.Folder;
import pl.matsuo.mdnotes.model.MdNotesModel;

public class ToggleFolderAction implements IActionController<IRequest, MdNotesModel> {

  @Override
  public IRequest execute(IRequest iRequest, MdNotesModel mdNotesModel) {
    String name = iRequest.getParam("name");

    Folder folder = mdNotesModel.getRoot().getFolders().get(name);
    folder.setExpanded(!folder.isExpanded());

    return request("/", emptyMap());
  }
}
