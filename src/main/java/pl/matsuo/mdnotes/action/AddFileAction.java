package pl.matsuo.mdnotes.action;

import static pl.matsuo.core.util.collection.CollectionUtil.toMap;
import static pl.matsuo.core.util.collection.Pair.pair;
import static pl.matsuo.core.util.desktop.IRequest.request;

import pl.matsuo.core.util.desktop.IActionController;
import pl.matsuo.core.util.desktop.IRequest;
import pl.matsuo.mdnotes.model.MdNotesModel;

public class AddFileAction implements IActionController<IRequest, MdNotesModel> {

  private int index = 0;

  @Override
  public IRequest execute(IRequest iRequest, MdNotesModel mdNotesModel) {
    String fileName = "new-file-" + index++;
    mdNotesModel.getRoot().getFiles().put(fileName, "happy content!");

    return request("/", toMap(pair("rename", fileName)));
  }
}
