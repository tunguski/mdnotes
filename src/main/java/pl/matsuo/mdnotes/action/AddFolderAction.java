package pl.matsuo.mdnotes.action;

import static pl.matsuo.core.util.collection.CollectionUtil.toMap;
import static pl.matsuo.core.util.collection.Pair.pair;
import static pl.matsuo.core.util.desktop.IRequest.request;

import pl.matsuo.core.util.desktop.IActionController;
import pl.matsuo.core.util.desktop.IRequest;
import pl.matsuo.mdnotes.model.Folder;
import pl.matsuo.mdnotes.model.MdNotesModel;

public class AddFolderAction implements IActionController<IRequest, MdNotesModel> {

  private int index = 0;

  @Override
  public IRequest execute(IRequest iRequest, MdNotesModel mdNotesModel) {
    String folderName = "new-folder-" + index++;
    mdNotesModel.getRoot().getFolders().put(folderName, new Folder());

    return request("/", toMap(pair("rename_folder", folderName)));
  }
}
