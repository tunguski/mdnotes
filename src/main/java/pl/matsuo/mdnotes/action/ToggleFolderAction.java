package pl.matsuo.mdnotes.action;

import static java.util.Collections.emptyMap;
import static pl.matsuo.core.util.desktop.mvc.IRequest.request;

import pl.matsuo.core.util.desktop.mvc.IActionController;
import pl.matsuo.core.util.desktop.mvc.IRequest;
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
