package pl.matsuo.mdnotes.view;

import static j2html.TagCreator.text;
import static j2html.TagCreator.textarea;

import j2html.tags.ContainerTag;
import j2html.tags.Text;
import java.util.SortedMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.events.Event;
import org.w3c.dom.html.HTMLTextAreaElement;
import pl.matsuo.core.util.desktop.PersistResult;
import pl.matsuo.core.util.desktop.mvc.IActiveMonitor;
import pl.matsuo.core.util.desktop.mvc.IRequest;
import pl.matsuo.core.util.desktop.mvc.IView;
import pl.matsuo.mdnotes.component.ViewTemplate;
import pl.matsuo.mdnotes.model.File;
import pl.matsuo.mdnotes.model.Folder;
import pl.matsuo.mdnotes.model.MdNotesModel;

@Slf4j
@RequiredArgsConstructor
@PersistResult(interval = 5)
public class MdNotesMainView
    implements IView<IRequest, MdNotesModel>, IActiveMonitor<MdNotesModel> {

  final ViewTemplate template;

  @Override
  public ContainerTag view(IRequest request, MdNotesModel model) {
    String path = request.hasParam("name") ? request.getParam("name") : model.getCurrentPath();
    model.setCurrentPath(path);
    return template.view(
        request, model, textarea(getContent(path, model.getRoot())).withName("file_content"));
  }

  private Text getContent(String fileName, Folder folder) {
    if (fileName == null || fileName.isEmpty()) {
      return text("Choose a file");
    } else {
      if (fileName.contains("/")) {
        String[] split = fileName.split("[/]");
        return getContent(split[1], folder.getFolders().get(split[0]));
      } else {
        SortedMap<String, String> files = folder.getFiles();
        if (files.containsKey(fileName)) {
          return text(files.get(fileName));
        } else if (!files.isEmpty()) {
          return text(files.get(files.firstKey()));
        } else {
          return null;
        }
      }
    }
  }

  @Override
  public boolean onChange(String inputName, Event ev, MdNotesModel model) {
    if (inputName.equals("file_content")) {
      HTMLTextAreaElement target = (HTMLTextAreaElement) ev.getTarget();
      File file = model.getRoot().getFile(model.getCurrentPath());
      if (!file.getContent().equals(target.getValue())) {
        file.getParent().getFiles().put(file.getName(), target.getValue());
        return true;
      }
    }

    return false;
  }
}
