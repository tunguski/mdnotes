package pl.matsuo.mdnotes.action;

import static java.util.Collections.emptyMap;
import static pl.matsuo.core.util.desktop.IRequest.request;

import com.google.common.collect.ImmutableMap;
import pl.matsuo.core.util.desktop.IActionController;
import pl.matsuo.core.util.desktop.IRequest;
import pl.matsuo.mdnotes.model.File;
import pl.matsuo.mdnotes.model.MdNotesModel;

public class RenameFileAction implements IActionController<IRequest, MdNotesModel> {

  @Override
  public IRequest execute(IRequest iRequest, MdNotesModel model) {
    String name = iRequest.getParam("name");
    String newName = iRequest.getParam("new_name");

    File file = model.getRoot().getFile(name);
    if (file != null) {
      model.getRoot().getFiles().put(newName, file.getContent());

      return request("/", emptyMap());
    } else {
      return request("/", ImmutableMap.of("error_message", "File not found: " + name));
    }
  }
}
